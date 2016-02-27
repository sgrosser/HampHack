import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
public class BoundedThread<T> implements Runnable{

	private int MAX_ENERGY_USAGE;
	private Timer t;
	private int CURR_ENEG_LEFT;
	private int ENRGY_FLOW; // energy used in 1 second
	private Callable<T> action;
	private SentimentReport S;
	private double LAX_THRESHOLD; //between 0 and 1. percentage until SentimentReport notified of low energy
	private boolean HAS_USE = true;

	public BoundedThread(int max_en, int energy_flow_rate, Callable<T> action, 
			double laxThreshold, SentimentReport S){
		this.S = S;
		this.MAX_ENERGY_USAGE = max_en;
		CURR_ENEG_LEFT = this.MAX_ENERGY_USAGE;
		this.ENRGY_FLOW = energy_flow_rate;
		this.action = action;
		this.LAX_THRESHOLD = laxThreshold;
	}
	class RemindTask extends TimerTask {
		public void run() {
			CURR_ENEG_LEFT-=ENRGY_FLOW;
			if(CURR_ENEG_LEFT <= 0 ) HAS_USE = false;
			if(CURR_ENEG_LEFT < MAX_ENERGY_USAGE * (1 - LAX_THRESHOLD)){

			}





		}
	}
	//TODO have function to report to S
	private T actionMethod(Callable<T> func) throws Exception{
		return func.call();
	}
	public void run(){
		while(HAS_USE){
			t = new Timer();
			t.schedule(new RemindTask(), 1000, 1000);

			//general action
			try {
				actionMethod(action);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		t.cancel();
	}
	public int getMAX_ENERGY_USAGE() {
		return MAX_ENERGY_USAGE;
	}
	public int getCURR_ENEG_LEFT() {
		return CURR_ENEG_LEFT;
	}
	public int getENRGY_FLOW() {
		return ENRGY_FLOW;
	}
	public double getLAX_THRESHOLD() {
		return LAX_THRESHOLD;
	}
}
