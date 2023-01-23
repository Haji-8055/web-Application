package com.xworkz.loadonstartup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 2, urlPatterns = "/rotate")
public class WheelServlet extends HttpServlet {

	public WheelServlet() {
		System.out.println("created WheelServlet using servlet......");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("running do get in WheelServlet....");
	}
	

}
