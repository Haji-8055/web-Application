package com.xworkz.send.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/webSeries")
public class WebSeriesServlet extends HttpServlet {

	public WebSeriesServlet() {

		System.out.println("created WebSeriesServlet using no-argument constructor........");
	}

	@Override
	public void init() throws ServletException {

		System.out.println("started init method to create object of WebSeriesServlet");
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		System.out.println("running service method as request matches url pattern...");
//		
//	}

	@Override
	public void destroy() {
		System.out.println("running destroy method as server is stopped now..");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seriesName = req.getParameter("seriesName");
		String seriesLang = req.getParameter("seriesLang");
		String seriesEpisodes = req.getParameter("seriesEpisodes");
		String seriesOtt = req.getParameter("seriesOtt");
		String seriesBudget = req.getParameter("seriesBudget");

		System.out.println("==================info of web series=======================");
		System.out.println("new threads for each request : " + Thread.currentThread().getName());
		System.out.println("seriesName : " + seriesName);
		System.out.println("seriesLang : " + seriesLang);
		System.out.println("seriesEpisodes : " + seriesEpisodes);
		System.out.println("seriesOtt : " + seriesOtt);
		System.out.println("seriesBudget : " + seriesBudget);

		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<span style='color: red'> ");
		writer.write("<h1 style='color: green'>");
		writer.write("successful");
		writer.write("</h1>");
		writer.write(" **seriesName : " + seriesName);
		writer.write(" **seriesLang : " + seriesLang);
		writer.write(" **seriesEpisodes : " + seriesEpisodes);
		writer.write(" **seriesOtt : " + seriesOtt);
		writer.write(" **seriesBudget : " + seriesBudget);
		writer.write("</span>");
		writer.write("</body>");
		writer.write("</html>");

		
		resp.setContentType("text/html");

	}

}
