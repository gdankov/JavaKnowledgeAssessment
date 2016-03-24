package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBconnect;
import model.Answer;
import model.QAPairs;
import model.Question;
import model.QuestionAnswer;
import model.Session;

public class DatabaseConnector {

	public List<QuestionAnswer> getQuestions(int level) {
		Connection cDB = DBconnect.getConnection();
		
		List<QuestionAnswer> questionAnswerList=new ArrayList<QuestionAnswer>();

		if (cDB != null) {

			Statement st = null;
			String sql = "SELECT a.content as Qcontent, b.content as Acontent,* FROM public.\"Questions\" as a LEFT JOIN public.\"Answers\" as b on a.questionID=b.questionID "
					+ "LEFT JOIN public.\"Topics\" as c on a.topicID=c.topicID WHERE a.level="
					+ level + ";";

			try {
				st = cDB.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();
				int numberOfColumns = rsmd.getColumnCount();

				for (int i = 1; i <= numberOfColumns; i++) { // indices here
																// start from 1

					// System.out.println(rsmd.getColumnLabel(i));
				}
				// System.out.println(rs.getRow());

				Question currentQuestion = null;
				String[] levels = { "", "Easy", "Medium", "Hard" };

				List<Answer> answers=null;
				
				
				while (rs.next()) {

					int questionID = rs.getInt("questionID");
					System.out.println(questionID);
					String questionContent = rs.getString("Qcontent");
					int questionLevel_number = rs.getInt("level"); // integer or
																	// string
					String questionLevel = levels[questionLevel_number];

					String topic = rs.getString("topic");
					int topicID = rs.getInt("topicID");

					if (currentQuestion == null || currentQuestion.getQuestionID() != questionID) {
						currentQuestion = new Question(questionID, questionContent, questionLevel, topic);
						answers=new ArrayList<Answer>();
						QuestionAnswer qa= new QuestionAnswer(currentQuestion, answers );
						questionAnswerList.add(qa);
					}

					int answerID = rs.getInt("answerID");
					String answerContent = rs.getString("Acontent");
					int isCorrect = rs.getInt("isCorrect");
					Answer currentAnswer =new Answer(answerID,answerContent, isCorrect==1,questionID);
					answers.add(currentAnswer);
					

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//System.out.println(questionAnswerList);
		//FIX...KINDA
		//return getQuestions_(); 
		return questionAnswerList;
	}

	public List<String> getRecommendations(int level, int topicID){
		
       Connection cDB = DBconnect.getConnection();
		
		List<String> listOfBooks=new ArrayList<String>();
		
		if (cDB != null) {

			Statement st = null;
			String sqlGetBooks = "SELECT * FROM public.\"Recommendations\" WHERE topicID="+topicID+" AND level="+level+";";

			try {
				st = cDB.createStatement();
		      	ResultSet rs = st.executeQuery(sqlGetBooks);
				while(rs.next()){
					String book=rs.getString("book");
					String author=rs.getString("author");
					listOfBooks.add(book+" by " +author);					
				}
				
				
				}
			catch(Exception e){
				e.printStackTrace();
			}
	}
		return listOfBooks;
	}
	
	public void writeSession(Session session){ //use for new sessions only
		
		
		Connection cDB = DBconnect.getConnection();
		
		
		if (cDB != null) {

			Statement st = null;
			
			
			String sqlGetMaxID = "SELECT max(sessionID) as maxID FROM public.\"Sessions\";";
						
			String sqlWriteSession = "INSERT INTO public.\"Sessions\" (sessionID,userID) VALUES ";
			String sqlWriteAnswerHistory= "INSERT INTO public.\"AnswerHistory\" (sessionID,questionID, userAnswerID) VALUES ";
			
			int ID=0;
			try {
				st = cDB.createStatement();
		
				ResultSet rs = st.executeQuery(sqlGetMaxID);
				rs.next();
				
					int maxID=rs.getInt("maxID");
					ID=maxID+1;
					
					sqlWriteSession +="("+ID+","+session.getUserID()+")";
					st.execute(sqlWriteSession); //session was written
					
					List<QAPairs> qaPairs=session.getListQAPairs();
					
					for(QAPairs pair: qaPairs){
						
						String sqlWriteAnswerHistoryFull=sqlWriteAnswerHistory+"("+ID+","+pair.getQuestionID()+","+pair.getAnswerID()+");";
						st.execute(sqlWriteAnswerHistoryFull);
					}
				
		
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}
		}
	
	public String getBestUser(String topic){
		
		//work in progress
		Connection cDB = DBconnect.getConnection();
		String bestUser="";
	
		if (cDB != null) {

			Statement st = null;
			//String sql = "SELECT count(*) as numberFoundUsers FROM public.\"Users\" WHERE userName='"+userName+"';";
			

			try {
				st = cDB.createStatement();
		    	//ResultSet rs = st.executeQuery(sql);
				//rs.next();
			
				
				
					//rs.next();
					//int maxID=rs.getInt("maxID");
					
				
				}
				
		
			   catch(Exception e){
				e.printStackTrace();
			}

	}
		return bestUser;
	}
	
	public int getUserID(String userName, String password){  //from DB
      
		Connection cDB = DBconnect.getConnection();
		
		List<QuestionAnswer> questionAnswerList=new ArrayList<QuestionAnswer>();

		int ID=0;
		if (cDB != null) {

			Statement st = null;
			String sql = "SELECT count(*) as numberFoundUsers FROM public.\"Users\" WHERE userName='"+userName+"';";
			String sqlGetMaxID = "SELECT max(userID) as maxID FROM public.\"Users\";";
			String sqlAddUser="INSERT INTO public.\"Users\" (userID, username,password) VALUES "; //more to add
			String sqlGetExistingID = "SELECT userID FROM public.\"Users\" WHERE userName='"+userName+"';";
			

			try {
				st = cDB.createStatement();
		
				ResultSet rs = st.executeQuery(sql);
				rs.next();
				int index=rs.getInt("numberFoundUsers");
				
				if(index==0){
					rs=st.executeQuery(sqlGetMaxID);
					rs.next();
					int maxID=rs.getInt("maxID");
					ID=maxID+1;
					
					sqlAddUser+="("+ID+",'"+userName+"','"+password+"')";
					st.execute(sqlAddUser);
				}
				else{
					rs=st.executeQuery(sqlGetExistingID);
					rs.next();
					ID=rs.getInt("userID");
			
				}
		
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		}
		return ID;
	}
	
	public List<QuestionAnswer> getQuestions_(int level) {
		List<QuestionAnswer> listOfQuestions = new ArrayList<>();

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

	public static void main(String[] args) {
		
		DatabaseConnector dbc = new DatabaseConnector();
		//dbc.getQuestions(3);
		//System.out.println(dbc.getUserID("Kiro2","bbb"));
		System.out.println(dbc.getRecommendations(1,1));
		
		List<QAPairs> qapair=new ArrayList<QAPairs>();
		qapair.add(new QAPairs(1,2));
		qapair.add(new QAPairs(2,3));
		qapair.add(new QAPairs(3,1));
		Session s=new Session(1,qapair);
		
		//dbc.writeSession(s);
	}
}