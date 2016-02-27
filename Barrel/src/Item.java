import java.util.ArrayList;
public class Item {
	public String name;
	public int OriginalStock = 0;
	public int CurrentStock = 0;
	public int datePurchased = 0;
	public int lastUsed;
	public int lastingFactor; //attempt to decrease with Go Green
	public boolean low = false;

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
		else {increaseAverageUseCounter = 0;
		Barrel.businessReport += "Excellent! You decreased your average use. " + "\n";
		}
		averageUse = newAvg;
	}

	public void update(int used, int bought, int date){
		
		if(used!=0){
			newAverageUse((double)used/(date - lastUsed));
			lastUsed = date;
		}

		if(increaseAverageUseCounter > 3) {
			notification n = new notification ("Average consumption of " + name + " has increased", true);
			Barrel.businessReport += "You are increasing your average consumption. Stop and reduce your usage!";
		}


		CurrentStock -=  used;
	
		if(CurrentStock <= 0) {

			int newlastingFactor = date- dateOfMostRecentPurchase;
			if(newlastingFactor > lastingFactor) Barrel.businessReport += "Good job extending you usage of " + this.name +"! \n";
			else Barrel.businessReport += name + " lasted shorter than before. Please be careful. \n";
		}

		if(bought!=0){
			if(CurrentStock< (int) OriginalStock/5) Barrel.businessReport += "Good job refilling stock of" + this.name + "before you ran out!" +"\n";
			if(date - dateOfMostRecentPurchase < lastingFactor && !low){
				notification n = new notification("Shouldn't have bought "+ name + " for " + (lastingFactor - date + dateOfMostRecentPurchase) + " more days!", true);
				Barrel.businessReport += "Stop and slow down! You bought when your supply would have lasted another " + (lastingFactor - date + dateOfMostRecentPurchase) + " days! This is bad! Reduce your purchases.  \n";
			}	
			low = false;
			dateOfMostRecentPurchase = date;

			OriginalStock = CurrentStock + bought;
			CurrentStock = OriginalStock; 

		}
		
		if( CurrentStock < (int) OriginalStock/5){
			low = true;
			notification n = new notification("Low on " + name +"!", true);
			Barrel.businessReport += "You are running low on supplies for " + name +"! Do not do this! Stay on top of your stock. \n";



		}
	}

};