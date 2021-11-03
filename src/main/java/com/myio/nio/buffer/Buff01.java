package com.myio.nio.buffer;

import com.myio.nio.channel.Channel01;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

public class Buff01 {
    Logger logger = LoggerFactory.getLogger(Buff01.class);
    private ByteBuffer getBuffer(){
        return ByteBuffer.allocate(50);
    }

    public String read(FileChannel fileChannel) {
        ByteBuffer buffer = getBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int bytesRead = fileChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while(buffer.hasRemaining()) {
                    stringBuilder.append((char)buffer.get());
                }
                // buffer满后需要清空，否则会内存溢出
                buffer.clear();
                bytesRead = fileChannel.read(buffer);
            }
            logger.info("rat.txt read: " + stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(Objects.nonNull(fileChannel)) {
                    fileChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Channel01 channel = new Channel01();
        FileChannel fileChannel = null;
        try {
            fileChannel = channel.buildChannel("E:\\wjw-workspace\\personal-project\\javabasic\\src\\main\\java\\com\\myio\\nio\\raf.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Buff01().read(fileChannel);
    }
}
