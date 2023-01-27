package com.xworkz.send.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/work")
public class Employee extends HttpServlet {

	public Employee() {
		System.out.println("created employee using no-arg constructor...");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("started init to create object of employee.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("running doGet of Employee");
	String name=req.getParameter("Name");
	String age=req.getParameter("Age");
	String gender=req.getParameter("Gender");
	String jobType=req.getParameter("JobType");
	String job=req.getParameter("Job");
	String salary=req.getParameter("Salary");
	String maritalStatus=req.getParameter("MaritalStatus");
	String height=req.getParameter("Height");
	String weight=req.getParameter("Weight");
	String contact=req.getParameter("Contact");
	String city=req.getParameter("City");
	String emailId=req.getParameter("EmailId");
	String recruitedDate=req.getParameter("RecruitedDate");
	String noOfChildrens=req.getParameter("NoOfChildrens");
	String qualification=req.getParameter("Qualification");
	String location=req.getParameter("Location");
	String experience=req.getParameter("Experience");
	String religion=req.getParameter("Religion");
	String nationality=req.getParameter("Nationality");
	String DOB=req.getParameter("DOB");
	
	System.out.println("===============employee info=====================");
	System.out.println(name);
	System.out.println(age);
	System.out.println(gender);
	System.out.println(jobType);
	System.out.println(job);
	System.out.println(salary);
	System.out.println(maritalStatus);
	System.out.println(height);
	System.out.println(weight);
	System.out.println(contact);
	System.out.println(city);
	System.out.println(emailId);
	System.out.println(recruitedDate);
	System.out.println(noOfChildrens);
	System.out.println(qualification);
	System.out.println(location);
	System.out.println(experience);
	System.out.println(religion);
	System.out.println(nationality);
	System.out.println(DOB);
	
	PrintWriter write=resp.getWriter();
	write.print("<html>");
	write.print("<body>");
	write.print("<h1>");
	write.print("<span style='color:green'>");
	write.print("name : "+name);
	write.print("age : "+age);
	write.print(" gender: "+gender);
	write.print(" jobType: "+jobType);
	write.print("job : "+job);
	write.print("salary : "+salary);
	write.print("maritalStatus : "+maritalStatus);
	write.print("height : "+height);
	write.print("weight : "+weight);
	write.print("contact : "+contact);
	write.print("city : "+city);
	write.print("emailId : "+emailId);
	write.print(" recruitedDate: "+recruitedDate);
	write.print("noOfChildrens : "+noOfChildrens);
	write.print("qualification : "+qualification);
	write.print(" location: "+location);
	write.print("experience : "+experience);
	write.print(" religion: "+religion);
	write.print(" nationality: "+nationality);
	write.print(" DOB: "+DOB);
	write.print("</span>");
	write.print("</h1>");
	write.print("</body>");
	write.print("</html>");
	resp.setContentType("text/html");

	
	
	}
}
