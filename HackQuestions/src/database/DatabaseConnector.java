package database;

import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.Question;
import model.QuestionAnswer;

public class DatabaseConnector {
	public List<QuestionAnswer> getQuestions(int level) {
	        List<QuestionAnswer> listOfQuestions=new ArrayList<>();
	        
	        Answer answer1 = new Answer(1, "answer 1", false, 0);
	        Answer answer2 = new Answer(2, "answer 2", true, 0);
	        Answer answer3 = new Answer(3, "answer 3", false, 0);
	        
	        List<Answer> answers1 = new ArrayList<>();
	        answers1.add(answer1);
	        answers1.add(answer2);
	        answers1.add(answer3);
	        
	        QuestionAnswer qa1 = new QuestionAnswer(new Question(1, "question 1", "Easy", "OOP"), answers1);
	        
	        listOfQuestions.add(qa1);
	        
	        Answer answer4 = new Answer(4, "answer 4", true, 0);
	        Answer answer5 = new Answer(5, "answer 5", false, 0);
	        Answer answer6 = new Answer(6, "answer 6", false, 0);
	        
	        List<Answer> answers2 = new ArrayList<>();
	        answers2.add(answer4);
	        answers2.add(answer5);
	        answers2.add(answer6);
	        
	        QuestionAnswer qa2 = new QuestionAnswer(new Question(2, "question 2", "Easy", "DS"), answers2);
	        
	        listOfQuestions.add(qa2);
	        
	        Answer answer7 = new Answer(7, "answer 7", false, 0);
	        Answer answer8 = new Answer(8, "answer 8", false, 0);
	        Answer answer9 = new Answer(9, "answer 9", true, 0);
	        
	        List<Answer> answers3 = new ArrayList<>();
	        answers3.add(answer7);
	        answers3.add(answer8);
	        answers3.add(answer9);
	        
	        QuestionAnswer qa3 = new QuestionAnswer(new Question(3, "question 3", "Easy", "Core"), answers3);
	        
	        listOfQuestions.add(qa3);
	        
	        
	        
	        List<Answer> answers4 = new ArrayList<>();
	        answers4.add(answer7);
	        answers4.add(answer8);
	        answers4.add(answer9);
	        
	        QuestionAnswer qa4 = new QuestionAnswer(new Question(4, "question 4", "Easy", "Core"), answers4);
	        
	        listOfQuestions.add(qa4);
	       
	        
	        return listOfQuestions;
	}
}

