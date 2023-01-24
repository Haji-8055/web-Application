package com.xworkz.write.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebMethod;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/run")
public class HttpMethodsServlet extends HttpServlet {

	public HttpMethodsServlet() {

		System.out.println("created HttpMethodsServlet using default constructor...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("running do get method.....");
		String data = "diplaying line of do get";
		PrintWriter writer = resp.getWriter();
		writer.print(data);
		resp.setContentType("text/plain");

		// OR
//		resp.getWriter().write("diplaying line of do get");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("running do post method.....");
		resp.getWriter().write("diplaying line of do post");
		resp.setContentType("text/plain");

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("running do delete method.....");
		resp.getWriter().write("diplaying line of do delete");
		resp.setContentType("text/plain");
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("running do Head method.....");
		resp.getWriter().write("diplaying line of do Head");
		resp.setContentType("text/plain");
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("running do Options method.....");
		resp.getWriter().write("diplaying line of do Options");
		resp.setContentType("text/plain");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("running do Put method.....");
		resp.getWriter().write("diplaying line of do Put");
		resp.setContentType("text/plain");
	}

	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("running do trace method.....");
		resp.getWriter().write("diplaying line of do trace");
		resp.setContentType("text/plain");
	}
}