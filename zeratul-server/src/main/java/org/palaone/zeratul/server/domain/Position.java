/**
 * 
 */
package org.palaone.zeratul.server.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author palaone
 *
 */
@Embeddable
public class Position {

	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "latitude")
	private double latitude;
	
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the lattitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param lattitude the lattitude to set
	 */
	public void setLatitude(double lattitude) {
		this.latitude = lattitude;
	}
}
