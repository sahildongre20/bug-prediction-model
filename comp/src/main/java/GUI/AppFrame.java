/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author sahil
 */
public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton=new JButton("Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,150,30);
        
        decompressButton=new JButton("Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,150,30);
       
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(450,200);
        this.getContentPane().setBackground(Color.lightGray);
        Font  f3  = new Font(Font.DIALOG,  Font.BOLD, 15);
        this.setVisible(true);
        this.setTitle("Compressor Decompressor");
        compressButton.setFont(f3);
        decompressButton.setFont(f3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);
                    
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }            
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                    
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }
            
        }
    }
}