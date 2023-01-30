package com.xworkz.send.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 2, urlPatterns = "/king")
public class King extends HttpServlet {
	public King() {
		System.out.println("created king using no argumnet constructor....");
	}
	
	@Override
	public void init() throws ServletException {

		System.out.println("started init method to create object of king");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String kingName = req.getParameter("kingName");
		String kingRegion = req.getParameter("kingRegion");
		String kingQueens = req.getParameter("kingQueens");
		String kingDOB = req.getParameter("kingDOB");
		String kingDOD = req.getParameter("kingDOD");

		System.out.println("==================info of king=======================");
		System.out.println("new threads for each request : " + Thread.currentThread().getName());
		System.out.println("kingName : " + kingName);
		System.out.println("kingRegion : " + kingRegion);
		System.out.println("kingQueens : " + kingQueens);
		System.out.println("kingDOB : " + kingDOB);
		System.out.println("kingDOD : " + kingDOD);

		PrintWriter writer = resp.getWriter();

		writer.write("<html>");
		writer.write("<body>");
		writer.write("<span style='color: red'> ");
		writer.write("<h1 style='color: green'>");
		writer.write("successful");
		writer.write("</h1>");
		writer.write(" **kingName : " + kingName);
		writer.write(" **kingRegion : " + kingRegion);
		writer.write(" **kingQueens : " + kingQueens);
		writer.write(" **kingDOB : " + kingDOB);
		writer.write(" **kingDOD : " + kingDOD);
		writer.write("</span>");
		writer.write("</body>");
		writer.write("</html>");
		resp.setContentType("text/html");


	}

}
