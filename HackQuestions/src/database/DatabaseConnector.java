package database;

import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.Question;
import model.QuestionAnswer;

public class DatabaseConnector {

	public List<QuestionAnswer> getQuestions(int level) {
		List<QuestionAnswer> listOfQuestions = new ArrayList<>();

		Answer answer1 = new Answer(1, "Encapsulaiton, Inheritance, Polymorphism, Abstraction", true, 0);
		Answer answer2 = new Answer(2, "Abstraction, Encapsulation, Polymorphism.", false, 0);
		Answer answer3 = new Answer(3, "Abstraction, Single responsibility, Interface, Inheritance", false, 0);

		List<Answer> answers1 = new ArrayList<>();
		answers1.add(answer1);
		answers1.add(answer2);
		answers1.add(answer3);

		QuestionAnswer qa1 = new QuestionAnswer(new Question(13, "What are the OOP principles?", "Easy", "OOP"),
				answers1);

		listOfQuestions.add(qa1);

		Answer answer4 = new Answer(4, " Queue is last in first out data structure", false, 0);
		Answer answer5 = new Answer(5, "Stack is last in first out data structure", true, 0);
		Answer answer6 = new Answer(6, "Stack is first in first out data structure", false, 0);

		List<Answer> answers2 = new ArrayList<>();
		answers2.add(answer4);
		answers2.add(answer5);
		answers2.add(answer6);

		QuestionAnswer qa2 = new QuestionAnswer(
				new Question(19, "What is the difference between stack and queue?", "Easy", "DS"), answers2);

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
		Answer answer13 = new Answer(13,
				"Interface is a blueprint of a class that has static constants and abstract methods.", true, 0);
		Answer answer14 = new Answer(14, "Interface is a class with implemented methods.", false, 0);
		Answer answer15 = new Answer(15, "Interface is same as abstract class.", false, 0);

		List<Answer> answers5 = new ArrayList<>();
		answers5.add(answer13);
		answers5.add(answer14);
		answers5.add(answer15);

		QuestionAnswer qa5 = new QuestionAnswer(new Question(14, "What is an interface?", "Easy", "OOP"), answers5);

		listOfQuestions.add(qa5);

		Answer answer16 = new Answer(16, "The Iterator interface provides a number of methods "
				+ "that are abel to iterate over any Collection data structure.", true, 0);
		Answer answer17 = new Answer(17, "Iterator is used to initialize a Collection data structure.", false, 0);
		Answer answer18 = new Answer(18,
				"Iterator and ListIterator are the same. " + "They iterate  over any Collection data structure.", false,
				0);

		List<Answer> answers6 = new ArrayList<>();
		answers6.add(answer16);
		answers6.add(answer17);
		answers6.add(answer18);

		QuestionAnswer qa6 = new QuestionAnswer(new Question(20, "What is an Iterator?", "Easy", "DS"), answers6);

		listOfQuestions.add(qa6);

		Answer answer19 = new Answer(19, " Every computer and server in the world has Java installed.", false, 0);
		Answer answer20 = new Answer(20, "Java is a machine code.", false, 0);
		Answer answer21 = new Answer(21,
				"The bytecode. It is the intermediate language between the source code and machine code.", true, 0);

		List<Answer> answers7 = new ArrayList<>();
		answers7.add(answer19);
		answers7.add(answer20);
		answers7.add(answer21);

		QuestionAnswer qa7 = new QuestionAnswer(
				new Question(2, "Why is Java \"Write once and run anywhere\" programming language?", "Easy", "Core"),
				answers7);

		listOfQuestions.add(qa7);

		Answer answer22 = new Answer(22, "Load the driver, execute query, close connection.", false, 0);
		Answer answer23 = new Answer(23,
				" Load the driver, make connection,  get statement object, execute query, close connection.", true, 0);
		Answer answer24 = new Answer(24, "Load the driver, make connection,  get statement object, execute query.",
				false, 0);

		List<Answer> answers8 = new ArrayList<>();
		answers8.add(answer22);
		answers8.add(answer23);
		answers8.add(answer24);

		QuestionAnswer qa8 = new QuestionAnswer(
				new Question(8, "What are the main steps in java to make JDBC connectivity?", "Easy", "Database"),
				answers8);

		listOfQuestions.add(qa8);

		return listOfQuestions;
	}
}
