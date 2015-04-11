/**
 * 
 */
package org.palaone.zeratul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;

/**
 * @author palaone
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { VelocityAutoConfiguration.class })
public class ZeratulServerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZeratulServerApp.class, args);
	}

}
