package com.mysocket.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    /*
     * java.net.Socket
     * 封装了TCP通讯协议,使用它与远程计算机进行网络通讯
     */
    private Socket socket;

    public Client() throws Exception {
        /*
         * time:2017/3/22
         * 实例化Socket是需要传入两个参数
         * 1:服务端IP地址
         * 2:服务器端口
         * 通过IP地址可以找到网络上的服务端所在的计算机
         * 通过端口可以连接高该计算机上的服务端应用程序
         *
         * 实例化Socket的过程就是建立连接的过程,所以若
         * 连接服务器失败,这里就会抛出异常
         */

        try {
            /*
             * time:2017/3/22
             */
            System.out.println("正在与服务器连接...");
            socket = new Socket("localhost", 8088);
            System.out.println("服务器连接成功");
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     * 客户端启动方法,从这里启动客户端逻辑
     */
    public void start() {
        try {
            /*
             * 从这里发送给server,让它去接收
             * 先用输出流发出去数据,再用服务机去接收
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
            PrintWriter pw = new PrintWriter(osw, true);

            /*
             * 启动读取服务发送过来的线程
             */
            ServerHandler handler = new ServerHandler();
            Thread t = new Thread(handler);
            t.start();
            Thread t_join = new Thread();

            Scanner scan = new Scanner(System.in);
            String say;
            while (true) {
                System.out.print("请讲话:");
                say = scan.nextLine();
                pw.println(say);
                /*
                 * 有true就不用flush
                 */
//          PrintWriter pw = new PrintWriter(osw,true);
//          pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * main:程序入口
     */
    public static void main(String[] args) {
        try {
            /*
             * time:2017/3/23/9:37
             * 定义了客户端启动方法
             */
            Client client = new Client();
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端启动失败");
        }
    }

    /*
     * 该线程用来循环接收服务端发送来的消息并输出到控制台
     */
    private class ServerHandler implements Runnable {

        @Override
        public void run() {
            try {
                /*
                 * time:2017/3/23/14:28
                 * 定义Handler,用于接收从Server返回的消息
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, "utf-8");
                BufferedReader br = new BufferedReader(isr);

                String message = null;
                while ((message = br.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (Exception e) {

            }
        }
    }

}