/**
 * 
 */
package org.palaone.zeratul.server.controller;

import java.util.List;

import org.palaone.zeratul.server.service.BidService;
import org.palaone.zeratul.server.service.OrderService;
import org.palaone.zeratul.server.service.ro.BidRO;
import org.palaone.zeratul.server.service.vo.BidVO;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author palaone
 *
 */
@Controller
@RequestMapping(value="{userId}/orders/{orderId}/bids", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class BidController {

	private static final Logger log = LoggerFactory.getLogger(BidController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BidService bidService;
	
	@RequestMapping(value="/{bidUserId}", method=RequestMethod.POST)
	@ResponseBody
	public BidVO addBid(@PathVariable long bidUserId, @PathVariable long orderId, @RequestBody BidRO bidRO) {
		log.info("User {} is creating Bid for order {}", bidUserId, orderId);
		return bidService.save(bidUserId, orderId, bidRO);
	}
	
	@RequestMapping(value="/{bidUserId}/{bidId}", method=RequestMethod.POST)
	@ResponseBody
	public BidVO updateBid(@PathVariable long userId, @PathVariable long orderId, @PathVariable long bidId, @RequestBody BidRO bidRO) {
		log.info("User {} is creating Bid for order {}", userId, orderId);
		return bidService.save(userId, orderId, bidId, bidRO);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public List<BidVO> findBids(@PathVariable long userId, @PathVariable long orderId) {
		log.info("Find all bids for order {} for user {}", orderId, userId);
		return bidService.findBids(userId, orderId);
	}
}
