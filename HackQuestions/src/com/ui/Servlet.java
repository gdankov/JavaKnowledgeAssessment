package com.ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.QuestionAnswer;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// QuestionFactory factory = new QuestionFactory();
	Session session = new Session();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String answer = request.getParameter("sel");
		if (request.getParameter("noreg") != null) {
			setQuestion(request, response);
		}
		if ("a".equals(answer)) {
			System.out.println("a is checked");
			session.addResult(0);
		} else if ("b".equals(answer)) {
			System.out.println("b is checked");
			session.addResult(1);
		} else if ("c".equals(answer)) {
			System.out.println("c is checked");
			session.addResult(2);
		} else if ("d".equals(answer)) {
			System.out.println("d is checked");
			session.addResult(3);
		} else {
			session.addResult(-1);
		}
		if (request.getParameter("next") != null) {

			session.checkWhenToPass();
			if (session.checkStatus()) {
				setQuestion(request, response);
			} else {
				forwardToResult(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void setQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Question temp = factory.take();
		QuestionAnswer temp = session.getQuestion();
		String a = temp.getAnswers().get(0).getData();
		String b = temp.getAnswers().get(1).getData();
		String c = temp.getAnswers().get(2).getData();

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Question.jsp");
		request.setAttribute("name", temp.getQuestionContent().getContent());
		request.setAttribute("ans1", a);
		request.setAttribute("ans2", b);
		request.setAttribute("ans3", c);

		dispatcher.forward(request, response);
	}

	public void forwardToResult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Result.jsp");
		request.setAttribute("level", "add some text here");
		request.setAttribute("recomendations", session.getFinalResult());
		dispatcher.forward(request, response);
	}

}
