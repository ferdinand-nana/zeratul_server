/**
 * 
 */
package org.palaone.zeratul.server.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.palaone.zeratul.server.domain.Bid;
import org.palaone.zeratul.server.domain.Order;
import org.palaone.zeratul.server.domain.User;
import org.palaone.zeratul.server.repository.BidRepository;
import org.palaone.zeratul.server.repository.OrderRepository;
import org.palaone.zeratul.server.repository.UserRepository;
import org.palaone.zeratul.server.service.BidService;
import org.palaone.zeratul.server.service.ro.BidRO;
import org.palaone.zeratul.server.service.util.ConverterUtils;
import org.palaone.zeratul.server.service.vo.BidVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author palaone
 *
 */
@Service
public class BidServiceImpl implements BidService {
	private static final Logger log = LoggerFactory.getLogger(BidServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private BidRepository bidRepository;
	
	@Override
	public BidVO save(long userId, long orderId, BidRO bidRO) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return new BidVO();
		}
		
		Order order = orderRepository.findOne(orderId);
		if (order == null) {
			return new BidVO();
		}
		
		Bid bid = ConverterUtils.convertToBid(user, order, bidRO);
		bidRepository.save(bid);
		return ConverterUtils.convertToBidVO(bid);
	}

	@Override
	public BidVO save(long userId, long orderId, long bidId, BidRO bidRO) {
		User user = userRepository.findOne(userId);
		log.info("User: {}", user);
		if (user == null) {
			return new BidVO();
		}
		
		Order order = orderRepository.findOne(orderId);
		log.info("Order: {}", order);
		if (order == null) {
			return new BidVO();
		}
		
		Bid bid = bidRepository.findOne(bidId);
		if (bid == null) {
			return new BidVO();
		}
		
		bid.setBidAmount(new BigDecimal(bidRO.getAmount()));
		bid.setConfirmed(Boolean.parseBoolean(bidRO.getConfirm()));
		bid.setTargetTime(ConverterUtils.convertToDate(bidRO.getTime()));
		bidRepository.save(bid);
		
		return ConverterUtils.convertToBidVO(bid);
	}

	@Override
	public List<BidVO> findBids(long userId, long orderId) {
		User user = userRepository.findOne(userId);
		log.info("User: {}", user);
		if (user == null) {
			return new ArrayList<BidVO>();
		}
		
		Order order = orderRepository.findOne(orderId);
		log.info("Order: {}", order);
		if (order == null) {
			return new ArrayList<BidVO>();
		}
		
		List<Bid> bids = bidRepository.findByOrderId(orderId);
		log.info("Bids: {}", bids);
		return ConverterUtils.convertToBidVOs(bids);
	}
}
