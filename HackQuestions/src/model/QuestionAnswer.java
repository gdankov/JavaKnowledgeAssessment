package model;

import java.util.List;

public class QuestionAnswer {
	private Question questionContent;
	private List<Answer> answers;
	
	public QuestionAnswer(Question questionContent, List<Answer> answers) {
		this.questionContent = questionContent;
		this.answers = answers;
	}
	
	public QuestionAnswer(Question questionContent) {
		this.questionContent = questionContent;
	}
	
	public Question getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(Question questionContent) {
		this.questionContent = questionContent;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAswers(List<Answer> aswers) {
		this.answers = aswers;
	}
	
	@Override
	public String toString() {
		return questionContent.toString() + " " + answers.toString();
		
	}

}
