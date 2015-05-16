
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
	
	public enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD};
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int portfolioSize = 0;
	private float balance;
	
	
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
		boolean temp=false;  
		if (this.portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			for(int i=0; i<this.portfolioSize;i++)
			{
				if (this.stocks[i].getSymbol().equals(stock.getSymbol()))
					{
						temp=true;
						break;
					}		
			}
			if(!temp)
			{
				this.stocks[portfolioSize] = stock ;
				this.stocks[portfolioSize].setStockQuantity(0);
				portfolioSize++;
			}
		}
		else
			System.out.println("Can't add new stock, portfolio can have only " +MAX_PORTFOLIO_SIZE +" stocks");
	}
	
	/**
	 * returns html code
	 * @return string with html code
	 */
	public String getHtmlString()
	{
		String str = new String("<h1> Portfolio title: " +this.title +"</h1> </br>" );
		str += "Total portfolio value: " +getTotalValue() +"$, Total stocks value: " +getStockValue() +"$, Balance: " +getBalance() +"$ </br>";
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
	
	/**
	 * Adds the amount to current balance
	 * @param amount
	 */
	
	public void updateBalance(float amount)
	{
		if(this.balance+amount<0)
			System.out.println("Your balance will become negative!!");
		else
			this.balance += amount;	
	}
	
	/**
	 * Method that removes a stock from portfolio
	 * @param symbol
	 * @return
	 */
	
	public boolean removeStock(String symbol)
	{
		for(int i=0; i<this.portfolioSize;i++)
		{
			if (this.stocks[i].getSymbol().equals(symbol))
				{
				this.sellStock(symbol, -1);
				if(i==0)
					removeFirstStock();
				else{
					this.stocks[i]=this.stocks[portfolioSize-1];
					portfolioSize--;
					return true;
					}
				}
		}
		return false;		
	}
	
	/**
	 * method that sell a stock
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	
	public boolean sellStock(String symbol, int quantity)
	{
		if (symbol == null || quantity<-1)
		{
			System.out.println ("The symbol or quantity you entered are NOT valid");
			return false;
		}
		for(int i=0; i<this.portfolioSize;i++)
		{
			if (this.stocks[i].getSymbol().equals(symbol))
				{
					if(this.stocks[i].getStockQuantity()-quantity<0)
					{
						System.out.println ("Not enough stocks to sell");
						return false;
					}	
					else if(quantity == -1)
					{
						this.balance += (this.stocks[i].getStockQuantity()* this.stocks[i].getBid()) ;
						this.stocks[i].setStockQuantity(0);
						return true;
					}
						else
						{
							this.balance += (quantity* this.stocks[i].getBid()) ;
							this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity()-quantity);
							return true;
						}
				}
		}
		return false;
	}
	
	/**
	 * method support the opposite functionality to sellStock
	 * @param stock
	 * @param quantity
	 * @return
	 */
	
	public boolean buyStock(Stock stock, int quantity)
	{
		int tempQuantity;
		if(quantity==-1)
			tempQuantity=(int)(this.balance/stock.getAsk());
		else
			tempQuantity=quantity;
		if(stock.getAsk()*tempQuantity>this.balance)
		{
			System.out.println("Not enought balace to complete purchase!");
			return false;
		}
		this.balance -= tempQuantity * stock.getAsk();	
		for(int i=0; i<this.portfolioSize;i++)
		{
		
			if (this.stocks[i].getSymbol().equals(stock.getSymbol()))
			{	
				stocks[i].setStockQuantity(stocks[i].getStockQuantity()+tempQuantity);
				return true;	
			}
		}
		
		addStock(stock);
		stocks[portfolioSize-1].setStockQuantity(tempQuantity);
		return true;
	}
	 public float getStockValue()
	 {
		 float total=0;
		 for( int i=0; i<portfolioSize; i++)
			 total += (this.stocks[i].getBid()*this.stocks[i].getStockQuantity());
		 return total;
	 }
	 
	 public float getBalance()
	 {
		 return this.balance;
	 }
	 
	 public float getTotalValue()
	 {
		 return getStockValue()+getBalance();
	 }
		
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

}
