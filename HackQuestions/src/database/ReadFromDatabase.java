package database;

import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.Question;
import model.QuestionAnswer;

public class ReadFromDatabase {
	
	//not sure if its here 
	private List <QuestionAnswer> used = new ArrayList<>();	
	private QuestionAnswer qAns;
	
	private List<Question> listOfQuestions = new ArrayList<>();
	private List<Answer> listOfAnswers = new ArrayList<>();
	
	//get all question from topic 
	public  List <QuestionAnswer> getListOfQuestions(String topic){
		for(Question q: listOfQuestions){
			if(q.getTopic().equals(topic)){
				used.add(createQuestionAnswer(q));
			}
		}		
		return used;		
	}
	
	//create QuestionAnswer object 
	public QuestionAnswer createQuestionAnswer(Question q){	
		QuestionAnswer qa = new QuestionAnswer(q);
		for(Answer ans: listOfAnswers){
			if(q.getQuestionID()==ans.getQuestionID()){
				qa.getAnswers().add(ans);
			}
		}
		return qa;
	}
	
	// later from database - spec level
	public List<Question> loadQuestions(String level){
		listOfQuestions.add(new Question(1, "question 1", "Easy", "OOP"));
		listOfQuestions.add(new Question(2, "question 2", "Easy", "OOP"));
		listOfQuestions.add(new Question(3, "question 3", "Easy", "OOP"));
		listOfQuestions.add(new Question(4, "question 4", "Easy", "Core"));
		listOfQuestions.add(new Question(5, "question 5", "Easy", "Core"));
		listOfQuestions.add(new Question(6, "question 6", "Easy", "Core"));
		listOfQuestions.add(new Question(7, "question 7", "Easy", "Data Structures"));
		listOfQuestions.add(new Question(8, "question 8", "Easy", "Data Structures"));
		listOfQuestions.add(new Question(9, "question 9", "Easy", "Data Structures"));
		listOfQuestions.add(new Question(10, "question 10", "Easy", "Algorithms"));
		listOfQuestions.add(new Question(11, "question 11", "Easy", "Algorithms"));
		listOfQuestions.add(new Question(12, "question 12", "Easy", "Algorithms"));
		listOfQuestions.add(new Question(13, "question 13", "Easy", "Enterprise"));
		listOfQuestions.add(new Question(14, "question 14", "Easy", "Enterprise"));
		listOfQuestions.add(new Question(15, "question 15", "Easy", "Enterprise"));
		/*
		listOfQuestions.add(new Question(16, "question 16", "Medium", "OOP"));
		listOfQuestions.add(new Question(17, "question 17", "Medium", "OOP"));
		listOfQuestions.add(new Question(18, "question 18", "Medium", "OOP"));
		listOfQuestions.add(new Question(19, "question 19", "Medium", "Core"));
		listOfQuestions.add(new Question(20, "question 20", "Medium", "Core"));
		listOfQuestions.add(new Question(21, "question 21", "Medium", "Core"));
		listOfQuestions.add(new Question(22, "question 22", "Medium", "Data Structures"));
		listOfQuestions.add(new Question(23, "question 23", "Medium", "Data Structures"));
		listOfQuestions.add(new Question(24, "question 24", "Medium", "Data Structures"));
		listOfQuestions.add(new Question(25, "question 25", "Medium", "Algorithms"));
		listOfQuestions.add(new Question(26, "question 26", "Medium", "Algorithms"));
		listOfQuestions.add(new Question(27, "question 27", "Medium", "Algorithms"));
		listOfQuestions.add(new Question(28, "question 28", "Medium", "Enterprise"));
		listOfQuestions.add(new Question(29, "question 29", "Medium", "Enterprise"));
		listOfQuestions.add(new Question(30, "question 30", "Medium", "Enterprise"));*/
		/*
		listOfQuestions.add(new Question(31, "question 31", "Hard", "OOP"));
		listOfQuestions.add(new Question(32, "question 32", "Hard", "OOP"));
		listOfQuestions.add(new Question(33, "question 33", "Hard", "OOP"));
		listOfQuestions.add(new Question(34, "question 34", "Hard", "Core"));
		listOfQuestions.add(new Question(35, "question 35", "Hard", "Core"));
		listOfQuestions.add(new Question(36, "question 36", "Hard", "Core"));
		listOfQuestions.add(new Question(37, "question 37", "Hard", "Data Structures"));
		listOfQuestions.add(new Question(38, "question 38", "Hard", "Data Structures"));
		listOfQuestions.add(new Question(39, "question 39", "Hard", "Data Structures"));
		listOfQuestions.add(new Question(40, "question 40", "Hard", "Algorithms"));
		listOfQuestions.add(new Question(41, "question 41", "Hard", "Algorithms"));
		listOfQuestions.add(new Question(42, "question 42", "Hard", "Algorithms"));
		listOfQuestions.add(new Question(43, "question 43", "Hard", "Enterprise"));
		listOfQuestions.add(new Question(44, "question 44", "Hard", "Enterprise"));
		listOfQuestions.add(new Question(45, "question 45", "Hard", "Enterprise"));*/
		return listOfQuestions;
	}
	
	public void loadAnswers(){
		listOfAnswers=new ArrayList<>();
		listOfAnswers.add(new Answer(1, "Answer1 to Q1", false, 1));
		listOfAnswers.add(new Answer(2, "Answer2 to Q1", false, 1));
		listOfAnswers.add(new Answer(3, "Answer3 to Q1", true, 1));
		listOfAnswers.add(new Answer(4, "Answer4 to Q1", false, 1));

		listOfAnswers.add(new Answer(5, "Answer1 to Q2", true, 2));
		listOfAnswers.add(new Answer(6, "Answer2 to Q2", false, 2));
		listOfAnswers.add(new Answer(7, "Answer3 to Q2", false, 2));
		listOfAnswers.add(new Answer(8, "Answer4 to Q2", false, 2));

		listOfAnswers.add(new Answer(9, "Answer1 to Q3", false, 3));
		listOfAnswers.add(new Answer(10, "Answer2 to Q3", false, 3));
		listOfAnswers.add(new Answer(11, "Answer3 to Q3", false, 3));
		listOfAnswers.add(new Answer(12, "Answer4 to Q3", true, 3));
		
		listOfAnswers.add(new Answer(13, "Answer1 to Q4", true, 4));
		listOfAnswers.add(new Answer(14, "Answer2 to Q4", false, 4));
		listOfAnswers.add(new Answer(15, "Answer3 to Q4", false, 4));
		listOfAnswers.add(new Answer(16, "Answer4 to Q4", false, 4));
		
		listOfAnswers.add(new Answer(17, "Answer1 to Q5", false, 5));
		listOfAnswers.add(new Answer(18, "Answer2 to Q5", true, 5));
		listOfAnswers.add(new Answer(19, "Answer3 to Q5", false, 5));
		listOfAnswers.add(new Answer(20, "Answer4 to Q5", false, 5));
	}
	

}