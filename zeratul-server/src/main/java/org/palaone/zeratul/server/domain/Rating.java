/**
 * 
 */
package org.palaone.zeratul.server.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author palaone
 *
 */
@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User rater;
	
	@ManyToOne
	private User ratee;
	
	private String rateComment;
	
	private float rate;
	
	private Date ratedDate;

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
	 * @return the rater
	 */
	public User getRater() {
		return rater;
	}

	/**
	 * @param rater the rater to set
	 */
	public void setRater(User rater) {
		this.rater = rater;
	}

	/**
	 * @return the ratee
	 */
	public User getRatee() {
		return ratee;
	}

	/**
	 * @param ratee the ratee to set
	 */
	public void setRatee(User ratee) {
		this.ratee = ratee;
	}

	/**
	 * @return the rateComment
	 */
	public String getRateComment() {
		return rateComment;
	}

	/**
	 * @param rateComment the rateComment to set
	 */
	public void setRateComment(String rateComment) {
		this.rateComment = rateComment;
	}

	/**
	 * @return the rate
	 */
	public float getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}

	/**
	 * @return the ratedDate
	 */
	public Date getRatedDate() {
		return ratedDate;
	}

	/**
	 * @param ratedDate the ratedDate to set
	 */
	public void setRatedDate(Date ratedDate) {
		this.ratedDate = ratedDate;
	}
}
