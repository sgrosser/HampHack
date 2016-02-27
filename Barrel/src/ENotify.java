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
	public String msg;
	public boolean warning;
	public ENotify(String msg, boolean warning){
		this.msg = msg;
		this.warning = warning;
		display();
	}
	public void display(){
		JFrame newFrame = new JFrame();
		newFrame.getContentPane().setBackground(Color.GREEN);

		newFrame.setLocationRelativeTo(null);
		
		newFrame.setSize(700, 500);
		newFrame.setLayout(null);
		JLabel warn;
		if(this.warning) {
			warn = new JLabel("Warning!");
		}
		else warn = new JLabel("Energy Report");
		warn.setForeground(Color.RED);
		warn.setFont(new Font("Seravik", Font.PLAIN, 50));
		warn.setBounds(10, 10, 250, 50);
		JLabel messg = new JLabel(msg);
		messg.setForeground(Color.RED);
		messg.setFont(new Font("Seravik", Font.PLAIN, 25));
		messg.setBounds(10, 100, 690 , 100);
		newFrame.add(warn);
		newFrame.add(messg);
		newFrame.setVisible(true);
	}
}
