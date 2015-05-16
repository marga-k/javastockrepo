

package com.krontman.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krontman.model.Portfolio.ALGO_RECOMMENDATION;

/** 
 * stock definition
 * @author marga
 *
 */

public class Stock extends HttpServlet {
	private String symbol;
	private float ask, bid;
	private java.util.Date date;
	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;
	

	/**
	 * empty c'tor
	 */
	public Stock ()
	{
	
	}
	
	/**
	 * c'tor
	 * @param i_symbol
	 * @param i_ask
	 * @param i_bid
	 * @param i_date
	 * @param i_record
	 * @param i_stockQuantity
	 */
	
	public Stock(String i_symbol, float i_ask, float i_bid, java.util.Date i_date, ALGO_RECOMMENDATION i_record, int i_stockQuantity)
	{
		this.symbol = i_symbol;
		this.ask = i_ask;
		this.bid = i_bid;
		this.date = i_date;
		this.recommendation = i_record;
		this.stockQuantity = i_stockQuantity;
	}
	/**
	 * copy c'tor
	 * @param i_stock
	 */
	public Stock(Stock i_stock)
	{
		this.symbol = i_stock.getSymbol();
		this.ask = i_stock.getAsk();
		this.bid = i_stock.getBid();
		this.date = i_stock.getDate();
		this.recommendation = i_stock.getRecommendation();
		this.stockQuantity = i_stock.getStockQuantity();
	}
	
	public String getSymbol() {
		return symbol;
	}


	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}


	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}


	public int getStockQuantity() {
		return stockQuantity;
	}


	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
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
	
	/**
	 * get html description
	 * @return string with html description
	 */
	public String getHtmlDescription()
	{
		String str= new String();
		str= ("<b>Stock symbol: </b>" +this.getSymbol() +"<b>, ask: </b>" +this.getAsk() +"<b>, bid: </b>" +this.getBid() +"<b> , date: </b>" +this.getDate()  +"<b> , quantity: </b>" +this.getStockQuantity() +"</br>");
		return str;
		
	
	}
}
