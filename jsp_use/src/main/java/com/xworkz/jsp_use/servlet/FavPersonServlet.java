package com.xworkz.jsp_use.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(loadOnStartup = 1,urlPatterns = "/display")
public class FavPersonServlet extends HttpServlet {

	public FavPersonServlet() {
		super();
		System.out.println("created FavPersonServlet using no arg conrstructor...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String gender = request.getParameter("gender");
		String reason = request.getParameter("reason");
		String address = request.getParameter("address");

		System.out.println("Printing favourite persons details..........");
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		System.out.println("gender : " + gender);
		System.out.println("reason : " + reason);
		System.out.println("address : " + address);

		RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");

		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("gender", gender);
		request.setAttribute("reason", reason);
		request.setAttribute("address", address);
		
		dispatcher.forward(request, response);
	}
	

}
