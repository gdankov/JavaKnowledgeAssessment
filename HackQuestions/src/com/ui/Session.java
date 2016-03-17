package com.ui;

import java.util.ArrayList;

import questionscontroller.UserSession;

public class Session {
	private ArrayList<Question> questions;
	private ArrayList<Integer> results = new ArrayList<>(); // results from the
															// input
	private int switchCounter = 0;// counter for when to loadNewQuestions
	private int questionCounter = 1;// number of questions asked
	private int answersCounter = 0;
	private int numberOfQuesRequested = 4; // how many questions per
											// level-hardcoded
	// private QuestionFactory factory = new QuestionFactory();// TEST
	private UserSession userSession = new UserSession();

	/*
	 * public Session() {// TEST questions = factory.getArray(); }
	 */

	public Session() {
		loadNewQuestions();
	}

	public Question getQuestion() {
		Question question;
		question = questions.get(switchCounter);
		switchCounter++;
		questionCounter++;
		return question;
	}

	public void loadNewQuestions() {
		questions = userSession.ret();
	}

	public void checkWhenToPass() {
		if (answersCounter == 3) {// на колко отговора да се праща
			System.out.println("Here it should be:" + results.size());
			passResults(results);
			loadNewQuestions();
			answersCounter = 0;
			switchCounter = 0;
		}
	}

	public void passResults(ArrayList<Integer> results) {
		userSession.showReceivedAnswers(results);

	}

	public void addResult(int incomingResult) {
		System.out.println("Answer added" + incomingResult);
		answersCounter++;
		results.add(incomingResult);
	}

	public String getFinalResult() {
		return "finalResult";
	}

	public boolean checkStatus() {
		if (questionCounter == 7) {// 4=колкото са ни въпросите+1
			return false;
		} else {
			return true;
		}

	}

}
