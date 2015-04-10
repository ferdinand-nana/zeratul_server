/**
 * 
 */
package org.palaone.zeratul.server.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.palaone.zeratul.server.domain.Bid;
import org.palaone.zeratul.server.domain.Order;
import org.palaone.zeratul.server.domain.User;

/**
 * @author palaone
 *
 */
public class BidData {
	
	public Bid addBid(User user, Order order) {
		Bid bid = new Bid();
		bid.setBidAmount(new BigDecimal(10));
		bid.setBidTime(new Date());
		bid.setTargetTime(new Date());
		bid.setBidUser(user);
		bid.setOrder(order);
		return bid;
	}
}
