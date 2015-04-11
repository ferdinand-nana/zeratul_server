/**
 * 
 */
package org.palaone.zeratul.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.palaone.zeratul.server.domain.Bid;
import org.palaone.zeratul.server.domain.Order;
import org.palaone.zeratul.server.domain.Position;
import org.palaone.zeratul.server.domain.User;
import org.palaone.zeratul.server.domain.type.OrderStatus;
import org.palaone.zeratul.server.repository.BidRepository;
import org.palaone.zeratul.server.repository.OrderRepository;
import org.palaone.zeratul.server.repository.UserRepository;
import org.palaone.zeratul.server.service.OrderService;
import org.palaone.zeratul.server.service.ro.OrderRO;
import org.palaone.zeratul.server.service.util.ConverterUtils;
import org.palaone.zeratul.server.service.vo.OrderVO;
import org.palaone.zeratul.server.util.ZeratulUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author palaone
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger log = LoggerFactory
			.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BidRepository bidRepository;

	@Override
	public List<OrderVO> findOrders(long userId, double radius,
			OrderStatus orderStatus) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return new ArrayList<OrderVO>();
		}

		List<Order> orders = orderRepository.findByStatus(orderStatus);
		if (orders == null || orders.isEmpty()) {
			return new ArrayList<OrderVO>();
		}

		List<OrderVO> vos = new ArrayList<OrderVO>();
		Position userPosition = user.getUserPosition();
		for (Order order : orders) {
			if (user.getId() == order.getUser().getId()
					|| ZeratulUtils.withinRadius(userPosition, order.getUser()
							.getUserPosition(), radius)) {

				OrderVO orderVO = ConverterUtils.convertToOrderVO(order);
				List<Bid> bids = bidRepository.findByOrderId(orderVO.getId());
				orderVO.setBids(ConverterUtils.convertToBidVOs(bids));
				vos.add(orderVO);
			}
		}
		return vos;
	}

	@Override
	public OrderVO save(long userId, OrderRO orderRO) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return new OrderVO();
		}

		Order order = ConverterUtils.covertToOrder(orderRO);
		order.setUser(user);
		orderRepository.save(order);

		return ConverterUtils.convertToOrderVO(order);
	}
}
