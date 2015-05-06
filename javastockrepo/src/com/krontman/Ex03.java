package com.krontman;

import java.io.IOException;
import javax.servlet.http.*;
import java.lang.Math;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class Ex03 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 			throws ServletException, IOException {
		resp.setContentType("text/html");
		int radius = 50;
		//q1
		resp.getWriter().println("</br>");
		resp.getWriter().println("Area of circle with radius " +radius +" is: " +Math.PI * Math.pow(radius, 2) +" square cm ");
		resp.getWriter().println("</br>");
		
		//q2
		double opposite,  degrees;
		double hypotenus = 50;
		degrees = Math.PI/6;
		opposite = (Math.sin(degrees))* hypotenus;
		resp.getWriter().println("</br>");
		resp.getWriter().println("Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: " +opposite +" cm");
		resp.getWriter().println("</br>");

		//q3
		int base, exp;
		base= 20;
		exp=13;
		resp.getWriter().println("</br>");
		resp.getWriter().println("Power of 20 with exp of 13 is: " +Math.pow(base, exp));
		resp.getWriter().println("</br>");

		
		
		
	}
}