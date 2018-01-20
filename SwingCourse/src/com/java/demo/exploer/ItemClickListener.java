/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.demo.exploer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public class ItemClickListener implements MouseListener{

    private ExplorerFrame container;
    
    public ItemClickListener(JFrame container) {
        this.container = (ExplorerFrame)container;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        Item item = (Item)e.getSource();
        System.out.println("selected: " + item.getText());
        List<Item> items = this.container.getItems();
        for (Item i : items) {
            i.setSeleted(false);
        }
        item.setSeleted(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("just press!");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("mouse eneterd");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("mouse exited");
    }
    
}
