/**
 * 
 */
package org.palaone.zeratul.server.util;

import org.palaone.zeratul.server.util.ZeratulUtils.Point;

/**
 * @author palaone
 *
 */
public final class ZeratulUtils {
	private static final double EARTH_RADIUS_IN_METERS = 6371000;
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

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Point [longitude=" + longitude + ", latitude=" + latitude
					+ "]";
		}
	}

	public static double getCircleDistance(Point point1, Point point2) {
		double long1 = Math.toRadians(point1.getLongitude());
		double lat1 = Math.toRadians(point1.getLatitude());
		
		double long2 = Math.toRadians(point2.getLongitude());
		double lat2 = Math.toRadians(point1.getLatitude());
		
		double longDelta = long2 - long1;
		double a = Math.pow(Math.cos(lat2) * Math.sin(longDelta), 2)
				+ Math.pow(Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1)
						* Math.cos(lat2) * Math.cos(longDelta), 2);
		double b = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(longDelta);
		double angle = Math.atan2(Math.sqrt(a), b);
		return angle * EARTH_RADIUS_IN_METERS;
	}

}
