package com.myio.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Channel01 {

    public FileChannel buildChannel(String filePath) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filePath,"rw");
        return raf.getChannel();

    }
}
