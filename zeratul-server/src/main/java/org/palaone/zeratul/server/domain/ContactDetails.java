package org.palaone.zeratul.server.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author palaone
 *
 */
@Embeddable
public class ContactDetails {

	@Column
	private String address;
	
	@Column
	private String phoneNumber;
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
}
