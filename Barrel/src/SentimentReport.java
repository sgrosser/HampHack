import io.indico.*;
public class SentimentReport {
	private Indico indico;
	private String REPORT;
	
	public SentimentReport(String API_key){
		REPORT = "";
		indico = new Indico(API_key);
	}
}
