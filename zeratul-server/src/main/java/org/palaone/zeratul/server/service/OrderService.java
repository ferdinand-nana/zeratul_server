/**
 * 
 */
package org.palaone.zeratul.server.service;

import java.util.List;

import org.palaone.zeratul.server.domain.type.OrderStatus;
import org.palaone.zeratul.server.service.ro.OrderRO;
import org.palaone.zeratul.server.service.ro.PositionRO;
import org.palaone.zeratul.server.service.vo.OrderVO;

/**
 * @author palaone
 *
 */
public interface OrderService {

	/**
	 * 
	 * @param orderRO
	 * @return
	 */
	OrderVO save(long userId, OrderRO orderRO);

	/**
	 * 
	 * @param userId 
	 * @param radius 
	 * @param orderStatus
	 * @param positionRO
	 * @return
	 */
	List<OrderVO> findOrders(long userId, double radius, OrderStatus orderStatus);
}
