/**
 * 
 */
package org.palaone.zeratul.server.controller;

import java.util.List;

import org.palaone.zeratul.server.service.UserService;
import org.palaone.zeratul.server.service.ro.PositionRO;
import org.palaone.zeratul.server.service.vo.UserVO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author palaone
 *
 */
@Controller
@RequestMapping(value = "/users/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	private static final Logger log = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public UserVO updateUserPosition(@PathVariable long userId,
			@RequestBody PositionRO posRO) {
		log.info("Update position for user {}", userId);
		return userService.savePosition(userId, posRO);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public Object findUsers(@PathVariable long userId, @RequestParam(required = false, defaultValue = "false") boolean count,
			@RequestParam(required = false, defaultValue = "0") double radius) {
		if (count) {
			log.info("Count all users within {} meters", radius);
			return userService.countUsers(userId, radius);
		}
		
		log.info("Find all users within {} meters", radius);
		List<UserVO> vos = userService.findUsers(userId, radius);
		return vos;
	}
}
