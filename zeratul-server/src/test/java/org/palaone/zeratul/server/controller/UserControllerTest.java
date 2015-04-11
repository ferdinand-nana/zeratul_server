/**
 * 
 */
package org.palaone.zeratul.server.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.palaone.zeratul.server.ZeratulServerApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author palaone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZeratulServerApp.class)
@WebAppConfiguration
@ActiveProfiles("scratch")
// Separate profile for web tests to avoid clashing databases
public class UserControllerTest {
	private static final Logger log = LoggerFactory.getLogger(UserControllerTest.class);
	
	private static final String USER_URL = "/users/{userId}";
	private static final long DEF_USER_ID = 1l;
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testUpdateUserPosition() throws Exception {
		String body = "{\"longitude\":\"121.05977\",\"latitude\":\"14.5856\"}";
		log.info("Position: {}", body);
		
		this.mvc.perform(post(USER_URL, DEF_USER_ID).contentType(MediaType.APPLICATION_JSON_VALUE).content(body)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testFindUserCount() throws Exception {
		this.mvc.perform(get(USER_URL, DEF_USER_ID).param("count", "true").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andDo(print());
		this.mvc.perform(get(USER_URL, DEF_USER_ID).param("count", "true").param("radius", "1000").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andDo(print());
		this.mvc.perform(get(USER_URL, DEF_USER_ID).param("count", "false").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andDo(print());
		this.mvc.perform(get(USER_URL, DEF_USER_ID).param("count", "false").param("radius", "3000").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andDo(print());
	}

}
