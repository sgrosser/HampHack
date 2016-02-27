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
import javax.swing.ImageIcon; 
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
	}
	public void display(){}
}
