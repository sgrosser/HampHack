import java.util.ArrayList;
public class Item {
	public String name;
	public int OriginalStock = 0;
	public int CurrentStock = 0;
	public int datePurchased = 0;
	public int lastUsed;
	public int lastingFactor; //attempt to decrease with Go Green

	
	public int quickLoss; // period length of loss of more than 33%
	public int dateOfMostRecentPurchase = 0;
	public double averageUse=0;
	public int increaseAverageUseCounter = 0;

	public Item(String name, int origStock, int purchaseDate, int estimatedLast){
		this.name=name;
		this.OriginalStock=origStock;
		this.CurrentStock = origStock;
		this.lastingFactor = estimatedLast;
		dateOfMostRecentPurchase = purchaseDate;
		lastUsed = purchaseDate;

		
	}
	
	public void newAverageUse(double a){
		double newAvg;
		if(averageUse ==0) newAvg = a;
		else newAvg = (averageUse + a)/2;
		if(newAvg > averageUse) increaseAverageUseCounter++;
		else increaseAverageUseCounter = 0;
		averageUse = newAvg;
	}
	
	public void update(int used, int bought, int date){
		System.out.println("In Item Update Function");
		if(used!=0){
			newAverageUse((double)used/(date - lastUsed));
			lastUsed = date;
		}
		
		if(increaseAverageUseCounter > 3) {
			notification n = new notification ("You are increasing your average consumption. Please reduce your usage!");
		}
		
		
		CurrentStock -=  used;
		System.out.println(CurrentStock);
		if(CurrentStock <= 0) lastingFactor = date- dateOfMostRecentPurchase;
		
		if(bought!=0){
			if(date - dateOfMostRecentPurchase < lastingFactor){
				notification n = new notification("You bought when your supply would have lasted another " + (lastingFactor - date + dateOfMostRecentPurchase) + " days!");
			}	
			dateOfMostRecentPurchase = date;
			
			OriginalStock = CurrentStock + bought;
			CurrentStock = OriginalStock; 
			
		}
		System.out.println(OriginalStock);
		if( CurrentStock < (int) OriginalStock/5){
			System.out.println("YOOO");
			notification n = new notification("You are running low on supplies for " + name +"!");
		}
		
		
	}
	
};