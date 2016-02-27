import java.io.IOException;

import io.indico.*;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
public class SentimentReport {
	private Indico indico;
	private String REPORT;
	
	public SentimentReport(String API_key){
		REPORT = "";
		indico = new Indico(API_key);
	}
	
	public Double reportSentiment(){
		IndicoResult single;
		Double result = (Double)0.0;
		try {
			single = indico.sentiment.predict(REPORT);
		    result = single.getSentiment();
			
			/*System.out.println(result);
			System.out.println(REPORT);*/
			
			
			
			
		} catch (UnsupportedOperationException | IOException | IndicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void addToReport(String s){
		REPORT+=s;
	}
	
	
	
}
