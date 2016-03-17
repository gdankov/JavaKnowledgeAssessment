package questionscontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ui.Question;
import com.ui.QuestionFactory;

//import database.QuestionDAO;
import model.QuestionAnswers;

public class UserSession {
	// private User user;

	private QuestionFactory factory = new QuestionFactory();// TEST

	public ArrayList<Question> ret() {
		return factory.getArray();
	}

	public void showReceivedAnswers(ArrayList<Integer> list) {
		System.out.println("I'm here");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	private final int REQUIRED_FOR_NEXT_LEVEL;
	private int questionsPerTopic;

	private int[] levelScores;
	private int lastScore;

	private String[] topics = { "Core", "OOP", "Data Structures", "Advanced", "Enterprise" };

	public UserSession(int questionsPerTopic) {
		this.questionsPerTopic = questionsPerTopic;
		this.levelScores = new int[3];

		REQUIRED_FOR_NEXT_LEVEL = Math.round(questionsPerTopic * (75 / 100));

	}

	public UserSession() {
		REQUIRED_FOR_NEXT_LEVEL = 0;
	}

	/*
	 * public List<QuestionAnswers> setUpLevel(int level) {
	 * List<QuestionAnswers> questionsAndAnswers = new ArrayList<>(); for
	 * (String topic : topics) { questionsAndAnswers.addAll(getQuestions(topic,
	 * level, questionsPerTopic)); } return questionsAndAnswers; }
	 */

	private List<QuestionAnswers> chooseRandomQuestions(List<QuestionAnswers> questions, int questionsPerTopic) {

		List<QuestionAnswers> randQuestions = new ArrayList<>();

		Random rand = new Random();
		for (int i = 0; i < questionsPerTopic; i++) {
			int randIndex = rand.nextInt(questions.size());
			randQuestions.add(questions.get(randIndex));
			questions.remove(randIndex);
		}

		return randQuestions;
	}

	/*
	 * private List<QuestionAnswers> getQuestions(String topic, int level, int
	 * questionsPerTopic) { QuestionDAO questionDao = new QuestionDAO();
	 * 
	 * List<QuestionAnswers> questions = questionDao.getAllQuestions(topic,
	 * level); List<QuestionAnswers> randQuestions =
	 * chooseRandomQuestions(questions, questionsPerTopic); return
	 * randQuestions; }
	 * 
	 * private void init() { List<Question> listOfQuestions=new ArrayList<>();
	 * listOfQuestions.add(new Question(1, "question 1", "Easy", "OOP"));
	 * listOfQuestions.add(new Question(2, "question 2", "Easy", "OOP"));
	 * listOfQuestions.add(new Question(3, "question 3", "Easy", "OOP"));
	 * listOfQuestions.add(new Question(4, "question 4", "Easy", "Core"));
	 * listOfQuestions.add(new Question(5, "question 5", "Easy", "Core"));
	 * listOfQuestions.add(new Question(6, "question 6", "Easy", "Core"));
	 * listOfQuestions.add(new Question(7, "question 7", "Easy",
	 * "Data Structures")); listOfQuestions.add(new Question(8, "question 8",
	 * "Easy", "Data Structures")); listOfQuestions.add(new Question(9,
	 * "question 9", "Easy", "Data Structures")); listOfQuestions.add(new
	 * Question(10, "question 10", "Easy", "Algorithms"));
	 * listOfQuestions.add(new Question(11, "question 11", "Easy",
	 * "Algorithms")); listOfQuestions.add(new Question(12, "question 12",
	 * "Easy", "Algorithms")); listOfQuestions.add(new Question(13,
	 * "question 13", "Easy", "Enterprise")); listOfQuestions.add(new
	 * Question(14, "question 14", "Easy", "Enterprise"));
	 * listOfQuestions.add(new Question(15, "question 15", "Easy",
	 * "Enterprise")); listOfQuestions.add(new Question(16, "question 16",
	 * "Medium", "OOP")); listOfQuestions.add(new Question(17, "question 17",
	 * "Medium", "OOP")); listOfQuestions.add(new Question(18, "question 18",
	 * "Medium", "OOP")); listOfQuestions.add(new Question(19, "question 19",
	 * "Medium", "Core")); listOfQuestions.add(new Question(20, "question 20",
	 * "Medium", "Core")); listOfQuestions.add(new Question(21, "question 21",
	 * "Medium", "Core")); listOfQuestions.add(new Question(22, "question 22",
	 * "Medium", "Data Structures")); listOfQuestions.add(new Question(23,
	 * "question 23", "Medium", "Data Structures")); listOfQuestions.add(new
	 * Question(24, "question 24", "Medium", "Data Structures"));
	 * listOfQuestions.add(new Question(25, "question 25", "Medium",
	 * "Algorithms")); listOfQuestions.add(new Question(26, "question 26",
	 * "Medium", "Algorithms")); listOfQuestions.add(new Question(27,
	 * "question 27", "Medium", "Algorithms")); listOfQuestions.add(new
	 * Question(28, "question 28", "Medium", "Enterprise"));
	 * listOfQuestions.add(new Question(29, "question 29", "Medium",
	 * "Enterprise")); listOfQuestions.add(new Question(30, "question 30",
	 * "Medium", "Enterprise")); listOfQuestions.add(new Question(31,
	 * "question 31", "Hard", "OOP")); listOfQuestions.add(new Question(32,
	 * "question 32", "Hard", "OOP")); listOfQuestions.add(new Question(33,
	 * "question 33", "Hard", "OOP")); listOfQuestions.add(new Question(34,
	 * "question 34", "Hard", "Core")); listOfQuestions.add(new Question(35,
	 * "question 35", "Hard", "Core")); listOfQuestions.add(new Question(36,
	 * "question 36", "Hard", "Core")); listOfQuestions.add(new Question(37,
	 * "question 37", "Hard", "Data Structures")); listOfQuestions.add(new
	 * Question(38, "question 38", "Hard", "Data Structures"));
	 * listOfQuestions.add(new Question(39, "question 39", "Hard",
	 * "Data Structures")); listOfQuestions.add(new Question(40, "question 40",
	 * "Hard", "Algorithms")); listOfQuestions.add(new Question(41,
	 * "question 41", "Hard", "Algorithms")); listOfQuestions.add(new
	 * Question(42, "question 42", "Hard", "Algorithms"));
	 * listOfQuestions.add(new Question(43, "question 43", "Hard",
	 * "Enterprise")); listOfQuestions.add(new Question(44, "question 44",
	 * "Hard", "Enterprise")); listOfQuestions.add(new Question(45,
	 * "question 45", "Hard", "Enterprise")); }
	 * 
	 * public boolean evaluateResult(List<Integer> results,
	 * List<QuestionAnswers> questions, int level) { int currentLevelScore = 0;
	 * 
	 * int resultCounter = 0; for (QuestionAnswers question : questions) { int
	 * answered = results.get(resultCounter);
	 * 
	 * if(question.getAnswers().get(answered).isCorrect()) {
	 * ++currentLevelScore; } ++resultCounter; }
	 * 
	 * levelScores[level - 1] = currentLevelScore; lastScore +=
	 * currentLevelScore;
	 * 
	 * if(currentLevelScore < REQUIRED_FOR_NEXT_LEVEL) { return false; } return
	 * true; }
	 * 
	 * public int lastScore() { return lastScore; }
	 */

}
