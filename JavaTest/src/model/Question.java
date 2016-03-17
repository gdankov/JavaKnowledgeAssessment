package model;

import java.util.List;

public class Question {

	private int questionID;
	private String content;
	private String level;
	private String topic;
	
	public Question(int qID, String cont, String level, String topic){
		questionID=qID;
		content=cont;
		this.level=level;
		this.topic=topic;
		
	}

	public int getQuestionID() {
		return questionID;
	}

	public String getContent() {
		return content;
	}

	public String getLevel() {
		return level;
	}

	public String getTopic() {
		return topic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		Question other = (Question) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (questionID != other.questionID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", "
				+ "content=" + content + ", level=" + level 
				+ ", topic=" + topic+ "]";
	}
	
	
}