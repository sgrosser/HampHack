import java.awt.Component; 
import java.awt.Color; 
import java.awt.Container; 
import java.awt.Dimension; 
import java.awt.Font; 
import java.awt.Graphics; 
import java.awt.Toolkit; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.*;
import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.imageio.ImageIO; 

import javax.swing.*; 
import java.util.ArrayList;


public class notification {
	public String mainMessage;
	notification(String msg){
		this.mainMessage = msg;
		display();
	}
	public void display(){
		System.out.println("In notification display function");
		JFrame newFrame = new JFrame();
		newFrame.getContentPane().setBackground(Color.BLACK);

		newFrame.setLocationRelativeTo(null);
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setSize(500, 500);
		newFrame.setLayout(null);
		
		JLabel not = new JLabel("Notification!!!");
		not.setForeground(Color.YELLOW);
		not.setFont(new Font("Seravik", Font.PLAIN, 50));
		not.setBounds(0,10,300 , 100);
		
		newFrame.add(not);
		
		JLabel messg = new JLabel(mainMessage);
		messg.setForeground(Color.RED);
		messg.setFont(new Font("Seravik", Font.PLAIN, 20));
		messg.setBounds(0, 70, 500, 400);
		
		newFrame.add(messg);
		
		newFrame.setVisible(true);
	}
}
