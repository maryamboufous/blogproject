package com.xadmin.usermanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.xadmin.usermanagement.bean.Login;
import com.xadmin.usermanagement.dao.LoginDao;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() // default constructor
    {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
 
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
 
        Login loginBean = new Login(); 
 
        loginBean.setUserName(userName); 
         loginBean.setPassword(password);
 
        LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.
 
        String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
 
        if(userValidate.equals("SUCCESS")) 
         {
             request.setAttribute("userName", userName); 
             request.getRequestDispatcher("home.jsp").forward(request, response);
         }
         else
         {
             request.setAttribute("errMessage", userValidate); 
             request.getRequestDispatcher("Error.jsp").forward(request, response);//forwarding the request
         }
    }}