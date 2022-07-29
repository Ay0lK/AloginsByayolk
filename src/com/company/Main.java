package com.company;

import java.awt.*;

public class Main {
    private static Frame framessa;
    private static Frame framesse;
    private static Frame framessd;
    public static void main(String[] args) {
        event eve = new event();
        Frame frame = new Frame("登录界面");
        Frame fsign=new Frame("注册界面");
        Frame frame2 = new Frame("界面");
        framessa = frame;
        framesse = fsign;
        framessd = frame2;
        eve.getLoginWindows(frame);


    }
    public Frame getFrame(){
        return framessa;
    }
    public Frame getFrame2(){
        return framesse;
    }
    public Frame getFrame3(){
        return framessd;
    }
}

