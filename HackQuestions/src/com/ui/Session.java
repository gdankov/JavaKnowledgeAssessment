package com.ui;

import java.util.ArrayList;
import java.util.List;

import model.QuestionAnswer;
import questionscontroller.UserSession;

public class Session {
	public List<QuestionAnswer> questions;
	private ArrayList<Integer> results = new ArrayList<>(); // results from the
															// input
	private int switchCounter = 0;// counter for when to loadNewQuestions
	private int questionCounter = 1;// number of questions asked
	private int answersCounter = 0;
	private int numberOfQuesRequested;
	private int remaining;
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
		remaining--;
		return question;
	}

	public void loadNewQuestions() {
		questions = userSession.setUpLevel(currentLevel);
		numberOfQuesRequested = questions.size();
		remaining=questions.size();
	}

	public boolean checkWhenToPass() {
		if(remaining == 0) {
			if (passResults(results) && checkStatus()) {// на колко отговора да се
				// праща
				System.out.println("Here it should be:" + results.size());
				loadNewQuestions();
				answersCounter = 0;
				switchCounter = 0;
				return true;
			}
			return false;
		}
		return true;
	}

	public boolean passResults(ArrayList<Integer> results) {
		if (userSession.evaluateResult(results, questions, currentLevel)) {
			currentLevel++;
			results.clear();
			return true;
		}
		return false;
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
		if (currentLevel == 3) {// 4=колкото са ни
			// въпросите+1
			return false;
		} else {
			return true;
		}
	}
	

}
