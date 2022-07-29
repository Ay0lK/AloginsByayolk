package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculatorListener implements ActionListener {
    private TextField txt1=null;
    private TextField txt2=null;
    public MyCalculatorListener(TextField txt, TextField txt2) {
        this.txt1=txt;
        this.txt2=txt2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userid = txt1.getText().toString();
        String passwd = txt2.getText().toString();
        System.out.println(userid +"\n"+passwd);
        event eve = new event();
        sqldb sdb = new sqldb();
        if(userid.length ()>=6 && passwd.length() !=0 ){
            eve.getLogin(userid,passwd);
        }
         if(userid.length()==0){
            JOptionPane.showMessageDialog(null, "用户名不能为空！", "错误",JOptionPane.ERROR_MESSAGE);
        }else if(passwd.length()>6){
            JOptionPane.showMessageDialog(null, "密码不能少于 6 个字符！", "错误",JOptionPane.ERROR_MESSAGE);
        }else if(passwd.length()==0){
            JOptionPane.showMessageDialog(null, "请输入密码！", "错误",JOptionPane.ERROR_MESSAGE);
        }else if(!sdb.getLogin(userid,passwd)){
            JOptionPane.showMessageDialog(null, "账号未注册,请先注册账号！", "错误",JOptionPane.ERROR_MESSAGE);
        }else if(userid.length()>6){
            JOptionPane.showMessageDialog(null, "用户名不能少于 6 个字符！", "错误",JOptionPane.ERROR_MESSAGE);
        }


    }
}
