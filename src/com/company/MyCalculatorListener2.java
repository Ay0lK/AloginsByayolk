package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculatorListener2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        event eve = new event();
        eve.SignUplisternerEvent();
        System.out.println(eve.sules());
        Main acc = new Main();
        eve.getClosingMainWindows(acc.getFrame());

        eve.getSignUpwindowns(acc.getFrame2());
        //eve.getSignUp(userid,passwd);

    }
}
