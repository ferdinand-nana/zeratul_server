/**
 * 
 */
package org.palaone.zeratul.server.service;

import org.palaone.zeratul.server.service.ro.OrderRO;
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
	OrderVO save(OrderRO orderRO);

}
