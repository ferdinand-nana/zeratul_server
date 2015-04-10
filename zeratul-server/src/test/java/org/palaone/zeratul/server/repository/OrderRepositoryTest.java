/**
 * 
 */
package org.palaone.zeratul.server.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.palaone.zeratul.server.ZeratulServerApp;
import org.palaone.zeratul.server.domain.Order;
import org.palaone.zeratul.server.domain.User;
import org.palaone.zeratul.server.domain.type.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author palaone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZeratulServerApp.class)
public class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private UserData userData = new UserData();
	private OrderData orderData = new OrderData();
	
	@Test
	public void addOrder() {
		assertNotNull(userRepository);
		assertNotNull(orderRepository);
		
		User user = userData.addUser();
		userRepository.save(user);
		assertTrue(user.getId() > 0);
		
		Order order = orderData.addOrder(user, OrderStatus.FOR_BIDDING);
		orderRepository.save(order);
		assertTrue(orderRepository.count() > 0);
	}
	
	@Test
	public void addConfirmedOrder() {
		assertNotNull(userRepository);
		assertNotNull(orderRepository);
		
		User user = userData.addUser();
		userRepository.save(user);
		assertTrue(user.getId() > 0);
		
		Order order = orderData.addOrder(user, OrderStatus.CONFIRMED);
		orderRepository.save(order);
		assertTrue(orderRepository.count() > 0);
		
		List<Order> confirmedOrders = orderRepository.findByStatusAndUserId(OrderStatus.CONFIRMED, user.getId());
		assertNotNull(confirmedOrders);
		assertTrue(confirmedOrders.size() > 0);
	}
}
