package questionscontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    

    private String[] topics = {"Core", "OOP", "Data Structures", "Advanced", "Enterprise"};
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
        
        List<QuestionAnswer> questionsAndAnswers = new ArrayList<>();
        for (String topic : topics) {
            questionsAndAnswers.addAll(getQuestions(topic, level, questionsPerTopic));
        }
        
        
        return questionsAndAnswers;
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

    private List<QuestionAnswer> getQuestions(String topic, int level, int questionsPerTopic) {
        
        //get questions from database
        List<QuestionAnswer> questions = init();
        
        List<QuestionAnswer> randQuestions = chooseRandomQuestions(questions, questionsPerTopic);
        return randQuestions;
    }
    
    private List<QuestionAnswer> init() {
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
       
        
        return listOfQuestions;
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

