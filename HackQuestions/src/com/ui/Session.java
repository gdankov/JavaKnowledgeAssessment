package com.ui;

import java.util.ArrayList;
import java.util.List;

import model.QuestionAnswer;
import questionscontroller.UserSession;

public class Session {
	private List<QuestionAnswer> questions;
	private ArrayList<Integer> results = new ArrayList<>(); // results from the
															// input
	private int switchCounter = 0;// counter for when to loadNewQuestions
	private int questionCounter = 1;// number of questions asked
	private int answersCounter = 0;
	private int numberOfQuesRequested;
	private int currentLevel = 1;
	private UserSession userSession = new UserSession(1);

	public Session() {
		loadNewQuestions();
	}

	public QuestionAnswer getQuestion() {
		QuestionAnswer question;
		question = questions.get(switchCounter);
		switchCounter++;
		questionCounter++;
		return question;
	}

	public void loadNewQuestions() {
		questions = userSession.setUpLevel(currentLevel);
		numberOfQuesRequested = questions.size();
	}

	public void checkWhenToPass() {
		if (answersCounter == numberOfQuesRequested) {// на колко отговора да се
														// праща
			System.out.println("Here it should be:" + results.size());
			passResults(results);
			loadNewQuestions();
			answersCounter = 0;
			switchCounter = 0;
		}
	}

	public void passResults(ArrayList<Integer> results) {
		if (userSession.evaluateResult(results, questions, 1)) {
			// currentLevel++;
		}

	}

	public void addResult(int incomingResult) {
		System.out.println("Answer added" + incomingResult);
		answersCounter++;
		results.add(incomingResult);
	}

	public String getFinalResult() {
		return userSession.finalScore() + "";
	}

	public boolean checkStatus() {
		if (questionCounter == 7) {// 4=колкото са ни
									// въпросите+1
			return false;
		} else {
			return true;
		}

	}

}
