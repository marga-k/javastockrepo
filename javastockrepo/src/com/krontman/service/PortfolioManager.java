package com.krontman.service;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krontman.Stock;
import com.krontman.model.Portfolio;

public class PortfolioManager extends HttpServlet{

	public Portfolio getPortfolio()
	{
		Portfolio portfolio= new Portfolio("My Portfolio");
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		cal1.set(2014, 11, 15);
		cal2.set(2014, 11, 15);
		cal3.set(2014, 11, 15);
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		Stock stock3 = new Stock();
		
		stock1.setSymbol("PIH");
		stock1.setAsk((float)13.1);
		stock1.setBid((float)12.4);
		stock1.setDate(cal1.getTime());
		
		stock2.setSymbol("AAL");
		stock2.setAsk((float)5.78);
		stock2.setBid((float)5.5);
		stock2.setDate(cal2.getTime());
		
		stock3.setSymbol("CAAS");
		stock3.setAsk((float)32.2);
		stock3.setBid((float)31.5);
		stock3.setDate(cal3.getTime());
		
		portfolio.addStock(stock1);
		portfolio.addStock(stock2);
		portfolio.addStock(stock3);
		
		return portfolio;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}
}