/**
 * 
 */
package org.palaone.zeratul.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.palaone.zeratul.server.domain.User;
import org.palaone.zeratul.server.repository.UserRepository;
import org.palaone.zeratul.server.service.UserService;
import org.palaone.zeratul.server.service.ro.PositionRO;
import org.palaone.zeratul.server.service.util.ConverterUtils;
import org.palaone.zeratul.server.service.vo.UserVO;
import org.palaone.zeratul.server.util.ZeratulUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author palaone
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.palaone.zeratul.server.service.UserService#countUsers(double)
	 */
	@Override
	public int countUsers(long userId, double radius) {
		return findUsers(userId, radius).size();
	}
	
	@Override
	public List<UserVO> findUsers(long userId, double radius) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return new ArrayList<UserVO>();
		}

		List<UserVO> vos = new ArrayList<UserVO>();
		for (User u : userRepository.findAll()) {
			if (ZeratulUtils.withinRadius(user.getUserPosition(),
					u.getUserPosition(), radius)) {
				vos.add(ConverterUtils.convertToUserVO(u));
			}
		}
		return vos;
	}

	@Override
	public UserVO savePosition(long userId, PositionRO posRO) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return new UserVO();
		}
		
		user.getUserPosition().setLongitude(Double.parseDouble(posRO.getLongitude()));
		user.getUserPosition().setLatitude(Double.parseDouble(posRO.getLatitude()));
		userRepository.save(user);
		
		return ConverterUtils.convertToUserVO(user);
	}
}
