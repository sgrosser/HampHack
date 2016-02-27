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
import javax.imageio.ImageIO; 
import io.indico.*;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import java.util.Timer;
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
		jLabel5.setBounds(575,300, 700 , 600);

		//update job text
		JLabel action=new JLabel("Update Item");
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
		JButton jLabelImg = new JButton(imageIcon);


		jLabelImg.setBounds(640, 300,250,250);

		jLabelImg.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			Indico indico = new Indico("b2909fcc1f89d44ba434f45e2ca16b49");
			IndicoResult single;
			try {
				single = indico.sentiment.predict(businessReport);
				Double result = single.getSentiment();
				System.out.println(result);
				System.out.println(businessReport);
				notification n;
				if(result < 0.5) n = new notification("You have a negative business report. Improve your usage!",false);
				else  n = new notification("You have a positive business report! Keep up the good work!", false);
			} catch (UnsupportedOperationException | IOException | IndicoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}});


		//add item right side
		JLabel addItem = new JLabel("Add an Item");
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


		}});
		mainFrame.add(submitItemUpdate);
		mainFrame.add(last);
		mainFrame.add(lastingField);
		mainFrame.add(submitItem);
		mainFrame.add(jLabelImg);

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


		//Add leaf button

		BufferedImage image2=null;
		try {                
			image2 = ImageIO.read(new File("/Users/Stefan/HampHack/Barrel/leaf.png"));
		} catch (IOException ex) {
			// handle exception...
		}
		ImageIcon imageIcon2 = new ImageIcon(image2);
		JButton jLabelImg2 = new JButton(imageIcon2);
		jLabelImg2.setBounds(650, 650, 300, 300);

		jLabelImg2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			openEnergyManager();

		}});


		mainFrame.add(jLabelImg2);
		mainFrame.setVisible(true);
	}

	static int dayCounter = 1;
	static String businessReport ="";
	static HashMap<String, Item> items = new HashMap<String, Item>();
	public static void main(String[] args) throws UnsupportedOperationException, IOException, IndicoException {
		// TODO Auto-generated method stub
		display();


	}

	public static void openEnergyManager(){
		JFrame mainEnergy= new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		HashMap<String, Electronic> electronics = new HashMap<String, Electronic>();
		
		mainEnergy.getContentPane().setBackground(Color.GREEN);

		mainEnergy.setLocationRelativeTo(null);
		mainEnergy.setLayout(null);
		mainEnergy.setSize(750, 500);
		JLabel title = new JLabel("Green Energy Management");
		Color color=new Color(0x1E90FF);


		title.setForeground(color);
		title.setFont(new Font("Seravik", Font.PLAIN, 35));
		title.setBounds(10, 10, 500 , 40);
		mainEnergy.add(title);

		JLabel plugInTXT = new JLabel("Plug In Item:");
		plugInTXT.setForeground(color);
		plugInTXT.setFont(new Font("Seravik", Font.PLAIN, 25));
		plugInTXT.setBounds(10, 50, 300, 40);
		mainEnergy.add(plugInTXT);

		JLabel chgTme = new JLabel("Charge Time (h): ");
		chgTme.setForeground(color);
		chgTme.setFont(new Font("Seravik", Font.PLAIN, 25));
		chgTme.setBounds(20, 80, 250, 30);
		JTextField chargeTime = new JTextField("0");
		chargeTime.setBounds(300, 80, 100, 25);
		JLabel eqTp = new JLabel("Equipment Type?: ");
		eqTp.setForeground(color);
		eqTp.setFont(new Font("Seravik", Font.PLAIN, 25));
		eqTp.setBounds(20, 150, 250, 30);
		String[] electronicsTypes={"Computer", "Phone", "Speaker"};
		JComboBox equipTp=new JComboBox(electronicsTypes);
		equipTp.setBounds(300, 150, 100, 35);
		JLabel devNm = new JLabel("Device Name: ");
		devNm.setForeground(color);
		devNm.setFont(new Font("Seravik", Font.PLAIN, 25));
		devNm.setBounds(20, 200, 250, 30);
		JTextField deviceName = new JTextField("Hal");
		deviceName.setBounds(300, 200, 100, 25);
		JButton addChgDev = new JButton("Add Charged Device");
		addChgDev.setBounds(20, 300, 200, 50);
		
		addChgDev.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			//TODO
			String nm = deviceName.getText();
			electronics.put(nm, new Electronic(nm, Integer.parseInt(chargeTime.getText()), equipTp.getSelectedItem().toString()));
			deviceName.setText("Hal");
			chargeTime.setText("");
			electronics.get(nm).plugIn();
			
		}});
		
		
		
		JLabel unpl = new JLabel("Unplug Device: ");
		unpl.setForeground(color);
		unpl.setFont(new Font("Seravik", Font.PLAIN, 30));
		unpl.setBounds(500, 150, 250, 30);
		JTextField unplugDev = new JTextField("Device_Name");
		unplugDev.setBounds(550, 200, 100, 25);
		
		JButton unplugButton = new JButton("Unplug");
		unplugButton.setBounds(525, 250, 100, 50);
		
		unplugButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent event){
			//TODO
			String nam = unplugDev.getText();
			unplugDev.setText("Hal");
		}});
		mainEnergy.add(chgTme);
		mainEnergy.add(chargeTime);
		mainEnergy.add(equipTp);

		mainEnergy.add(eqTp);
		mainEnergy.add(deviceName);
		mainEnergy.add(devNm);
		mainEnergy.add(addChgDev);
		mainEnergy.add(unpl);
		mainEnergy.add(unplugDev);
		
		mainEnergy.add(unplugButton);
		
		mainEnergy.setVisible(true);

	}

}
