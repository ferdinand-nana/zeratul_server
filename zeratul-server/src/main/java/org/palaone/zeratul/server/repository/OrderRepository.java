/**
 * 
 */
package org.palaone.zeratul.server.repository;

import java.util.List;

import org.palaone.zeratul.server.domain.Order;
import org.palaone.zeratul.server.domain.type.OrderStatus;
import org.springframework.data.repository.CrudRepository;

/**
 * @author palaone
 *
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByStatusAndUserId(OrderStatus orderStatus, long id);
	
}
