/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.demo.calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class MyCalc extends JFrame {
    private String screen = "0";
    private JTextField txtScreen;
    private JButton btnNums[];
    private String[] labels = { "0","1","2","+",
                                "3","4","5","-",
                                "6","7","8","*",
                                "9",".","=","/",
                                "AC"};
    
    private String num1;
    private String num2;
    private String op = null;
    private boolean isEnter = true;
    
    public MyCalc() {
        this.setTitle("Simple Calculator");
        this.setSize(300,400);
        this.initLayout();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initLayout() {
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new GridLayout(5, 4));
        
        JPanel pnScreen = new JPanel();
        pnScreen.setPreferredSize(new Dimension(this.getWidth(), 150));
        pnScreen.setLayout(new BorderLayout());
        txtScreen = new JTextField(this.screen);
        txtScreen.setEditable(false);
        txtScreen.setFont(new Font("Arial", Font.BOLD, 94));
        txtScreen.setHorizontalAlignment(JTextField.RIGHT);
        pnScreen.add(txtScreen);
        
        btnNums = new JButton[17];
        for (int i = 0; i < 17; i++) {
            btnNums[i] = new JButton(labels[i]);
            btnNums[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    handleNumsClick(source.getText());
                }
            });
            pnMain.add(btnNums[i]);
        }
        
        this.add(pnMain, BorderLayout.CENTER);
        this.add(pnScreen, BorderLayout.NORTH);
    }
    
    public void clear() {
        this.screen = "0";
        this.num1 = null;
        this.num2 = null;
        this.op = null;
        updateScreen();
    }
    
    public void clearScreen() {
        this.screen = "0";
        updateScreen();
    }
    
    public void handleNumsClick(String source) {
        System.out.println(source);
        if (source.equals("AC")) {
            clear();
        }
        else {
            // neu bam so
            Pattern p = Pattern.compile("[0-9]");
            Pattern op = Pattern.compile("[\\+\\-\\*\\/]");
            Matcher m = p.matcher(source);
            if (m.matches()) {
                if (!this.isEnter) { clearScreen(); this.isEnter = true;}
                if (this.isEnter) {
                    if (this.screen.equals("0")) {
                        this.screen = source;
                    }
                    else {
                        this.screen += source;
                    }
                    updateScreen();
                }
                
            } else if (op.matcher(source).matches()) { //nguoi dung bam phep tinh
                this.num1 = this.screen;
                this.op = source;
                this.isEnter = false;
            } else if (source.equals("=")) {
                this.num2 = this.screen;
                cal();
                updateScreen();
            }   
        }
    }
    
    private void cal() {
        int rs = 0;
        if (this.op.equals("+")) {
            rs = Integer.valueOf(num1) + Integer.valueOf(num2);
        }
        this.screen = rs + "";
    }
    
    private void updateScreen() {
        this.txtScreen.setText(screen);
    }
    
}
