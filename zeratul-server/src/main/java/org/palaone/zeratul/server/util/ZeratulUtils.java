/**
 * 
 */
package org.palaone.zeratul.server.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.palaone.zeratul.server.domain.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author palaone
 *
 */
public final class ZeratulUtils {
	private static final Logger log = LoggerFactory
			.getLogger(ZeratulUtils.class);
	private static final double NO_RADIUS = 0;
//	private static final double EARTH_RADIUS_IN_METERS = 6371000;

	/**
	 * @author palaone
	 *
	 */
	public static class Point {
		private double longitude;
		private double latitude;

		public Point(double longitude, double latitude) {
			this.longitude = longitude;
			this.latitude = latitude;
		}

		/**
		 * @return the longitude
		 */
		public double getLongitude() {
			return longitude;
		}

		/**
		 * @return the latitude
		 */
		public double getLatitude() {
			return latitude;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Point [longitude=" + longitude + ", latitude=" + latitude
					+ "]";
		}
	}
	
	public static boolean withinRadius(Position pos1, Position pos2, double radius) {
		if (NO_RADIUS == radius) {
			return true;
		}
		ZeratulUtils.Point p1 = new ZeratulUtils.Point(pos1.getLongitude(),
				pos1.getLatitude());
		ZeratulUtils.Point p2 = new ZeratulUtils.Point(pos2.getLongitude(),
				pos2.getLatitude());
		
		try {
			double distance = ZeratulUtils.getCircleDistance(p1, p2);
			log.info("P1: {} P2: {} and distance is {} meters and radius is {}",p1, p2, distance, radius);
			return distance <= radius;
		} catch (JSONException e) {
			log.error("Exception Occured", e);
			return false;
		}
	}

	public static double getCircleDistance(Point point1, Point point2)
			throws JSONException {
		return (double) getDistanceInMeters(point1, point2);
	}

	public static int getDistanceInMeters(Point p1, Point p2)
			throws JSONException {

		RestTemplate restTemplate = new RestTemplate();

		Map<String, String> vars = new HashMap<String, String>();
		vars.put("p1lat", Double.toString(p1.latitude));
		vars.put("p1long", Double.toString(p1.longitude));
		vars.put("p2lat", Double.toString(p2.latitude));
		vars.put("p2long", Double.toString(p1.longitude));

		String url = restTemplate
				.getForObject(
						"http://route.cit.api.here.com/routing/7.2/calculateroute.json?app_id=v1qhl1zQRnRPu13al30v&app_code=XHwMLFQxjagG9hr7hySRpQ&mode=fastest;car;&waypoint0=geo!{p1lat},{p1long}&waypoint1=geo!{p2lat},{p2long}&routeattributes=sh,bb,gr",
						String.class, vars);
		JSONObject object = new JSONObject(url);
		JSONObject response = object.getJSONObject("response");
		JSONArray route = response.getJSONArray("route");
		JSONObject summary = route.getJSONObject(0).getJSONObject("summary");
		return Integer.parseInt(summary.get("distance").toString());
	}
}