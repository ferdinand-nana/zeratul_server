package org.palaone.zeratul.server.repository;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.palaone.zeratul.server.domain.User;

public class UserData {
	private static AtomicInteger count = new AtomicInteger(0);
	
	public User addUser() {
		int counter = count.incrementAndGet();
		
		User user = new User();
		user.setUserName("username" + counter);
		user.setPassword("password" + counter);
		user.setUserPositionTime(new Date());
		
		return user;
	}
}