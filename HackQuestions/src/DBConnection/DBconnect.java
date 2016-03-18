package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBconnect {

	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/questionnaire";
			c = DriverManager.getConnection(url, "postgres", "postgres");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return c;
	}

	public static void createTables() {
		Connection cDB = getConnection();

		if (cDB != null) {

			Statement st = null;

			// String sql = "CREATE TABLE IF NOT EXISTS \"Answers\" (answerID
			// integer,questionID integer,content text,isCorrect integer);";
			// String sql= "CREATE TABLE IF NOT EXISTS \"Questions\" (questionID
			// integer,content text,level integer,topicID integer, topic
			// text);"; //emptyColumn text
			// String sql= "CREATE TABLE IF NOT EXISTS \"Users\" (userID
			// integer, username text, password text);";
			// String sql= "CREATE TABLE IF NOT EXISTS \"Sessions\" (sessionID
			// integer,userID integer);"; //start and end time, result is not
			// needed
			String sql = "CREATE TABLE IF NOT EXISTS \"AnswerHistory\" (sessionID integer,questionID integer, userAnswerID integer);";
			// String sql="CREATE TABLE IF NOT EXISTS \"Recommendations\"
			// (topicID integer, level integer, book text, author text);";
			// String sql = "CREATE TABLE IF NOT EXISTS \"Topics\" (topicID
			// integer, topic text);";

			try {
				st = cDB.createStatement();
				// st.execute(sql);
				st.execute(sql);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		createTables();
	}

	public static void main_old(String[] args) {
		Connection cDB = getConnection();

		if (cDB != null) {

			Statement st = null;

			// "DROP TABLE \"Users\"; "+

			String sql = "CREATE TABLE \"Users\" (userID integer, username text, password text);";

			// String sql1 = "INSERT INTO \"Users\" (userID, username, password)
			// VALUES(1, 'Pesho', 'aaa'),(2, 'Kiro', 'bbb'),(3, 'Gosho',
			// 'ccc');";

			// String sql2 = "SELECT * from \"Users\" where userID=2";
			try {
				st = cDB.createStatement();
				st.execute(sql);
				// st.execute(sql1);

				// ResultSet rs = st.executeQuery(sql2);
				// System.out.println(rs.getRow());
				/*
				 * while (rs.next()) {
				 * 
				 * String userID = rs.getString("userID"); String username =
				 * rs.getString("username"); String password =
				 * rs.getString("password"); // int userIDemployee_id =
				 * rs.getInt("employee_id"); // int
				 * department_id=rs.getInt("department_id"); System.out.println(
				 * "userID: " + userID); System.out.println("username: " +
				 * username); System.out.println("password: " + password);
				 * 
				 * }
				 */
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
