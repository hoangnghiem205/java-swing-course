/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.demo.exploer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author pc
 */
public class ExplorerFrame extends JFrame{
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTree folderTree;
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }
    
    public ExplorerFrame(){
        super("Explorer");
        items = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initLayout();
        setSize(800,600);        
        setVisible(true);
        
        
    }
    
    public void initLayout() {
        loadItems();
        leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.WHITE);
        
        folderTree = new JTree(buildTree());
        leftPanel.add(folderTree);
        
        rightPanel = new JPanel();
        
        rightPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        rightPanel.setBackground(Color.WHITE);
        for (Item item : items) {
            rightPanel.add(item);
            item.addMouseListener(new ItemClickListener(this));
        }
        
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setContinuousLayout(true);
        
        add(splitPane, BorderLayout.CENTER);
    }
    
    public void loadItems() {
        items.add(new Item("Games", true));
        items.add(new Item("Books", true));
        items.add(new Item("test.txt", false));
        items.add(new Item("a.doc", false));
    }
    
    public TreeNode buildTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Home");
        DefaultMutableTreeNode doc = new DefaultMutableTreeNode("Documents");
        DefaultMutableTreeNode app = new DefaultMutableTreeNode("Applications");
        root.add(doc);
        root.add(app);
        return root;
    }
}
