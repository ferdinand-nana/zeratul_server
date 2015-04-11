/**
 * 
 */
package org.palaone.zeratul.server.controller;

import java.util.List;

import org.palaone.zeratul.server.domain.type.OrderStatus;
import org.palaone.zeratul.server.service.OrderService;
import org.palaone.zeratul.server.service.ro.OrderRO;
import org.palaone.zeratul.server.service.vo.OrderVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author palaone
 *
 */
@Controller
@RequestMapping(value="/users/{userId}/orders", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

//	private static final double coordinates[][] = {{121.05774, 14.58318}, {121.03758, 14.6386}, {121.05977, 14.5856}, {121.05485, 14.58036}, {121.03037, 14.6553}};
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
//	private static AtomicLong count = new AtomicLong(0);
//	private static AtomicLong idCount = new AtomicLong(0);
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public OrderVO addOrder(@PathVariable long userId, @RequestBody OrderRO orderRO) {
		log.info("Create Order for user {}", userId);
		return orderService.save(userId, orderRO);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public List<OrderVO> findOrdersForBidding(@PathVariable long userId,
			@RequestParam(required = false, defaultValue = "0") double radius) {
		log.info("Finding all Orders for bidding for user {} within {} meters", userId, radius);
		return orderService.findOrders(userId, radius, OrderStatus.FOR_BIDDING);
//		log.info("Finding orders for Postion: {}, {}", positionRO.getLongitude(), positionRO.getLatitude());
//		List<OrderVO> orderVOs = findOrders();
//		return orderVOs;
	}

//	private List<OrderVO> findOrders() {
//		List<OrderVO> orderVOs = new ArrayList<OrderVO>();
//		orderVOs.add(createOrderVO());
//		orderVOs.add(createOrderVO());
//		return orderVOs;
//	}
//	
//	private OrderVO createOrderVO() {
//		long counter = count.incrementAndGet();
//		
//		OrderVO orderVO = new OrderVO();
//		orderVO.setId(idCount.incrementAndGet());
//		orderVO.setTitle("Sample Message " + counter);
//		orderVO.setAmount(new BigDecimal(counter));
//		orderVO.setTime(new Date());
//		
//		List<BidVO> bidVOs = new ArrayList<BidVO>();
//		bidVOs.add(createBidVO(0));
//		bidVOs.add(createBidVO(1));
//		bidVOs.add(createBidVO(2));
//		bidVOs.add(createBidVO(3));
//		bidVOs.add(createBidVO(4));
//		orderVO.setBids(bidVOs);
//		
//		return orderVO;
//	}
//	
//	private BidVO createBidVO(int index) {
//		long counter = count.incrementAndGet();
//		
//		BidVO bidVO = new BidVO();
//		bidVO.setId(idCount.incrementAndGet());
//		bidVO.setAmount(new BigDecimal(counter));
//		bidVO.setTime(new Date());
//		bidVO.setUser(createUserVO(index));
//		return bidVO;
//	}
//	
//	private UserVO createUserVO(int index) {
//		long counter = count.incrementAndGet();
//		
//		UserVO userVO = new UserVO();
//		userVO.setId(idCount.incrementAndGet());
//		userVO.setUsername("user" + counter);
//		userVO.setRating(5);
//		userVO.setLongitude(coordinates[index][0]);
//		userVO.setLatitude(coordinates[index][1]);
//		return userVO;
//	}
}
