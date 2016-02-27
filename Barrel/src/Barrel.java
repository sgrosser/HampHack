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
	action.setBounds(50,100,200 , 150);
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
	itemName.setForeground(color);
	itemName.setFont(new Font("Seravik", Font.PLAIN, 25));
	itemName.setBounds(80,170,200 , 90);
	JTextField itemNameTextField=new JTextField();
	itemNameTextField.setBounds(100, 250, 100 , 25);
	JTextField purchase = new JTextField();
	JLabel purchased = new JLabel("How much was purchased?");
	purchased.setFont(new Font("Seravik", Font.PLAIN, 25));
	purchased.setForeground(color);
	purchased.setBounds(80,400,350 , 50);
	purchase.setBounds(100, 450, 100, 25);
	
	mainFrame.add(itemName);
	mainFrame.add(itemNameTextField);
	mainFrame.add(purchase);
	mainFrame.add(purchased);
	JLabel usedInv = new JLabel("How much was used?");
	usedInv.setForeground(color);
	usedInv.setFont(new Font("Seravik", Font.PLAIN, 25));
	usedInv.setBounds(80, 600 , 250, 50 );
	JTextField usedInventory = new JTextField();
	usedInventory.setBounds(100, 650, 100, 25);
	mainFrame.add(usedInv);
	mainFrame.add(usedInventory);
	//Todo
	//Update A job!!
	JButton submitItemUpdate = new JButton("Submit Item Update");
	submitItemUpdate.setBounds(80, 800, 200, 50);
	submitItemUpdate.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
		
		
	}});
	mainFrame.add(submitItemUpdate);
	
	
	
	
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
