package database;

import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.Question;
import model.QuestionAnswer;

public class DatabaseConnector {
	public List<QuestionAnswer> getQuestions(int level) {
	        List<QuestionAnswer> listOfQuestions=new ArrayList<>();
	        
	        Answer answer1 = new Answer(1, "Encapsulaiton, Inheritance, Polymorphism, Abstraction", true, 0);
	        Answer answer2 = new Answer(2, "Abstraction, Encapsulation, Polymorphism.", false, 0);
	        Answer answer3 = new Answer(3, "Abstraction, Single responsibility, Interface, Inheritance", false, 0);

	        List<Answer> answers1 = new ArrayList<>();
	        answers1.add(answer1);
	        answers1.add(answer2);
	        answers1.add(answer3);
	        
	        QuestionAnswer qa1 = new QuestionAnswer(new Question(13, "What are the OOP principles?", "Easy", "OOP"), answers1);
	        
	        listOfQuestions.add(qa1);
	        
	        Answer answer4 = new Answer(4, " Queue is last in first out data structure", false, 0);
	        Answer answer5 = new Answer(5, "Stack is last in first out data structure", true, 0);
	        Answer answer6 = new Answer(6, "Stack is first in first out data structure", false, 0);

	        List<Answer> answers2 = new ArrayList<>();
	        answers2.add(answer4);
	        answers2.add(answer5);
	        answers2.add(answer6);
	        
	        QuestionAnswer qa2 = new QuestionAnswer(new Question(19, "What is the difference between stack and queue?", "Easy", "DS"), answers2);
	        
	        listOfQuestions.add(qa2);
	        
	        Answer answer7 = new Answer(7, "Java Virtual Machine is an abstract machine which provides "
	        		+ "the runtime environment in which java bytecode can be executed.", true, 0);
	        Answer answer8 = new Answer(8, "Java Virtual Machine is an abstract machine which provides "
	        		+ "the runtime environment in which classes can be executed.", false, 0);
	        Answer answer9 = new Answer(9, "Java Virtual Machine is an IDE.", false, 0);
	        

	        List<Answer> answers3 = new ArrayList<>();
	        answers3.add(answer7);
	        answers3.add(answer8);
	        answers3.add(answer9);
	        
	        QuestionAnswer qa3 = new QuestionAnswer(new Question(1, "What is JVM?", "Easy", "Core"), answers3);
	        
	        listOfQuestions.add(qa3);
	        
	        Answer answer10 = new Answer(7, "JDBC is an API for communicating to relational database.", true, 0);
	        Answer answer11 = new Answer(8, " JDBC is a database.", false, 0);
	        Answer answer12 = new Answer(9, "JDBC is a design pattern.", false, 0);
	        

	        List<Answer> answers4 = new ArrayList<>();
	        answers4.add(answer10);
	        answers4.add(answer11);
	        answers4.add(answer12);
	        
	        QuestionAnswer qa4 = new QuestionAnswer(new Question(7, "What is JDBC?", "Easy", "Database"), answers4);
	        
	        listOfQuestions.add(qa4);
	       
	        
	        return listOfQuestions;
	}
}
