package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/books/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Book> booklist = new ArrayList<Book>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		// Add books to our ArrayList
		booklist.add(new Book("To Kill a Mockingbird", "happy Singh", 312f));
		booklist.add(new Book("To Kill", "Rishabh", 452f));
		booklist.add(new Book("Mockingbird", "bhuvesh Gargh", 512f));

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("book_list", booklist);
		request.getRequestDispatcher("/BookList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 *      A form should use a GET request if it is requesting or searching for
	 *      data from the server. If the form is going to update data on the server
	 *      the request should be a POST.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		output.println("<h1>" + "Book title : " + title + "</h1>");
		output.println("<h1>" + "Book Author : " + author + "</h1>");
	}

}
