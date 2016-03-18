package model;

import java.util.List;

public class Session {

	private int userID;
	private List<QAPairs> qaPairs;
	
	public Session(int userID, List<QAPairs> qaPairs){
		this.userID=userID;
		this.qaPairs=qaPairs;
	}
	
	public List<QAPairs> getListQAPairs(){
		return qaPairs;
	}
	
	public int getUserID(){
		return userID;
	}
}
