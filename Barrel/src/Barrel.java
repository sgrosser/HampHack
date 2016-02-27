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
import io.indico.*;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

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
		//TODO:
		//Update A job!!
		JButton submitItemUpdate = new JButton("Submit Item Update");
		submitItemUpdate.setBounds(80, 800, 200, 50);
		
		
		submitItemUpdate.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			int used = Integer.parseInt(usedInventory.getText());
			int bought = Integer.parseInt(purchase.getText());
			purchase.setText("");
			usedInventory.setText("");
			String name = itemNameTextField.getText();
			itemNameTextField.setText("");
			items.get(name).update(used, bought, dayCounter);
			System.out.println("Updated " + name);
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
		jLabel.setBounds(670, 300,850,400);




		//add item right side
		JLabel addItem = new JLabel("Add a Job");
		addItem.setForeground(color);
		addItem.setFont(new Font("Seravik", Font.PLAIN, 25));
		addItem.setBounds(1100,100, 200 , 150);
		JLabel itNM = new JLabel("Name of Item?");
		itNM.setForeground(color);
		itNM.setFont(new Font("Seravik", Font.PLAIN, 25));
		itNM.setBounds(1120,200, 200 , 50);
		mainFrame.add(itNM);
		JTextField AddItemName = new JTextField();
		AddItemName.setBounds(1140, 250, 100, 25);
		JLabel howMuchBought = new JLabel("How Much Did You Buy?");
		howMuchBought.setForeground(color);
		howMuchBought.setFont(new Font("Seravik", Font.PLAIN, 25));
		howMuchBought.setBounds(1120,400, 300 , 50);
		JTextField howMuchTField = new JTextField();
		howMuchTField.setBounds(1140, 450, 100, 25);
		mainFrame.add(howMuchTField);
		mainFrame.add(howMuchBought);
		mainFrame.add(AddItemName);
		mainFrame.add(addItem);
		JLabel last = new JLabel("How long will this last?");
		last.setForeground(color);
		last.setFont(new Font("Seravik", Font.PLAIN, 25));
		last.setBounds(1120,600, 300 , 50);
		JTextField lastingField = new JTextField();
		lastingField.setBounds(1140, 650, 100, 25);
		JButton submitItem = new JButton("Add This Item");
		submitItem.setBounds(1120, 800, 150, 50);
		
		//TODO
		//Add Job and set statistics
		submitItem.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			String itName = AddItemName.getText();
			AddItemName.setText("");
			int stock = Integer.parseInt(howMuchTField.getText());
			howMuchTField.setText("");
			int lastFactor = Integer.parseInt(lastingField.getText());
			lastingField.setText("");
			items.put(itName, new Item(itName, stock, dayCounter, lastFactor ));
			System.out.println("Added" + itName);
			
		}});
		mainFrame.add(submitItemUpdate);
		mainFrame.add(last);
		mainFrame.add(lastingField);
		mainFrame.add(submitItem);
		mainFrame.add(jLabel);
		
		//Day Counter
		JLabel updateDay = new JLabel("Update the day:");
		updateDay.setForeground(color);
		updateDay.setFont(new Font("Seravik", Font.PLAIN, 25));
		updateDay.setBounds(700,100, 300 , 50);
		JTextField updDy = new JTextField("1");
		updDy.setBounds(750, 150, 50 , 25);
		mainFrame.add(updDy);
		JButton dayButton = new JButton("Update");
		dayButton.setBounds(720, 210, 100, 25);
		
		
		dayButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			dayCounter = Integer.parseInt(updDy.getText());
			
		}});
		
		mainFrame.add(dayButton);
		mainFrame.add(updateDay);
		mainFrame.setVisible(true);
	}

	static int dayCounter = 1;
	static HashMap<String, Item> items = new HashMap<String, Item>();
	public static void main(String[] args) throws UnsupportedOperationException, IOException, IndicoException {
		// TODO Auto-generated method stub
		display();
		/*Indico indico = new Indico("b2909fcc1f89d44ba434f45e2ca16b49");
		IndicoResult single = indico.sentiment.predict("I love writing code!");
		Double result = single.getSentiment();
		System.out.println(result);*/

	}

}
