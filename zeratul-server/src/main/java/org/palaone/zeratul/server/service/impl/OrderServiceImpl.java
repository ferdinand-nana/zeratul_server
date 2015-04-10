/**
 * 
 */
package org.palaone.zeratul.server.service.impl;

import java.util.Date;

import org.palaone.zeratul.server.service.OrderService;
import org.palaone.zeratul.server.service.ro.OrderRO;
import org.palaone.zeratul.server.service.vo.OrderVO;
import org.springframework.stereotype.Service;

/**
 * @author palaone
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public OrderVO save(OrderRO orderRO) {
		return createOrderVO(orderRO);
	}
	
	private OrderVO createOrderVO(OrderRO orderRO) {
		OrderVO orderVO = new OrderVO();
		orderVO.setId(1);
		orderVO.setTitle(orderRO.getTitle());
		orderVO.setAmount(orderRO.getAmount());
		orderVO.setTime(new Date());
		return orderVO;
	}
}
