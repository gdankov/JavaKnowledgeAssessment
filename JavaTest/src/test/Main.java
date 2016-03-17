package test;

import java.util.List;

import model.QuestionAnswer;
import questionscontroller.UserSession;

public class Main {

	public static void main(String[] args) {
		UserSession us = new UserSession(1);
		List<QuestionAnswer> list = us.setUpLevel(1);
		
		for (QuestionAnswer questionAnswers : list) {
			System.out.println(questionAnswers);
		}
	}

}
