/**
 * 
 */
package org.palaone.zeratul.server.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.palaone.zeratul.server.service.ro.PositionRO;
import org.palaone.zeratul.server.service.vo.BidVO;
import org.palaone.zeratul.server.service.vo.OrderVO;
import org.palaone.zeratul.server.service.vo.UserVO;
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
					|| withinRadius(userPosition, order.getUser()
							.getUserPosition(), radius)) {

				OrderVO orderVO = convertToOrderVO(order);
				List<Bid> bids = bidRepository.findByOrderId(orderVO.getId());
				orderVO.setBids(convertToBidVOs(bids));
				vos.add(orderVO);
			}
		}
		return vos;
	}

	private List<BidVO> convertToBidVOs(List<Bid> bids) {
		if (bids == null || bids.isEmpty()) {
			return new ArrayList<BidVO>();
		}

		List<BidVO> vos = new ArrayList<BidVO>();
		for (Bid bid : bids) {
			vos.add(convertToBidVO(bid));
		}
		return vos;
	}

	private BidVO convertToBidVO(Bid bid) {
		BidVO vo = new BidVO();
		vo.setId(bid.getId());
		vo.setAmount(bid.getBidAmount());
		vo.setTime(bid.getTargetTime());
		vo.setUser(convertToUserVO(bid.getBidUser()));
		return vo;
	}

	private boolean withinRadius(Position pos1, Position pos2, double radius) {
		ZeratulUtils.Point p1 = new ZeratulUtils.Point(pos1.getLongitude(),
				pos1.getLatitude());
		ZeratulUtils.Point p2 = new ZeratulUtils.Point(pos2.getLongitude(),
				pos2.getLatitude());
		
		log.info("P1: {} P2: {} and distance is {} and radius is {}",p1, p2, ZeratulUtils.getCircleDistance(p1, p2), radius);
		return ZeratulUtils.getCircleDistance(p1, p2) <= radius;
	}

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
		// return createOrderVO(orderRO);
	}

	private OrderVO convertToOrderVO(Order order) {
		OrderVO vo = new OrderVO();
		vo.setId(order.getId());
		vo.setTitle(order.getOrderMsg());
		vo.setAmount(order.getAmount());
		vo.setTime(order.getOrderDeliveryTargetTime());
		vo.setUser(convertToUserVO(order.getUser()));
		return vo;
	}

	private UserVO convertToUserVO(User u) {
		UserVO vo = new UserVO();
		vo.setId(u.getId());
		vo.setUsername(u.getUserName());
		// vo.setRating(u.get);
		vo.setLongitude(u.getUserPosition().getLongitude());
		vo.setLatitude(u.getUserPosition().getLatitude());
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

	// private OrderVO createOrderVO(OrderRO orderRO) {
	// OrderVO orderVO = new OrderVO();
	// orderVO.setId(1);
	// orderVO.setTitle(orderRO.getTitle());
	// orderVO.setAmount(new BigDecimal(orderRO.getAmount()));
	// orderVO.setTime(new Date());
	// return orderVO;
	// }
}
