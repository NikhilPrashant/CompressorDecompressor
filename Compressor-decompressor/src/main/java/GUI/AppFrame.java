/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.mycompany.compressor.decompressor.compressordecompressor.compressor;
import com.mycompany.compressor.decompressor.compressordecompressor.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nikhi
 */
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame() {
        setTitle("File Compresser");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select File To Compress"); //Button to compress
        compressButton.addActionListener(this); //Adding clickListener to Button
        compressButton.setBounds(20, 100, 200, 30);
        
        decompressButton = new JButton("Select File To Decompress"); //Button to decompress
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 100, 200, 30);
        
        this.add(compressButton); //These all alter Visibility
        this.add(decompressButton);
        this.setSize(500, 200); //Size
        this.getContentPane().setBackground(Color.black); //holds layout
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    compressor.method(file);
                } catch (IOException excp) {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    decompressor.method(file);
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(null, exc.toString());
                }
            }
        }
    }
}
