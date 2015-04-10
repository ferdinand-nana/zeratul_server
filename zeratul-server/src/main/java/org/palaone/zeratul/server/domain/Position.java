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

	@Column
	private double longitude;
	
	@Column
	private double lattitude;
	
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
	public double getLattitude() {
		return lattitude;
	}
	/**
	 * @param lattitude the lattitude to set
	 */
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
}
