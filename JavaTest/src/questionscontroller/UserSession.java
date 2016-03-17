package questionscontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import database.DatabaseConnector;
import model.Answer;
import model.Question;
import model.QuestionAnswer;

public class UserSession {
    //private User user;
    
    private final int REQUIRED_FOR_NEXT_LEVEL;
    
    private int questionsPerTopic;
    
    private int[] levelScores;
    private int finalScore;
    
    
    //get topics from database eventually
    

    private String[] topics = {"Core", "OOP", "DS"};
    private Map<String, Integer> topicsScoreboard;
    
    public UserSession(int questionsPerTopic) {
        this.questionsPerTopic = questionsPerTopic;
        this.levelScores = new int[3];
        
        for (int i = 0; i < levelScores.length; i++) {
            levelScores[i] = -1;
        }
        
        this.topicsScoreboard = new HashMap<>();
        for (String topic : topics) {
            topicsScoreboard.put(topic, 0);
        }
        
        REQUIRED_FOR_NEXT_LEVEL = Math.round(questionsPerTopic * (75 / 100));
        
    }
    
    public List<QuestionAnswer> setUpLevel(int level) {
        
        levelScores[level - 1] = 0;
        
        DatabaseConnector dbC = new DatabaseConnector();
        
        List<QuestionAnswer> questionsAndAnswers = dbC.getQuestions(1);
        List<QuestionAnswer> result = new ArrayList<>();
        
        
        for (String topic : topics) {
        	List<QuestionAnswer> filtered = filterByTopic(questionsAndAnswers, topic);
            result.addAll(chooseRandomQuestions(filtered, level));
          
        }
        
        
        return result;
    }
    
    private List<QuestionAnswer> filterByTopic(List<QuestionAnswer> questionsAndAnswers, String topic) {
    	List<QuestionAnswer> filtered = new ArrayList<>();
    	for (QuestionAnswer questionAnswer : questionsAndAnswers) {
			if(questionAnswer.getQuestionContent().getTopic().equals(topic)) {
				filtered.add(questionAnswer);
			}
		}
        return filtered;
	}

	private List<QuestionAnswer> chooseRandomQuestions(List<QuestionAnswer> questions, int questionsPerTopic) {
        List<QuestionAnswer> randQuestions = new ArrayList<>();
        
        Random rand = new Random();
        for (int i = 0; i < questionsPerTopic; i++) {
            int randIndex = rand.nextInt(questions.size()); 
            randQuestions.add(questions.get(randIndex));
            questions.remove(randIndex);
        }
        
        
        
        return randQuestions;
	}
   
    
    public boolean evaluateResult(List<Integer> results, List<QuestionAnswer> questions, int level) {
        int currentLevelScore = 0;
        
        int resultCounter = 0;
        for (QuestionAnswer question : questions) {
            int answered = results.get(resultCounter);
            
            if(question.getAnswers().get(answered).isCorrect()) {
                incrementTopicScoreboard(question.getQuestionContent().getTopic());
                ++currentLevelScore;
            }
            ++resultCounter;
        }
        
        levelScores[level - 1] = currentLevelScore;
        finalScore += currentLevelScore;
        
        if(currentLevelScore < REQUIRED_FOR_NEXT_LEVEL) {
            return false;           
        }
        return true;
    }
    
    private void incrementTopicScoreboard(String topic) {
        if(topicsScoreboard.containsKey(topic)){
            Integer oldScore = topicsScoreboard.get(topic);
            topicsScoreboard.put(topic, oldScore + 1);
        } else {
            topicsScoreboard.put(topic, 1);
        }
        
    }

    public int finalScore() {
        return finalScore;
    }
    
    public String getExitScreen(){
        /*for (int i = 0; i < questionsPerTopic * topics.length; i++) {
            
        }
        String finalMessage = "Your score for level 1 is: " + levelScores[]*/
        
        return null;
    }
    
    

}
