/**
 * 
 */
package org.palaone.zeratul.server.service.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.palaone.zeratul.server.domain.Bid;
import org.palaone.zeratul.server.domain.Order;
import org.palaone.zeratul.server.domain.User;
import org.palaone.zeratul.server.domain.type.OrderStatus;
import org.palaone.zeratul.server.service.ro.BidRO;
import org.palaone.zeratul.server.service.ro.OrderRO;
import org.palaone.zeratul.server.service.vo.BidVO;
import org.palaone.zeratul.server.service.vo.OrderVO;
import org.palaone.zeratul.server.service.vo.UserVO;

/**
 * @author palaone
 *
 */
public final class ConverterUtils {

	private static final float DEF_RATING = 4.5f;
	
	private ConverterUtils() {
		// Do Nothing
	}
	
	public static UserVO convertToUserVO(User u) {
		UserVO vo = new UserVO();
		vo.setId(u.getId());
		vo.setUsername(u.getUserName());
		vo.setRating(DEF_RATING);
		vo.setLongitude(u.getUserPosition().getLongitude());
		vo.setLatitude(u.getUserPosition().getLatitude());
		return vo;
	}
	
	public static OrderVO convertToOrderVO(Order order) {
		OrderVO vo = new OrderVO();
		vo.setId(order.getId());
		vo.setTitle(order.getOrderMsg());
		vo.setAmount(order.getAmount());
		vo.setTime(order.getOrderDeliveryTargetTime());
		vo.setUser(convertToUserVO(order.getUser()));
		return vo;
	}

	public static Order covertToOrder(OrderRO ro) {
		Order order = new Order();
		order.setOrderMsg(ro.getTitle());
		order.setAmount(new BigDecimal(ro.getAmount()));
		order.setOrderDeliveryTargetTime(convertToDate(ro.getTime()));
		order.setOrderTime(new Date());
		order.setStatus(OrderStatus.FOR_BIDDING);
		return order;
	}
	
	public static  List<BidVO> convertToBidVOs(List<Bid> bids) {
		if (bids == null || bids.isEmpty()) {
			return new ArrayList<BidVO>();
		}

		List<BidVO> vos = new ArrayList<BidVO>();
		for (Bid bid : bids) {
			vos.add(convertToBidVO(bid));
		}
		return vos;
	}
	
	public static Bid convertToBid(User bidUser, Order order, BidRO ro) {
		Bid bid = new Bid();
		bid.setOrder(order);
		bid.setBidUser(bidUser);
		bid.setBidAmount(new BigDecimal(ro.getAmount()));
		bid.setTargetTime(ConverterUtils.convertToDate(ro.getTime()));
		bid.setBidTime(new Date());
		return bid;
	}

	public static  BidVO convertToBidVO(Bid bid) {
		BidVO vo = new BidVO();
		vo.setId(bid.getId());
		vo.setAmount(bid.getBidAmount());
		vo.setTime(bid.getTargetTime());
		vo.setUser(ConverterUtils.convertToUserVO(bid.getBidUser()));
		return vo;
	}

	public static Date convertToDate(String timeMillis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(Long.parseLong(timeMillis));
		return cal.getTime();
	}
}
