package com.util.datetime;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static void main(String[] args) {


//        try {
//            calcSecondInterval("2021-05-13 18:45:03");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    public static int calcSecondInterval(String time) throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date dateTime = simpleFormat.parse(time);
        Date curTime = simpleFormat.parse(getCurrentDateTime());
        long dateTimestamp = dateTime.getTime();
        long curtTimestamp = curTime.getTime();
        return  (int) ((curtTimestamp - dateTimestamp) / 1000);
    }

    public static String getCurrentDateTime() {
        Date date = new Date();
        // 转换提日期输出格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
