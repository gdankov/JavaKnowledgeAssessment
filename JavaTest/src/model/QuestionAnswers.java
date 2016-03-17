package model;

import java.util.List;

public class QuestionAnswers {
	private Question questionContent;
	private List<Answer> answers;
	
	public QuestionAnswers(Question questionContent, List<Answer> answers) {
		this.questionContent = questionContent;
		this.answers = answers;
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

}
