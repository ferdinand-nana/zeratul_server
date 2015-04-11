package org.palaone.zeratul.server.util;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZeratulUtilsTest {
	private static final Logger log = LoggerFactory.getLogger(ZeratulUtilsTest.class);
	
	private static final double LONGITUDE_1 = 121.05774;
	private static final double LATITUDE_1 = 14.58318;
	private static final double LONGITUDE_2 = 121.03758;
	private static final double LATITUDE_2 = 14.6386;
	
	@Test
	public void testGetCircleDistance() throws JSONException {
		ZeratulUtils.Point point1 = new ZeratulUtils.Point(LONGITUDE_1, LATITUDE_1);
		ZeratulUtils.Point point2 = new ZeratulUtils.Point(LONGITUDE_2, LATITUDE_2);
		
		double distanceInMeters = ZeratulUtils.getCircleDistance(point1, point2);
		assertTrue(distanceInMeters > 0);
		log.info("Distance between {} and {} is {} meters", point1, point2, distanceInMeters);
	}

}
