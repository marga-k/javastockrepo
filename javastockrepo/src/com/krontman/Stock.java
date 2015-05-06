package com.krontman;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Stock extends HttpServlet {
	private String symbol;
	private float ask, bid;
	private java.util.Date date;
	private int recommendation;
	private int stockQuantity;
	private int recomendation;
	private final static int BUY= 0;
	private final static int SELL= 1;
	private final static int REMOVE= 2;
	private final static int HOLD= 3;

	
	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public float getAsk() {
		return ask;
	}


	public void setAsk(float ask) {
		this.ask = ask;
	}


	public float getBid() {
		return bid;
	}


	public void setBid(float bid) {
		this.bid = bid;
	}


	public java.util.Date getDate() {
		return date;
	}


	public void setDate(java.util.Date date) {
		this.date = date;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		resp.setContentType("text/html");
		
		
	}
	public String getHtmlDescription()
	{
		String str= new String();
		str= ("<b>Stock symbol: </b>" +this.getSymbol() +"<b>, ask: </b>" +this.getAsk() +"<b>, bid: </b>" +this.getBid() +"<b> , date: </b>" +this.getDate() +"</br>");
		return str;
		
	
	}
}
