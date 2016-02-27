import java.util.Timer;
import java.util.TimerTask;
public class Electronic {
	public String name;
	public String eType;
	public int chargeTime;
	public int remainingChargeTime;
	public Timer t;
	public int overCharge = 0;
	public boolean pluggedIn = false;
	
	Electronic(String name, int chargeTime, String eType){
		this.name = name;
		this.chargeTime = chargeTime;
		this.eType = eType;
		remainingChargeTime = chargeTime;
	}
	
	public void plugIn(){
		pluggedIn = true;
		t = new Timer();
		t.schedule(Task(), 5000);
		
	}
	private TimerTask Task() {
		if(remainingChargeTime > 0) remainingChargeTime-=5;
		else{
			overCharge++;
			if(overCharge % 5 == 0) { //TODO switch to % 12
				ENotify energyNot = new ENotify(this.name + " Overcharged!");
			
			}
		}
		return null;
	}
	
	  

	
	public void pullOut(){
		
		pluggedIn = false;
		t.cancel();
	}
}
