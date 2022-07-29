package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculatorListener3 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main main =new Main();
        event eve = new event();
        main.getFrame().setVisible(true);
        eve.getClosingSignWindows(main.getFrame2());


    }
}
