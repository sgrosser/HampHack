import java.util.ArrayList;
public class Item {
	public String name;
	public int OriginalStock = 0;
	public int CurrentStock = 0;
	public int datePurchased = 0;
	public int dateRanOut;
	public int lastingFactor; //attempt to decrease with Go Green
	public boolean low = false;
	
	public int quickLoss; // period length of loss of more than 33%
	public int daysSincePurchase = 0;
	public int averageUse=0;

	public Item(String name, int origStock, int purchaseDate, int estimatedLast){
		this.name=name;
		this.OriginalStock=origStock;
		this.CurrentStock = origStock;
		this.lastingFactor = estimatedLast;

		
	}
	
	public void newAverageUse(int a){
		if(averageUse ==0) averageUse = a;
		else averageUse = (averageUse + a)/2;
	}
	
	public void update(int used, int bought){
		
		
	}
	
}
