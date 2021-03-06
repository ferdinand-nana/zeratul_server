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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.palaone.zeratul.server.domain.type.OrderStatus;

/**
 * @author palaone
 *
 */
@Entity
@Table(name="user_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "order_user_id")
	private User user;

	@Column(nullable = false, name = "order_msg")
	private String orderMsg;

	@Column(nullable = false, name = "amt")
	private BigDecimal amount;
	
	@Column(nullable = false, name = "order_time")
	private Date orderTime;
	
	@Column(nullable = false, name = "order_target_time")
	private Date orderDeliveryTargetTime;
	
	@Column(name = "order_delivered_time")
	private Date orderDeliveredTime;
	
	@Column(nullable = false, name = "order_status")
	private OrderStatus status = OrderStatus.FOR_BIDDING;
	
	private ContactDetails contactDetails;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the orderMsg
	 */
	public String getOrderMsg() {
		return orderMsg;
	}

	/**
	 * @param orderMsg
	 *            the orderMsg to set
	 */
	public void setOrderMsg(String orderMsg) {
		this.orderMsg = orderMsg;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the orderStatus
	 */
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * @param orderStatus
	 *            the orderStatus to set
	 */
	public void setStatus(OrderStatus orderStatus) {
		this.status = orderStatus;
	}

	/**
	 * @return the orderTime
	 */
	public Date getOrderTime() {
		return orderTime;
	}

	/**
	 * @param orderTime
	 *            the orderTime to set
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * @return the orderDeliveryTargetTime
	 */
	public Date getOrderDeliveryTargetTime() {
		return orderDeliveryTargetTime;
	}

	/**
	 * @param orderDeliveryTargetTime
	 *            the orderDeliveryTargetTime to set
	 */
	public void setOrderDeliveryTargetTime(Date orderDeliveryTargetTime) {
		this.orderDeliveryTargetTime = orderDeliveryTargetTime;
	}

	/**
	 * @return the orderDeliveredTime
	 */
	public Date getOrderDeliveredTime() {
		return orderDeliveredTime;
	}

	/**
	 * @param orderDeliveredTime
	 *            the orderDeliveredTime to set
	 */
	public void setOrderDeliveredTime(Date orderDeliveredTime) {
		this.orderDeliveredTime = orderDeliveredTime;
	}

	/**
	 * @return the contactDetails
	 */
	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", orderMsg=" + orderMsg
				+ ", amount=" + amount + ", orderTime=" + orderTime
				+ ", orderDeliveryTargetTime=" + orderDeliveryTargetTime
				+ ", orderDeliveredTime=" + orderDeliveredTime + ", status="
				+ status + ", contactDetails=" + contactDetails + "]";
	}
}
