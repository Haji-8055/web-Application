package com.xworkz.navigation.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 4, urlPatterns = "/location")
public class LocationServlet extends HttpServlet {

	public LocationServlet() {

		System.out.println("created  LocationServlet using no-arg constructor.........");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String locationName = req.getParameter("locationName");
		String locEmail = req.getParameter("locEmail");
		String startPoint = req.getParameter("startPoint");
		String destination = req.getParameter("destination");
		String locGender = req.getParameter("locGender");

		System.out.println("=================printing location info===================");
		System.out.println("locationName : " + locationName);
		System.out.println("Email : " + locEmail);
		System.out.println("startPoint : " + startPoint);
		System.out.println("destination : " + destination);
		System.out.println("Gender : " + locGender);

		boolean a = locationName.length() > 3;
		boolean b = locEmail.length() > 3;
		boolean c = startPoint.length() > 3;
		boolean d = destination.length() > 3;

		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");

		writer.write("=================printing location info===================");
		if (a) {
			writer.write("-->locationName : " + locationName);
		} else {
			writer.write("   ,name should be greater than 3");
		}
		if (b) {
			writer.write("-->Email : " + locEmail);
		} else {
			writer.write("  ,email should be greater than 3");
		}
		if (c) {
			writer.write("-->startPoint : " + startPoint);
		} else {
			writer.write("   ,startPoint should be greater than 3");
		}
		if (d) {
			writer.write("-->destination : " + destination);
		} else {
			writer.write("   ,destination should be greater than 3");
		}
		if (locGender == null) {
			writer.write("plz select gender");
		} else {
			writer.write("-->Gender : " + locGender);

		}

		if (a && b && c && d) {
			writer.write("<h1 style='color: green'>");
			writer.write("registration successful");
			writer.write("</h1>");
		} else {
			writer.write("<h1 style='color: red'>");
			writer.write("registration unsuccessful");
			writer.write("</h1>");

		}

		writer.write("<a href=\"location.html\">click here to fill again about location</a>");
		writer.write("<br>");
		writer.write("<a href=\"index.html\">click here to go home page</a>");

		writer.write("</body>");
		writer.write("</html>");



		resp.setContentType("text/html");
		
	}
}
