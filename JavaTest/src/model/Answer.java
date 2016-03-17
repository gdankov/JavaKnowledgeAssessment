package model;

public class Answer {

	private int id;
	private String data;
	private boolean isCorrect;
	private int questionID;
	
	public Answer(int id, String a, boolean isCorrect, int questionID) {
		this.id = id;
		this.data = a;
		this.isCorrect = isCorrect;
		this.questionID = questionID;
	}

	public int getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public int getQuestionID() {
		return questionID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + questionID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (id != other.id)
			return false;
		if (questionID != other.questionID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", data=" + data + ","
				+ ", isCorrect=" + 
				isCorrect + ", questionID="+ questionID + "]";
	}
	
	
}