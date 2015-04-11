/**
 * 
 */
package org.palaone.zeratul.server.service;

import java.util.List;

import org.palaone.zeratul.server.service.ro.BidRO;
import org.palaone.zeratul.server.service.vo.BidVO;

/**
 * @author palaone
 *
 */
public interface BidService {

	BidVO save(long userId, long orderId, BidRO bidRO);

	BidVO save(long userId, long orderId, long bidId, BidRO bidRO);
	
	List<BidVO> findBids(long userId, long orderId);
}
