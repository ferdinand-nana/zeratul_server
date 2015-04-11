/**
 * 
 */
package org.palaone.zeratul.server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.palaone.zeratul.server.domain.type.UserType;

/**
 * @author palaone
 *
 */
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, name = "user_nm")
	private String userName;
	
	@Column(nullable = false, name = "passwd")
	private String password;
	
	@Column(name = "user_typ")
	private UserType userType = UserType.USER;

	private Position userPosition;
	
	private ContactDetails contactDetails;
	
	
	@Column(name = "user_pos_time")
	private Date userPositionTime;
	
//	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
//	private List<Order> orders;
	
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * @return the userPositionTime
	 */
	public Date getUserPositionTime() {
		return userPositionTime;
	}

	/**
	 * @param userPositionTime the userPositionTime to set
	 */
	public void setUserPositionTime(Date userPositionTime) {
		this.userPositionTime = userPositionTime;
	}

	/**
	 * @return the userPosition
	 */
	public Position getUserPosition() {
		return userPosition;
	}

	/**
	 * @param userPosition the userPosition to set
	 */
	public void setUserPosition(Position userPosition) {
		this.userPosition = userPosition;
	}

//	/**
//	 * @return the orders
//	 */
//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	/**
//	 * @param orders the orders to set
//	 */
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}
	
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", userType=" + userType + ", userPosition="
				+ userPosition + ", contactDetails=" + contactDetails
				+ ", userPositionTime=" + userPositionTime + "]";
	}
	
}
