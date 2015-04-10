/**
 * 
 */
package org.palaone.zeratul.server.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.palaone.zeratul.server.service.vo.BidVO;
import org.palaone.zeratul.server.service.vo.OrderVO;
import org.palaone.zeratul.server.service.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author palaone
 *
 */
@Controller
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	private static AtomicLong count = new AtomicLong(0);
	
	
	@RequestMapping("/order/find/{longitude}/{latitude}")
	@ResponseBody
	@Transactional(readOnly = true)
	public List<OrderVO> findOrdersForBidding(@PathVariable double longitude, @PathVariable double latitude ) {
		log.info("Finding orders for Postion: {}, {}", longitude, latitude);
		List<OrderVO> orderVOs = findOrders();
		return orderVOs;
	}

	private List<OrderVO> findOrders() {
		List<OrderVO> orderVOs = new ArrayList<OrderVO>();
		orderVOs.add(createOrderVO());
		orderVOs.add(createOrderVO());
		return orderVOs;
	}
	
	private OrderVO createOrderVO() {
		long counter = count.incrementAndGet();
		
		OrderVO orderVO = new OrderVO();
		orderVO.setTitle("Sample Message " + counter);
		orderVO.setAmount(new BigDecimal(counter));
		orderVO.setTime(new Date());
		
		List<BidVO> bidVOs = new ArrayList<BidVO>();
		bidVOs.add(createBidVO());
		bidVOs.add(createBidVO());
		bidVOs.add(createBidVO());
		bidVOs.add(createBidVO());
		bidVOs.add(createBidVO());
		orderVO.setBids(bidVOs);
		
		return orderVO;
	}
	
	private BidVO createBidVO() {
		long counter = count.incrementAndGet();
		
		BidVO bidVO = new BidVO();
		bidVO.setAmount(new BigDecimal(counter));
		bidVO.setTime(new Date());
		bidVO.setUser(createUserVO());
		return bidVO;
	}
	
	private UserVO createUserVO() {
		long counter = count.incrementAndGet();
		
		UserVO userVO = new UserVO();
		userVO.setUsername("user" + counter);
		userVO.setRating(5);
		return userVO;
	}
}
