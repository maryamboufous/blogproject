package com.xadmin.usermanagement.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.xadmin.usermanagement.bean.Blog;
import com.xadmin.usermanagement.dao.BlogDao;

/**
 * Servlet implementation class BlogServlet
 */
@WebServlet("/")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDao blogDAO;
	
	public void init() {
		blogDAO = new BlogDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBlog(request, response);
				break;
			case "/delete":
				deleteBlog(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBlog(request, response);
				break;
			case "/home":
				homepage(request, response);
				break;
			default:
				listBlog(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listBlog(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		List<Blog> listBlog = blogDAO.selectAllBlogs();
		request.setAttribute("listBlog", listBlog);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blog-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("blog-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException, ClassNotFoundException {
		int id = Integer.parseInt(request.getParameter("id"));
		Blog existingBlog = blogDAO.selectBlog(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blog-form.jsp");
		request.setAttribute("blog", existingBlog);
		dispatcher.forward(request, response);

	}

	private void insertBlog(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		String titre = request.getParameter("titre");
		String soustitre = request.getParameter("soustitre");
		String contenu = request.getParameter("contenu");
		Blog newBlog = new Blog(titre, soustitre, contenu);
		blogDAO.insertBlog(newBlog);
		response.sendRedirect("list");
	}

	private void updateBlog(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		int id = Integer.parseInt(request.getParameter("id"));
		String titre = request.getParameter("titre");
		String soustitre = request.getParameter("soustitre");
		String contenu = request.getParameter("contenu");

		Blog book = new Blog(id, titre, soustitre, contenu);
		blogDAO.updateBlog(book);
		response.sendRedirect("list");
	}

	private void deleteBlog(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		int id = Integer.parseInt(request.getParameter("id"));
		blogDAO.deleteBlog(id);
		response.sendRedirect("list");
		

	}
	
	private void homepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

}