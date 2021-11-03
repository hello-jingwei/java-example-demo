package com.myshell;

import java.io.IOException;
import java.time.LocalDate;

public class CMD01 {
    public static void main(String[] args) {
        try {
            String localData = LocalDate.now().toString().replace("-","");
            Runtime.getRuntime().exec(String.format("cmd.exe /c mysqldump -uroot -p123456 ruoyi --default-character-set=utf8 >  d:\\ruoyi%s.sql",localData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
