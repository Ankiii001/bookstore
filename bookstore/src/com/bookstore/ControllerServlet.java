package com.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookDAO.BookDAO;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/books/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Book> booklist = new ArrayList<Book>();
	private BookDAO bookDAO;
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() throws SQLException, ClassNotFoundException {
		bookDAO = new BookDAO();
		bookDAO.connect();
		
		// Add books to our ArrayList
		booklist.add(new Book("To Kill a Mockingbird", "happy Singh", 312f));
		booklist.add(new Book("To Kill", "Rishabh", 452f));
		booklist.add(new Book("Mockingbird", "bhuvesh Gargh", 512f));
		bookDAO.disconnect();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action= request.getPathInfo();
		if (action.equals("/new")) {
			addbook(request,response);
		}
		else {
			listBooks(request,response);
		}
	

	}

	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("book_list", booklist);
		request.getRequestDispatcher("/BookList.jsp").forward(request, response);
		
	}

	private void addbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/BookForm.jsp").forward(request, response);
		
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
		String action= request.getPathInfo();
		if (action.equals("/insert")) {
			insertbook(request,response);
		}
	}

	private void insertbook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("booktitle");
		String author = request.getParameter("bookauthor");
		String priceString = request.getParameter("bookprice");
		
		Book newBook = new Book(title, author, Float.parseFloat(priceString));
		booklist.add(newBook);
		
		response.sendRedirect("List");
	}

}