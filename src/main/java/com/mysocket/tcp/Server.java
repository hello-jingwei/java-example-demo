package com.mysocket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 * 聊天室服务端
 * @author Administrator
 *
 */
public class Server {
    /*
     * java.net.ServerSocket
     * 运行在服务端的ServerSocket主要有两个作用
     * 1:申请服务端口
     * 2:监听服务端口,一旦一个客户通过该端口建立连接,
     * 则创建一个Socket用于与该客户通讯
     */
    private ServerSocket server;
    /*
     * time:2017/3/23/15:14
     * 该集合用来存放所有客户端的输出流,用于 将消息
     * 广播给所有客户
     */
    private List<PrintWriter> allOut;

    public Server() throws IOException{
        /*
         * time:2017/3/22
         * 初始化ServerSocket的同时需要指定服务器的端口,
         * 该端口号不能与系统其它应用程序已经申请的端口号重复,
         * 否则会抛出异常.
         */
        server = new ServerSocket(8088);
        /*
         * time:2017/3/23/15:16
         * 初始化allOut
         */
        allOut = new ArrayList<>();
    }

    public void start(){
        try {
            /*
             * ServerSocket提供方法:
             * Socket accept()
             * 该方法会监听ServerSocket申请的服务端口.
             * 这是一个阻塞方法,直到一个客户端通过该端口连接
             * 才会返回一个Socket,这个返回的Socket是用
             * 于与连接的客户端进行通讯的
             */

            /*
             * time:2017/3/22
             *
             */
//            while(true){

                /*
                 * while(true)
                 * 增加于2017/3/23/10:46,在InputStream(flag处做的移动)移动之后做出改变
                 */
                System.out.println("等待客户端连接...");
                Socket socket = server.accept();
                System.out.println("一个客户端连接了");

                /*
                 * time:2017/3/23/9:21
                 * 启动一个线程与该客户机交互,用于调用一个Handler线程(ClientHandler内部类)
                 */
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
//            }
            //flag
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将给定的消息广播给所有人
     * @param message
     */
    private void  sendMessage(String message){
        synchronized (allOut) {
            //转发给所有客户端
            for (PrintWriter o : allOut) {
                o.println(message);
                System.out.println(message);
            }
        }
    }
    public static void main(String[] args) {
        try {
            /*
             * time:2017/3/22
             */
            Server server = new Server();
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * time:2017/3/23/10:38
     * 该线程用用来完成指定与指定客户机的交互工作
     *
     */
    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;
        public ClientHandler(Socket socket){
            this.socket = socket;
            /*
             * 远程计算机的地址信息,这里是客户端的地址
             */
            InetAddress address = socket.getInetAddress();

            /*
             * time:2017/3/23/11:31
             * 获取远程计算机IP地址的字符串格式
             */
            host = address.getHostAddress();
        }


        public void run() {
            PrintWriter pw = null;
            try {
                /*
                 * time:2017/3/23/9:21
                 * 从flag处移动到此处,改变于2017/3/23/10:44
                 *
                 * InputStream getInputStream()
                 * Socket提供的该方法可以获取一个输入流
                 * 通过该客户端获取远程计算机发送过来的信息
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"utf-8");
                BufferedReader br = new BufferedReader(isr);

                /*
                 * time:2017/3/23/14:53
                 * 通过Socket获取输出流,用于将数据发送给客户端(Client)
                 */
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
                pw = new PrintWriter(osw,true);

                /*
                 * time:2017/3/23/15:19
                 * 将客户端的输出流存入到共享集合中
                 * 调哪个对象的方法,就把谁锁上
                 * 即:调allOut的方法,就把allOut锁上
                 */
                synchronized (allOut) {
                    allOut.add(pw);
                }

                /*
                 * message = null;
                 * 表示读到文件末尾,在while里判定它不等于null才输出
                 */
                sendMessage(host + "上线了,当前在线"+allOut.size()+"人");
                String message = null;
                while((message = br.readLine()) != null){
                    /*
                     * time:2017/3/23/10:27
                     * 用于反复接收
                     */
//             message = br.readLine();
//             System.out.println(host+"说:"+message);
//             pw.println(host+"说:"+message);
                    /*
                     * time:2017/3/23/15:27
                     * 转发给所有客户端
                     */
                    sendMessage(host + "说:" + message);
                }
            } catch (Exception e) {

            } finally {
                /*
                 * time:2017/3/23/11:42
                 * 在最后,处理客户端下线信息
                 */
                synchronized(allOut){//将该客户的输出流从共享的集合中删除,time:2017/3/23/15:36
                    allOut.remove(pw);
                }

                sendMessage(host+"下线了,当前在线"+allOut.size()+"人");
                if(socket != null){
                    try {
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}