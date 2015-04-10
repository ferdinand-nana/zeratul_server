package org.palaone.zeratul.server.repository;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.palaone.zeratul.server.ZeratulServerApp;
import org.palaone.zeratul.server.domain.Rating;
import org.palaone.zeratul.server.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZeratulServerApp.class)
public class RatingRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	private UserData userData = new UserData();
	
	@Test
	public void addRating() {
		User rater = userData.addUser();
		userRepository.save(rater);
		assertTrue(rater.getId() > 0);
		
		User ratee = userData.addUser();
		userRepository.save(ratee);
		assertTrue(ratee.getId() > 0);
		
		Rating rating = new Rating();
		rating.setRate(1);
		rating.setRatedDate(new Date());
		rating.setRateComment("Comment ");
		rating.setRatee(ratee);
		rating.setRater(rater);
		
		ratingRepository.save(rating);
		assertTrue(rating.getId() > 0);
	}
	
	
	@Test
	public void getAverageRating() {
		User rater = userData.addUser();
		userRepository.save(rater);
		assertTrue(rater.getId() > 0);
		
		User ratee = userData.addUser();
		userRepository.save(ratee);
		assertTrue(ratee.getId() > 0);
		
		Rating rating = new Rating();
		rating.setRate(1);
		rating.setRatedDate(new Date());
		rating.setRateComment("Comment ");
		rating.setRatee(ratee);
		rating.setRater(rater);
		
		ratingRepository.save(rating);
		assertTrue(rating.getId() > 0);
		
		
		rater = userData.addUser();
		userRepository.save(rater);
		assertTrue(rater.getId() > 0);
		
		rating = new Rating();
		rating.setRate(2);
		rating.setRatedDate(new Date());
		rating.setRateComment("Comment ");
		rating.setRatee(ratee);
		rating.setRater(rater);
		
		ratingRepository.save(rating);
		assertTrue(rating.getId() > 0);
		
		float rate = ratingRepository.averageRatingByRateeId(ratee.getId());
		assertEquals(1.5f, rate, 0);
	}

}
