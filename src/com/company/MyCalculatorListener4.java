package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculatorListener4 implements ActionListener {

    public void passwd(){

    }

    private TextField txt1=null;
    private TextField txt2=null;
    private TextField txt3=null;
    public MyCalculatorListener4(TextField txt, TextField txt2, TextField txt3) {
        this.txt1=txt;
        this.txt2=txt2;
        this.txt3=txt3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sqldb sdb = new sqldb();
        event eve = new event();
        Main main = new Main();
        String username = txt1.getText();
        String passwd = txt2.getText().toString();
        String passwd2 = txt3.getText().toString();
        System.out.println(username);
        if(sdb.getDuplicateID(username)){
            JOptionPane.showMessageDialog(null, "相同的用户已存在，请更换用户名！", "错误",JOptionPane.ERROR_MESSAGE);
        }else if(username.length()==0||passwd.length()==0){
            JOptionPane.showMessageDialog(null, "账号或密码不能为空！", "错误",JOptionPane.ERROR_MESSAGE);
        }else if(passwd.length() < 6){
            JOptionPane.showMessageDialog(null, "密码不能少于6位数！", "错误",JOptionPane.ERROR_MESSAGE);
        }else if(passwd2.length() ==0){
            JOptionPane.showMessageDialog(null, "请再一次输入密码！", "错误",JOptionPane.ERROR_MESSAGE);
        }else if(!passwd.equals(passwd2)){
            JOptionPane.showMessageDialog(null, "第二次密码与第一次不相同！", "错误",JOptionPane.ERROR_MESSAGE);
        }
        if(passwd.equals(passwd2)  && passwd.length()>=6&& username.length()>=6 && !sdb.getDuplicateID(username)){
            int id = sdb.getLastId();
            sdb.getInsert(id,username,passwd);
            JOptionPane.showMessageDialog(null, "注册成功，你的ID是"+id+"你的用户名是"+username+"。", "注册成功",JOptionPane.ERROR_MESSAGE);
            main.getFrame2().setVisible(false);
            main.getFrame().setVisible(true);
        }
    }
}
