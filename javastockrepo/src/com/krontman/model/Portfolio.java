package com.krontman.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krontman.Stock;

public class Portfolio extends HttpServlet {
	
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int portfolioSize = 0;
	
	public Portfolio(String title)
	{
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.title= title;
	}
	
	public void addStock(Stock stock)
	{
		this.stocks[portfolioSize] = stock ;
		portfolioSize++;
	}
	
	public Stock[] getStocks()
	{
		return this.stocks;
	}
	
	public String getHtmlString()
	{
		String str = new String("<h1>"+this.title +"</h1> </br>" );
		for(int i=0; i<this.portfolioSize; i++)
		{
			str= str+ stocks[i].getHtmlDescription()+ "</br>";
		}
		return str;
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

}
