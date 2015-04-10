/**
 * 
 */
package org.palaone.zeratul.server.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author palaone
 *
 */
@Entity
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Order order;
	
	@OneToOne
	private User bidUser;
	
	@Column(nullable = false)
	private BigDecimal bidAmount;
	
	@Column(nullable = false)
	private Date bidTime;
	
	@Column(nullable = false)
	private Date targetTime;
	
	private boolean confirmed;
	
	private Position bidLocation;

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

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the bidUser
	 */
	public User getBidUser() {
		return bidUser;
	}

	/**
	 * @param bidUser the bidUser to set
	 */
	public void setBidUser(User bidUser) {
		this.bidUser = bidUser;
	}

	/**
	 * @return the bidAmount
	 */
	public BigDecimal getBidAmount() {
		return bidAmount;
	}

	/**
	 * @param bidAmount the bidAmount to set
	 */
	public void setBidAmount(BigDecimal bidAmount) {
		this.bidAmount = bidAmount;
	}

	/**
	 * @return the bidTime
	 */
	public Date getBidTime() {
		return bidTime;
	}

	/**
	 * @param bidTime the bidTime to set
	 */
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}

	/**
	 * @return the targetTime
	 */
	public Date getTargetTime() {
		return targetTime;
	}

	/**
	 * @param targetTime the targetTime to set
	 */
	public void setTargetTime(Date targetTime) {
		this.targetTime = targetTime;
	}

	/**
	 * @return the confirmed
	 */
	public boolean isConfirmed() {
		return confirmed;
	}

	/**
	 * @param confirmed the confirmed to set
	 */
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	/**
	 * @return the bidLocation
	 */
	public Position getBidLocation() {
		return bidLocation;
	}

	/**
	 * @param bidLocation the bidLocation to set
	 */
	public void setBidLocation(Position bidLocation) {
		this.bidLocation = bidLocation;
	}
}
