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
public class OrderControllerTest {
	private static final Logger log = LoggerFactory.getLogger(OrderControllerTest.class);
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testFindOrders() throws Exception {
		this.mvc.perform(get("/order/1/find/20000").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print());
//		this.mvc.perform(get("/order/1/find/1/1").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}
	
	@Test
	public void testSaveOrder() throws Exception {
		String body = "{\"title\":\"Sample Mesage\",\"time\":\"" + System.currentTimeMillis() + "\",\"amount\":\"10\"}";
		log.info("Save Order Body: {}", body);
		
		this.mvc.perform(post("/order/{userId}/add", 1L).contentType(MediaType.APPLICATION_JSON_VALUE).content(body)).andDo(print()).andExpect(status().isOk());
	}

}
