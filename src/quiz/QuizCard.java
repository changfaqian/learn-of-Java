package quiz;

import java.io.*;

public class QuizCard implements Serializable{

	private static final long serialVersionUID = 4303811812985629332L;
	private String question;
	private String answer;
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public QuizCard(String q,String a) {
		question=q;
		answer=a;
	}

}
