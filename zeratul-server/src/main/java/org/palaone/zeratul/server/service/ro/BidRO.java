/**
 * 
 */
package org.palaone.zeratul.server.service.ro;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author palaone
 *
 */
public class BidRO {

	@JsonProperty("amount")
	private String amount;

	@JsonProperty("time")
	private String time;
	
	@JsonProperty("confirm")
	private String confirm;
	
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
	 * @return the confirm
	 */
	public String getConfirm() {
		return confirm;
	}

	/**
	 * @param confirm the confirm to set
	 */
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
}
