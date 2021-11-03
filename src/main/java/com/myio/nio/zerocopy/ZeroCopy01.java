package com.myio.nio.zerocopy;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

@Slf4j
public class ZeroCopy01 {

    public static void main(String[] args) {
        new ZeroCopy01().zct01();
    }

    public void zct01() {
        File file = new File("E:/wjw-workspace/personal-project/javabasic/src/main/java/com/myio/nio/zerocopy/zc01.txt");
        long len = file.length();
        byte[] ds = new byte[(int)len];
        try (FileChannel fileChannel = new RandomAccessFile(file, "r").getChannel()) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, len);
            for (int offset = 0; offset < len; offset++) {
                byte b = mappedByteBuffer.get();
                ds[offset] = b;
            }

            Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");
            while (scan.hasNext()) {
                log.info(scan.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
