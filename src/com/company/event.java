//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class event {
    public event() {
    }


    private boolean sule;
    public void SignUplisternerEvent(){
        sule = true;
    }

    public boolean sules(){
        if (sule==true){
            return true;
        }else{
            return false;
        }
    }



    private boolean tacc;
    public void getLogin(String username,String passWd) {
        event eve =new event();
        sqldb sdb = new sqldb();
        Main main = new Main();
            if (sdb.getLogin(username, passWd)) {
                System.out.println("登录成功！");
                JOptionPane.showMessageDialog(null, "欢迎回来 "+username +" !", "登录成功",JOptionPane.PLAIN_MESSAGE);
                main.getFrame().setVisible(false);
                //eve.getAccloginWindows();
                tacc = true;
                //System.exit(0);
            } else if (!sdb.getLogin(username, passWd)) {
                System.out.println("账号或密码不正确！");
                JOptionPane.showMessageDialog(null, "账号或密码不正确！请重试", "登录失败",JOptionPane.ERROR_MESSAGE);
            }

    }

    public boolean loginsm(){
        if(tacc == true){
            return true;
        }else{
            return false;
        }
    }

    public void getWelcome() {
        System.out.println("");
        System.out.println("      Alogin!welcome!      ");
        System.out.println("");
        System.out.println("login | authme | quit");
    }

    public void getSignUp(String username,String passWd) {
        sqldb sdb = new sqldb();
        if (sdb.getLogin(username, passWd)) {
            System.out.println("错误！账号或已存在！");
        } else if (!sdb.getLogin(username, passWd)) {
            sdb.getConnection();
            int id = sdb.getLastId();
            System.out.println(id);
            sdb.getInsert(id, username, passWd);
            sdb.closeConnection();
            System.out.println("注册成功！");

        }

    }

    private boolean dds;
    public void getLoginWindows(Frame frame){
        frame.setVisible(true);
        frame.setSize(450,400);
        frame.setBackground(Color.white);
        frame.setLocation(680,300);
        frame.setResizable(false);
        frame.setLayout(null);

        Button jbut = new Button("login in");
        jbut.setSize(80,40);
        jbut.setLocation(100,300);
        Button jbut2 = new Button("sign up");
        jbut2.setSize(80,40);
        jbut2.setLocation(260,300);

        frame.add(jbut);
        frame.add(jbut2);
        TextField txt2= new TextField();
        TextField txt= new TextField();
        txt.setSize(200,24);
        txt.setLocation(120,100);
        txt2.setSize(200,24);
        txt2.setLocation(120,140);
        Label log = new Label("UserID");
        Label log2 = new Label("password");
        log.setSize(40,20);
        log.setLocation(70,100);
        log2.setSize(60,20);
        log2.setLocation(55,144);
        frame.add(log2);
        frame.add(log);
        frame.add(txt);
        frame.add(txt2);
        jbut.addActionListener(new MyCalculatorListener(txt,txt2));
        jbut2.addActionListener(new MyCalculatorListener2());


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });




    }



    public void getAccloginWindows(){
        Main main = new Main();
        Frame frame = main.getFrame3();
        frame.setVisible(true);
        frame.setSize(450,400);
        frame.setBackground(Color.white);
        frame.setLocation(680,300);
        frame.setResizable(false);
        frame.setLayout(null);

        Button but1 =new Button("cancellation");
        but1.setSize(80,40);
        but1.setLocation(260,300);
        frame.add(but1);




        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }











    private Frame frameSignwindows;
    public void getSignUpwindowns(Frame fsign){

        frameSignwindows = fsign;
        fsign.setVisible(true);
        fsign.setSize(450,400);
        fsign.setBackground(Color.white);
        fsign.setLocation(680,300);
        fsign.setResizable(false);
        fsign.setLayout(null);

        Button jbut = new Button("Sign up");
        jbut.setSize(80,40);
        jbut.setLocation(100,300);
        Button jbut2 = new Button("Back up");
        jbut2.setSize(80,40);
        jbut2.setLocation(260,300);

        fsign.add(jbut);
        fsign.add(jbut2);
        TextField txt2= new TextField();
        TextField txt= new TextField();
        TextField txt3 =new TextField();
        txt.setSize(200,24);
        txt.setLocation(120,100);
        txt2.setSize(200,24);
        txt2.setLocation(120,140);
        txt3.setSize(200,24);
        txt3.setLocation(120,180);
        Label log = new Label("UserID");
        Label log2 = new Label("password");
        Label log3 = new Label("password again");
        log3.setSize(100,20);
        log3.setLocation(20,182);
        log.setSize(40,20);
        log.setLocation(70,100);
        log2.setSize(60,20);
        log2.setLocation(55,144);
        fsign.add(log2);
        fsign.add(log);
        fsign.add(txt);
        fsign.add(txt2);
        fsign.add(log3);
        fsign.add(txt3);

        jbut.addActionListener(new MyCalculatorListener4(txt,txt2,txt3));
        jbut2.addActionListener(new MyCalculatorListener3());


        fsign.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }



    public void getClosingSignWindows(Frame frame){
        frame.setVisible(false);
    }

    public void getClosingMainWindows(Frame frame){

        frame.setVisible(false);
    }
/*
    public void cmd() {
        event eve = new event();

        while(true) {
            Scanner getwhat = new Scanner(System.in);
            String a1 = getwhat.next();
            if (!a1.equals("login") && !a1.equals("l") && !a1.equals("lo") && !a1.equals("log")) {
                if (!a1.equals("a") && !a1.equals("au") && !a1.equals("authme") && !a1.equals("auth")) {
                    if (a1.equals("quit") || a1.equals("q")) {
                        break;
                    }

                    System.out.println("错误！请选择一项进行下一步！");
                    System.out.println("login | authme | quit");
                    continue;
                }

                eve.getSignUp();
                break;
            }

            eve.getLogin();
            break;
        }

    }
    0

 */

}
