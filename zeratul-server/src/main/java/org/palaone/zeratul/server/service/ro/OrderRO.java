package org.palaone.zeratul.server.service.ro;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRO implements Serializable {
	
	private static final long serialVersionUID = 8390413657212916763L;

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("time")
	private String time;
	
	@JsonProperty("amount")
	private String amount;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
