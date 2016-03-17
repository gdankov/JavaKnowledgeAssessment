package com.ui;

import java.util.ArrayList;

public class QuestionFactory {
	ArrayList<Question> q = new ArrayList<>();
	int i = 0;

	public QuestionFactory() {
		q.add(new Question("1", "2", "3"));
		q.add(new Question("4", "5", "6"));
		q.add(new Question("f", "l", "t"));
		q.add(new Question("k", "l", "m"));
	}

	public Question take() {
		Question result;
		result = q.get(i);
		i++;
		return result;
	}

	public ArrayList<Question> getArray() {
		return q;
	}

}
