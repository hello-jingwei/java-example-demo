package com.myio.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Selector02 extends Thread{
    public static void main(String[] args) {
        new Thread(new Selector02()).start();
        new Thread(new Selector02()).start();
        new Thread(new Selector02()).start();
        new Thread(new Selector02()).start();
        new Thread(new Selector02()).start();

    }

    @Override
    public void run() {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);

            writeBuffer.put((Thread.currentThread().getName() + "-hello").getBytes());
            writeBuffer.flip();

            while (true) {
                Thread.sleep(2000);
                writeBuffer.rewind();
                socketChannel.write(writeBuffer);
                readBuffer.clear();
                socketChannel.read(readBuffer);
            }
        } catch (IOException | InterruptedException e) {
        }
    }
}
