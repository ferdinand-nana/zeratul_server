/**
 * 
 */
package org.palaone.zeratul.server.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.palaone.zeratul.server.domain.ContactDetails;
import org.palaone.zeratul.server.domain.Order;
import org.palaone.zeratul.server.domain.User;
import org.palaone.zeratul.server.domain.type.OrderStatus;

/**
 * @author palaone
 *
 */
public class OrderData {
	
	private static AtomicInteger count = new AtomicInteger(0);

	public Order addOrder(User user, OrderStatus orderStatus) {
		int counter = count.incrementAndGet();
		
		Order order = new Order();
		order.setUser(user);
		
		order.setAmount(new BigDecimal(10));
		order.setOrderMsg("This is a message " + counter);
		order.setOrderTime(new Date());
		order.setOrderDeliveryTargetTime(new Date());
		order.setOrderDeliveredTime(new Date());
		order.setStatus(orderStatus);
		
		ContactDetails contact = new ContactDetails();
		contact.setAddress("address " + counter);
		contact.setPhoneNumber("phone " + counter);
		order.setContactDetails(contact);
		
		return order;
	}
}
