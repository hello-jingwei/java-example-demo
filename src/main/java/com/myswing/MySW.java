package com.myswing;

import javax.swing.*;
import java.awt.*;

public class MySW {
    public static void main(String[] agrs) {
        test1();
    }

    public static void test1() {
        JFrame frame = new JFrame("Java文本框组件示例");    //创建Frame窗口
        JPanel jp = new JPanel();    //创建面板
        JTextField txtfield1 = new JTextField();    //创建文本框
        txtfield1.setText("普通文本框");    //设置文本框的内容
        JTextField txtfield2 = new JTextField(28);
        txtfield2.setFont(new Font("楷体", Font.BOLD, 16));    //修改字体样式
        txtfield2.setText("指定长度和字体的文本框");
        JTextField txtfield3 = new JTextField(30);
        txtfield3.setText("居中对齐");
        txtfield3.setHorizontalAlignment(JTextField.CENTER);    //居中对齐
        jp.add(txtfield1);
        jp.add(txtfield2);
        jp.add(txtfield3);
        frame.add(jp);
        frame.setBounds(300, 200, 400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void test2() {
        JFrame frame = new JFrame("Java第三个GUI程序");    //创建Frame窗口
//        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());    //为Frame窗口设置布局为BorderLayout
//        JButton button1 = new JButton("上");
//        JButton button2 = new JButton("左");
//        JButton button3 = new JButton("中");
//        JButton button4 = new JButton("右");
        JButton button5 = new JButton("下");
//        frame.add(button1, BorderLayout.NORTH);
//        frame.add(button2, BorderLayout.WEST);
//        frame.add(button3, BorderLayout.CENTER);
//        frame.add(button4, BorderLayout.EAST);

        frame.add(button5, BorderLayout.SOUTH);
        frame.setBounds(300, 200, 600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        button5.setSize(frame.getWidth()-100,frame.getHeight()-100);
        button5.setBounds(0,0,frame.getWidth()-100,frame.getHeight()-100);

    }
}
