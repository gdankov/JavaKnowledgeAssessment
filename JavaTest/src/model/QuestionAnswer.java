package model;

import java.util.List;

public class QuestionAnswer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Question question;
	private List<Answer> listOfAnswers;
	
	public QuestionAnswer(Question question){
		this.question = question;
		this.listOfAnswers=listOfAnswers;
	}
	
	public QuestionAnswer(Question question, List<Answer> listOfAnswers) {
		this.question = question;
		this.listOfAnswers = listOfAnswers;
	}

	public Question getQuestion() {
		return question;
	}

	public List<Answer> getAnswers() {
		return listOfAnswers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
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
		QuestionAnswer other = (QuestionAnswer) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionAnswer [question=" + question + 
				", listOfAnswers=" + listOfAnswers + "]";
	}
	
	
	
	
}
