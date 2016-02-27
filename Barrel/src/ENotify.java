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
import javax.imageio.ImageIO; 
import io.indico.*;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import java.util.Timer;
import javax.swing.*; 
import java.util.ArrayList;


public class ENotify {
	String msg;
	public ENotify(String msg){
		this.msg = msg;
		display();
	}
	public void display(){
		JFrame newFrame = new JFrame();
		newFrame.getContentPane().setBackground(Color.GREEN);

		newFrame.setLocationRelativeTo(null);
		
		newFrame.setSize(500, 500);
		newFrame.setLayout(null);
		JLabel warn = new JLabel("Warning!");
		warn.setForeground(Color.RED);
		warn.setFont(new Font("Seravik", Font.PLAIN, 50));
		warn.setBounds(10, 10, 200, 50);
		JLabel messg = new JLabel(msg);
		messg.setForeground(Color.RED);
		messg.setFont(new Font("Seravik", Font.PLAIN, 25));
		messg.setBounds(10, 100, 500 , 500);
	}
}
