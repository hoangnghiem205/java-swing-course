/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.demo.exploer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author pc
 */
public class Item extends JPanel{
    private boolean seleted;
    private boolean folder;
    private String text;
    private Image folderIcon = null;
    private Image fileIcon = null;

    public boolean isSeleted() {
        return seleted;
    }

    public void setSeleted(boolean isSeleted) {
        this.seleted = isSeleted;
        if (isSeleted) {
            selected();
        } else {
            unselected();
        }
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean isFolder) {
        this.folder = isFolder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    private JLabel lblName;
    private JLabel lblImage;
    
    public Item(String text, boolean isFolder) {
        this.text = text;
        this.folder = isFolder;
        try {
            this.folderIcon = ImageIO.read(new File("folder.png"))
                    .getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            this.fileIcon = ImageIO.read(new File("file.png"))
                    .getScaledInstance(50, 50, Image.SCALE_SMOOTH);    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        this.initLayout();
    }
    
    private void initLayout() {
        this.setBackground(new Color(255, 255, 255, 255));
        this.setPreferredSize(new Dimension(70, 70));
        this.setLayout(new BorderLayout());
        lblName = new JLabel(this.text);
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblImage = new JLabel();
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        if (this.folder)
            lblImage.setIcon(new ImageIcon(this.folderIcon));
        else 
            lblImage.setIcon(new ImageIcon(this.fileIcon));
        this.add(lblImage, BorderLayout.CENTER);
        this.add(lblName, BorderLayout.SOUTH);
    }

    private void selected() {
        this.setBorder(BorderFactory.createLineBorder(new Color(102, 255, 255, 255)));
        this.setBackground(new Color(204, 255, 255, 255));
    }
    
    private void unselected() {
        this.setBorder(null);
        this.setBackground(new Color(255, 255, 255, 255));
    }
    
}
