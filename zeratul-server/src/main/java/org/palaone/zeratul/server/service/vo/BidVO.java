/**
 * 
 */
package org.palaone.zeratul.server.service.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author palaone
 *
 */
public class BidVO {
	private long id;
	private BigDecimal amount;
	private Date time;
	private boolean confirm;
	private UserVO user;
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
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the user
	 */
	public UserVO getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserVO user) {
		this.user = user;
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

	/**
	 * @return the confirm
	 */
	public boolean isConfirm() {
		return confirm;
	}
	/**
	 * @param confirm the confirm to set
	 */
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidVO [id=" + id + ", amount=" + amount + ", time=" + time
				+ ", confirm=" + confirm + ", user=" + user + "]";
	}
}
