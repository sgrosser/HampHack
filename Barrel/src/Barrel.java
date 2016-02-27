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





public class Barrel {
	public static void display(){
		
		JFrame mainFrame=new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		 
		mainFrame.getContentPane().setBackground(Color.BLACK);
	
	 mainFrame.setLocationRelativeTo(null);
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
   
	
	
	Color color=new Color(0x1E90FF);
	JLabel jLabel5=new JLabel("Barrel - Green Management");
	jLabel5.setBackground(Color.BLACK);
	jLabel5.setForeground(color);
	jLabel5.setFont(new Font("Seravik", Font.PLAIN, 35));
	jLabel5.setBounds(575,400, 700 , 600);
	
	//update job text
	JLabel action=new JLabel("Update Job");
	action.setBackground(Color.BLACK);
	action.setForeground(color);
	action.setFont(new Font("Seravik", Font.PLAIN, 25));
	action.setBounds(50,100,75 , 150);
	mainFrame.add(action);
	
	
	
	JButton button1=new JButton();
	

	
	
	
	
	
	mainFrame.setSize(1600, 1000);
	
	
	
	
	
	//button1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
		/*spreadsheet ss=new spreadsheet();
		ss.spreadsheetDisplay();
		jobdataEntry jde=new jobdataEntry();
		jde.jobdataEntryDisplay();*/
		
	//}});
	
	
	//button1.setVisible(true);
	
	
	
	mainFrame.add(button1);
	
	mainFrame.add(jLabel5);
	
	
	
	 
	
	mainFrame.setLayout(null);
	
	//update job left section
	JLabel itemName = new JLabel("Item Name");
	itemName.setFont(new Font("Seravik", Font.PLAIN, 25));
	itemName.setBounds(50,100,75 , 150);
	JTextField itemNameTextField=new JTextField();
	
	JTextField purchase = new JTextField();
	JLabel purchased = new JLabel("How much was purchased?");
	
	JLabel usedInv = new JLabel("How much was used?");
	JTextField usedInventory = new JTextField();
	//Todo
	//Update A job!!
	JButton submitItemUpdate = new JButton("Submit Item Update");
	submitItemUpdate.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
		
		
	}});
	
	
	
	
	
	//center image

		BufferedImage image=null;
		try {                
	        image = ImageIO.read(new File("/Users/Stefan/HampHack/Barrel/barrel.png"));
	       } catch (IOException ex) {
	            // handle exception...
	       }
		ImageIcon imageIcon = new ImageIcon(image);
	    JLabel jLabel = new JLabel();
	    jLabel.setIcon(imageIcon);
	    jLabel.setLayout(null);
		jLabel.setBounds(670, 200,850,400);
       
      jLabel.setVisible(true);
      mainFrame.add(jLabel);
      mainFrame.setVisible(true);
	}
	
	int dayCounter = 0;
	ArrayList<Item> items = new ArrayList<Item>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display();
		
		
	}

}
