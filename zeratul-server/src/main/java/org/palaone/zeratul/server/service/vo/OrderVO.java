package org.palaone.zeratul.server.service.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderVO {
	private long id;
	private String title;
	private Date time;
	private BigDecimal amount;
	private List<BidVO> bids;

	/**
	 * @return the orderMsg
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param orderMsg the orderMsg to set
	 */
	public void setTitle(String orderMsg) {
		this.title = orderMsg;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the orderDeliveryTargetTime
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param orderDeliveryTargetTime the orderDeliveryTargetTime to set
	 */
	public void setTime(Date orderDeliveryTargetTime) {
		this.time = orderDeliveryTargetTime;
	}

	/**
	 * @return the bids
	 */
	public List<BidVO> getBids() {
		return bids;
	}

	/**
	 * @param bids the bids to set
	 */
	public void setBids(List<BidVO> bids) {
		this.bids = bids;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
}
