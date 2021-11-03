package com.myfile.test;

import java.io.File;
import java.util.Objects;

public class FileNameBatchReplace {
    public static void main(String[] args) {
        String fileNamePrefix = "E:/wjw-workspace/personal-project/tensquare_parent84";
        batchReplace(fileNamePrefix);
    }

    public static void batchReplace(String curFileName) {

        File file = new File(curFileName);
        File[] list = file.listFiles();
        // 如果目录下文件存在
        if (Objects.nonNull(list)) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].getName().contains("【十次方禁广告闲聊讨论群863676367】")) {
                    String newFileName = renameFile(curFileName ,list[i],"【十次方禁广告闲聊讨论群863676367】");
//                    String fileName = curFileName + "/" + list[i].getName();
                    if(new File(newFileName).isDirectory()) {
                        batchReplace(newFileName);
                    }
                } else if(list[i].getName().contains("_十次方学习禁广告闲聊群863676367【十次方禁广告闲聊讨论群863676367】")){
                    String newFileName2 = renameFile(curFileName, list[i],"_十次方学习禁广告闲聊群863676367【十次方禁广告闲聊讨论群863676367】");
                    if(new File(newFileName2).isDirectory()) {
                        batchReplace(newFileName2);
                    }
                } else if (list[i].getName().contains("_十次方学习禁广告闲聊群863676367")){
                    String newFileName3 = renameFile(curFileName, list[i],"_十次方学习禁广告闲聊群863676367");
                    if(new File(newFileName3).isDirectory()) {
                        batchReplace(newFileName3);
                    }
                } else {
                    String fileName = curFileName + "/" + list[i].getName();
                    batchReplace(fileName);
                }
            }
        }
        if(file.isFile()) {
            renameFile(curFileName, file,"【十次方禁广告闲聊讨论群863676367】");
            renameFile(curFileName, file,"_十次方学习禁广告闲聊群863676367【十次方禁广告闲聊讨论群863676367】");
            renameFile(curFileName, file,"_十次方学习禁广告闲聊群863676367");
        }
    }

//    private static void getChildDirOrRenameFile(File file, String fileNamePrefix) {
//        String fileName = fileNamePrefix + "/" + file;
//        File childDir = new File(fileName);
//        File[] list = childDir.listFiles();
//        for (int i = 0; i < list.length; i++) {
//            if (list[i].isDirectory()) {
//                getChildDirOrRenameFile(list[i], fileName);
//            } else {
//                renameFile(fileName, list[i]);
//            }
//        }
//    }

    private static String renameFile(String fileNamePrefix, File file, String replaceStr) {
        //取文件名子存入name中
        String name = file.getName();
        System.out.println(name);
        String newName = name.replace(replaceStr, "");
        //重命名
        File dest = new File(fileNamePrefix + "/" + newName);
        file.renameTo(dest);
        return dest.getAbsolutePath();
    }
}
