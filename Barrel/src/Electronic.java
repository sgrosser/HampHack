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
	public int energyUsage;

	Electronic(String name, int chargeTime, String eType){
		this.name = name;
		this.chargeTime = chargeTime;
		this.eType = eType;
		remainingChargeTime = chargeTime;
		energyUsage = (this.eType == "Computer" ? 100 : (this.eType == "Speaker" ? 50 : 10));
	}

	public void plugIn(){
		pluggedIn = true;
		t = new Timer();
		t.schedule(new RemindTask(), 5000, 5000);

	}


	class RemindTask extends TimerTask {
		public void run() {

			if(remainingChargeTime > 0) remainingChargeTime-=5;
			else{
				overCharge++;
				if(overCharge % 5 == 0) { //TODO switch to % 12
					ENotify energyNot = new ENotify(name + " Overcharged! Wasted " + energyUsage*overCharge + " watts!", true);

				}
			}

		}
	}





	public void pullOut(){

		pluggedIn = false;
		t.cancel();
	}
}
