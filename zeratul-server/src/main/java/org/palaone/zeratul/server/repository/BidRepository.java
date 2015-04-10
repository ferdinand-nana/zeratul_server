/**
 * 
 */
package org.palaone.zeratul.server.repository;

import java.util.List;

import org.palaone.zeratul.server.domain.Bid;
import org.springframework.data.repository.CrudRepository;

/**
 * @author palaone
 *
 */
public interface BidRepository extends CrudRepository<Bid, Long> {

	List<Bid> findByOrderId(long orderId);
}
