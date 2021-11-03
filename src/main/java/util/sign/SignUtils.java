package util.sign;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
public class SignUtils extends AbstractJavaSamplerClient {

    /**
     * sign生成规则：appId+secretKey+timestamp+others parameter 按ASCII排序，MD5加密
     */
    public static void main(String[] args) {
//        SortedMap<Object, Object> parameters = new TreeMap<>();
//        parameters.put("appId", "4b0a9da528774835b7d56c80548d207d");
//        parameters.put("secretKey", "9a8bef5f478d4edd9144f836ccb1c935");
//        parameters.put("timestamp", 1630465782323L);
//        parameters.put("signature", "12BE1C6A2E1E019140C461D3EE9CCF63");
//        // others Parameter
//        parameters.put("name", "中国");

        createSign(toSortedMap("{\"id\":\"1\",\"name\":\"张三\"}"));
    }


    /**
     * 将JSONObject转换成升序Map
     *
     * @param jsonString
     * @return SortedMap 按ASCII码升序排列
     * @explain 将参数按照第一个字符的键值 ASCII 码递增排序（字母升序排序），如果遇到相同字符则按照第二个字符的键值 ASCII 码递增排序，
     * 以此类推通过SortedMap可以实现
     */
    public static SortedMap<Object, Object> toSortedMap(String jsonString) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        // 用于存储接收到的key:value，并按key以ASCII码进行升序排列组合
        SortedMap<Object, Object> data = new TreeMap<>();
        // 获取json对象中的键
        Set<String> keySet = jsonObject.keySet();
        Object key = "";
        Object value = null;
        // 遍历json数据，添加到SortedMap对象
        for (String s : keySet) {
            key = s;
            value = jsonObject.get(key);
            data.put(key, value);
        }
        return data;
    }


    public static String createSign(SortedMap<Object, Object> parameters) {
        StringBuilder sb = new StringBuilder();
        //所有参与传参的参数按照ascii排序（升序）
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (!"signature".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        String sign = Md5Util.md5Encode(sb.toString(), StandardCharsets.UTF_8.toString()).toUpperCase();
        log.info("我的签名是：{}", sign);
        return sign;
    }

    public static String createSign(String jsonString) {
        SortedMap<Object, Object> parameters = toSortedMap(jsonString);
        StringBuilder sb = new StringBuilder();
        //所有参与传参的参数按照ascii排序（升序）
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (!"signature".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        String sign = Md5Util.md5Encode(sb.toString(), StandardCharsets.UTF_8.toString()).toUpperCase();
        log.info("我的签名是：{}", sign);
        return sign;
    }

    @Override
    public Arguments getDefaultParameters() {
        Arguments arguments = new Arguments();
        arguments.addArgument("appId", "f0242dc63de64c40b5030d4dddea35b8");
        arguments.addArgument("secretKey", "a22d515c602045ba8aa92de5db875933");
        arguments.addArgument("timestamp", String.valueOf(System.currentTimeMillis()));
        return arguments;
    }

    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        String appId = javaSamplerContext.getParameter("appId");
        String secretKey = javaSamplerContext.getParameter("secretKey");
        String timestamp = javaSamplerContext.getParameter("timestamp");
        SampleResult sampleResult = new SampleResult();
        sampleResult.setSampleLabel("签名Jmeter测试");
        // 开始
        sampleResult.sampleStart();
        // 创建签名
        SortedMap<Object, Object> parameters = new TreeMap<>();
        parameters.put("appId", appId);
        parameters.put("secretKey", secretKey);
        parameters.put("timestamp", timestamp);
        String signature = createSign(parameters);
        // 设置响应
        sampleResult.setResponseData(signature, StandardCharsets.UTF_8.toString());
        sampleResult.setDataType(SampleResult.TEXT);
        return sampleResult;
    }
}
