package com.krontman.service;



import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krontman.model.Portfolio;
import com.krontman.model.Stock;

/**
 * portfolio manager definition
 * @author marga
 *
 */

public class PortfolioManager extends HttpServlet{

	public Portfolio getPortfolio()
	{
		Portfolio portfolio= new Portfolio("Exercise 7 portfolio");
		portfolio.updateBalance(10000);
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		cal1.set(2014, 12, 15);
		cal2.set(2014, 12, 15);
		cal3.set(2014, 12, 15);
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		Stock stock3 = new Stock();
		
		stock1.setSymbol("PIH");
		stock1.setAsk((float)10.0);
		stock1.setBid((float)8.5);
		stock1.setDate(cal1.getTime());
		
		stock2.setSymbol("AAL");
		stock2.setAsk((float)30.0);
		stock2.setBid((float)25.5);
		stock2.setDate(cal2.getTime());
		
		stock3.setSymbol("CAAS");
		stock3.setAsk((float)20.0);
		stock3.setBid((float)15.5);
		stock3.setDate(cal3.getTime());

		portfolio.buyStock(stock1, 20);
		portfolio.buyStock(stock2, 30);
		portfolio.buyStock(stock3, 40);

		portfolio.sellStock("AAL", -1);
		portfolio.removeStock("CAAS");
		
		return portfolio;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}
}
