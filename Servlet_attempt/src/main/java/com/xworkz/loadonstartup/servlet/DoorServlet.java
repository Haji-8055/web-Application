package com.xworkz.loadonstartup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 2, urlPatterns = "/open")
public class DoorServlet extends HttpServlet {

	public DoorServlet() {
		System.out.println("created DoorServlet using servlet......");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("running do get in DoorServlet....");
	}
	

}
