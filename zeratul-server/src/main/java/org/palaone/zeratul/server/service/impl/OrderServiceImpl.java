/**
 * 
 */
package org.palaone.zeratul.server.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.palaone.zeratul.server.domain.Order;
import org.palaone.zeratul.server.domain.User;
import org.palaone.zeratul.server.domain.type.OrderStatus;
import org.palaone.zeratul.server.repository.OrderRepository;
import org.palaone.zeratul.server.repository.UserRepository;
import org.palaone.zeratul.server.service.OrderService;
import org.palaone.zeratul.server.service.ro.OrderRO;
import org.palaone.zeratul.server.service.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author palaone
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public OrderVO save(long userId, OrderRO orderRO) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return new OrderVO();
		}
		
		Order order = covertToOrder(orderRO);
		order.setUser(user);
		orderRepository.save(order);
		
		return convertToOrderVO(order);
//		return createOrderVO(orderRO);
	}
	
	private OrderVO convertToOrderVO(Order order) {
		OrderVO vo = new OrderVO();
		vo.setId(order.getId());
		vo.setTitle(order.getOrderMsg());
		vo.setAmount(order.getAmount());
		vo.setTime(order.getOrderDeliveryTargetTime());
		return vo;
	}

	private Order covertToOrder(OrderRO ro) {
		Order order = new Order();
		order.setOrderMsg(ro.getTitle());
		order.setAmount(new BigDecimal(ro.getAmount()));
		order.setOrderDeliveryTargetTime(convertToDate(ro.getTime()));
		order.setOrderTime(new Date());
		order.setStatus(OrderStatus.FOR_BIDDING);
		return order;
	}

	private Date convertToDate(String timeMillis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(Long.parseLong(timeMillis));
		return cal.getTime();
	}
	
//	private OrderVO createOrderVO(OrderRO orderRO) {
//		OrderVO orderVO = new OrderVO();
//		orderVO.setId(1);
//		orderVO.setTitle(orderRO.getTitle());
//		orderVO.setAmount(new BigDecimal(orderRO.getAmount()));
//		orderVO.setTime(new Date());
//		return orderVO;
//	}
}
