/**
 * 
 */
package org.palaone.zeratul.server.service;

import java.util.List;

import org.palaone.zeratul.server.service.ro.PositionRO;
import org.palaone.zeratul.server.service.vo.UserVO;

/**
 * @author palaone
 *
 */
public interface UserService {

	int countUsers(long userId, double radius);

	List<UserVO> findUsers(long userId, double radius);

	UserVO savePosition(long userId, PositionRO posRO);
}
