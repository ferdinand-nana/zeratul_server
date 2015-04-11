package org.palaone.zeratul.server.service.ro;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionRO implements Serializable {
	private static final long serialVersionUID = 2061656862028114271L;

	@JsonProperty("longitude")
	private String longitude;
	
	@JsonProperty("latitude")
	private String latitude;
	
	/**
	 * @return the title
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param title the title to set
	 */
	public void setLongitude(String title) {
		this.longitude = title;
	}
	/**
	 * @return the time
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param time the time to set
	 */
	public void setLatitude(String time) {
		this.latitude = time;
	}
}
