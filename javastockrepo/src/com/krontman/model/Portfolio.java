
package com.krontman.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * portfolio definition
 * @author marga
 *
 */

public class Portfolio extends HttpServlet {
	
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int portfolioSize = 0;
	
	/**
	 * c'tor
	 * @param title
	 */
	
	public Portfolio(String title)
	{
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.title= title;
	}
	
	/**
	 * copy c'tor
	 * @param i_port
	 */
	
	public Portfolio (Portfolio i_port)
	{
		
		this.title = i_port.getTitle();
		this.portfolioSize = i_port.getPortfolioSize();
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE]; 
		for(int i=0; i<i_port.portfolioSize; i++)
		{
			this.stocks[i]=new Stock(i_port.getStocks()[i]);
		}
	}
	
	
	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	public Stock[] getStocks()
	{
		return this.stocks;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public int getPortfolioSize ()
	{
		return this.portfolioSize;
	}
	
	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}
	
	/**
	 * add a new stock
	 * @param stock
	 */

	public void addStock(Stock stock)
	{
		this.stocks[portfolioSize] = stock ;
		portfolioSize++;
	}
	
	/**
	 * returns html code
	 * @return string with html code
	 */
	public String getHtmlString()
	{
		String str = new String("<h1>"+this.title +"</h1> </br>" );
		for(int i=0; i<this.portfolioSize; i++)
		{
			str= str+ stocks[i].getHtmlDescription()+ "</br>";
		}
		return str;
		
	}
	/**
	 * remove first stock
	 */
	
	public void removeFirstStock ()
	{
		this.portfolioSize --;
		for(int i=0; i<this.portfolioSize; i++)
		{
			this.stocks[i]=this.stocks[i+1];
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

}
