/**
 * 
 */
package org.palaone.zeratul.server.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.palaone.zeratul.server.ZeratulServerApp;
import org.palaone.zeratul.server.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author palaone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZeratulServerApp.class)
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	private UserData userData = new UserData();
	
	@Test
	public void addUser() {
		assertNotNull(repository);
		
		User user = userData.addUser();
		repository.save(user);
		assertTrue(user.getId() > 0);
	}
	
	@Test
	public void addUserWithOrders() {
		assertNotNull(repository);
		
		User user = userData.addUser();
		repository.save(user);
		
		user = repository.findOne(user.getId());
		assertNotNull(user);
	}
}
