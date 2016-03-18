package model;

public class QAPairs {

	private int questionID;
	private int answerID;
	
	public QAPairs(int questionID, int answerID){
		
		this.questionID=questionID;
		this.answerID=answerID;
	}
	
	public int getQuestionID(){
		return questionID;
	}
	
	public int getAnswerID(){
		return answerID;
	}
}
