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
	public boolean notify;
	notification(String msg, boolean notificationTitle){
		this.mainMessage = msg;
		notify = notificationTitle;
		display();
	}
	public void display(){
		
		JFrame newFrame = new JFrame();
		newFrame.getContentPane().setBackground(Color.BLACK);

		newFrame.setLocationRelativeTo(null);
		
		newFrame.setSize(700, 500);
		newFrame.setLayout(null);
		if(notify){
		JLabel not = new JLabel("Notification!!!");
		not.setForeground(Color.YELLOW);
		not.setFont(new Font("Seravik", Font.PLAIN, 50));
		not.setBounds(0,10,300 , 100);
		
		newFrame.add(not);
		}
		else{
			JLabel not = new JLabel("Business Report");
			not.setForeground(Color.GREEN);
			not.setFont(new Font("Seravik", Font.PLAIN, 50));
			not.setBounds(0,10,500 , 100);
			
			newFrame.add(not);
		}
		JLabel messg = new JLabel(mainMessage);
		messg.setForeground(Color.RED);
		messg.setFont(new Font("Seravik", Font.PLAIN, 20));
		messg.setBounds(0, 70, 700, 400);
		
		newFrame.add(messg);
		
		newFrame.setVisible(true);
	}
}
