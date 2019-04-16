package customer.supu.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算两点之间的距离
 * @author Administrator
 *
 */
public class MapOfDistanceUtil {
	  private static final Double PI = Math.PI;

	    private static final Double PK = 180 / PI;

	    /**
	     * @Description: 第一种方法
	     * @param lat_a
	     * @param lng_a
	     * @param lat_b
	     * @param lng_b
	     * @param @return
	     * @return double
	     * @author 钟志铖
	     * @date 2014-9-7 上午10:11:35
	     */
	    public static double getDistanceFromTwoPoints(double lat_a, double lng_a, double lat_b, double lng_b) {
	        double t1 = Math.cos(lat_a / PK) * Math.cos(lng_a / PK) * Math.cos(lat_b / PK) * Math.cos(lng_b / PK);
	        double t2 = Math.cos(lat_a / PK) * Math.sin(lng_a / PK) * Math.cos(lat_b / PK) * Math.sin(lng_b / PK);
	        double t3 = Math.sin(lat_a / PK) * Math.sin(lat_b / PK);

	        double tt = Math.acos(t1 + t2 + t3);

	        System.out.println("两点间的距离：" + 6366000 * tt + " 米");
	        return 6366000 * tt;
	    }


	    /********************************************************************************************************/
	    // 地球半径
	    private static final double EARTH_RADIUS = 6370996.81;

	    // 弧度
	    private static double radian(double d) {
	        return d * Math.PI / 180.0;
	    }



	    /**
	     * @Description: 第二种方法
	     * @param lat1
	     * @param lng1
	     * @param lat2
	     * @param lng2
	     * @return void
	     * @author 钟志铖
	     * @date 2014-9-7 上午10:11:55
	     */
	    public static double distanceOfTwoPoints(double lat1, double lng1, double lat2, double lng2) {
	        double radLat1 = radian(lat1);
	        double radLat2 = radian(lat2);
	        double a = radLat1 - radLat2;
	        double b = radian(lng1) - radian(lng2);
	        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
	                + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
	        s = s * EARTH_RADIUS;
	        s = Math.round(s * 10000) / 10000;
	       // double ss = s * 1.0936132983377;
	        return s;
	       // System.out.println("两点间的距离是：" + s + "米" + "," + (int) ss + "码");
	    }



		 //获取当前位置的经纬度
		 public static Map<String, BigDecimal> getLatAndLngByAddress(String addr){
		       // String address = "";
		        String lat = "";
		        String lng = "";
		        try {
		        	addr = java.net.URLEncoder.encode(addr,"UTF-8");
		        } catch (UnsupportedEncodingException e1) {
		            e1.printStackTrace();
		        }
		        String url = String.format("http://api.map.baidu.com/geocoder/v2/?"
		        +"ak=WTo581xf7bD7fFKgh5eDVZysUeYv4iYr&output=json&address=%s",addr);
		        URL myURL = null;
		        URLConnection httpsConn = null;
		        //进行转码
		        try {
		            myURL = new URL(url);
		        } catch (MalformedURLException e) {

		        }
		        try {
		            httpsConn = (URLConnection) myURL.openConnection();
		            if (httpsConn != null) {
		                InputStreamReader insr = new InputStreamReader(
		                        httpsConn.getInputStream(), "UTF-8");
		                BufferedReader br = new BufferedReader(insr);
		                String data = null;
		                if ((data = br.readLine()) != null) {
		                	System.out.println("data:"+data);
		                    lat = data.substring(data.indexOf("\"lat\":")
		                    + ("\"lat\":").length(), data.indexOf("},\"precise\""));
		                    lng = data.substring(data.indexOf("\"lng\":")
		                    + ("\"lng\":").length(), data.indexOf(",\"lat\""));
		                }
		                insr.close();
		            }
		        } catch (IOException e) {

		        }
		        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
		        map.put("lat", new BigDecimal(lat));
		        map.put("lng", new BigDecimal(lng));
		        return map;
		}


		 /**
		  * 获取两点之间的距离
		  * @param addr1
		  * @param addr2
		  * @return
		  */
		 public static double  pointOfDistance(String addr1,String addr2){
			Map<String, BigDecimal> m1=getLatAndLngByAddress(addr1);
		    Map<String, BigDecimal> m2=getLatAndLngByAddress(addr2);
			return distanceOfTwoPoints(Double.valueOf(m1.get("lat").toString()),
					 Double.valueOf(m1.get("lng").toString()),
							 Double.valueOf(m2.get("lat").toString()),
					 Double.valueOf( m2.get("lng").toString()));
		 }



		 /**
		     * 坐标转换，腾讯地图转换成百度地图坐标
		     * @param lat 腾讯纬度
		     * @param lon 腾讯经度
		     * @return 返回结果：经度,纬度
		     */
		   public static double[] map_tx2bd(double lat, double lon){

		        return wgs2bd(lat,lon);
		   }

	public final static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

	public static double[] wgs2bd(double lat, double lon) {
		double[] wgs2gcj = wgs2gcj(lat, lon);
		double[] gcj2bd = gcj2bd(wgs2gcj[0], wgs2gcj[1]);
		return gcj2bd;
	}

	static double pi = 3.14159265358979324;
	static double a = 6378245.0;
	static double ee = 0.00669342162296594323;
	public static double[] gcj2bd(double lat, double lon) {
		double x = lon, y = lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		double bd_lon = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;
		return new double[] { bd_lat, bd_lon };
	}

	public static double[] bd2gcj(double lat, double lon) {
		double x = lon - 0.0065, y = lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		double gg_lon = z * Math.cos(theta);
		double gg_lat = z * Math.sin(theta);
		return new double[] { gg_lat, gg_lon };
	}

	public static double[] wgs2gcj(double lat, double lon) {
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		double[] loc = { mgLat, mgLon };
		return loc;
	}

	private static double transformLat(double lat, double lon) {
		double ret = -100.0 + 2.0 * lat + 3.0 * lon + 0.2 * lon * lon + 0.1 * lat * lon + 0.2 * Math.sqrt(Math.abs(lat));
		ret += (20.0 * Math.sin(6.0 * lat * pi) + 20.0 * Math.sin(2.0 * lat * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(lon * pi) + 40.0 * Math.sin(lon / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(lon / 12.0 * pi) + 320 * Math.sin(lon * pi  / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	private static double transformLon(double lat, double lon) {
		double ret = 300.0 + lat + 2.0 * lon + 0.1 * lat * lat + 0.1 * lat * lon + 0.1 * Math.sqrt(Math.abs(lat));
		ret += (20.0 * Math.sin(6.0 * lat * pi) + 20.0 * Math.sin(2.0 * lat * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(lat * pi) + 40.0 * Math.sin(lat / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(lat / 12.0 * pi) + 300.0 * Math.sin(lat / 30.0 * pi)) * 2.0 / 3.0;
		return ret;
	}


	public static void main(String[] args) {
			System.out.println( pointOfDistance("江苏省南京市六合区龙池站","江苏省南京市六合高级中学")+"米");

		}

/*		   public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
			            // 维度
			            double lat1 = (Math.PI / 180) * latitude1;
			           double lat2 = (Math.PI / 180) * latitude2;

			            // 经度
			            double lon1 = (Math.PI / 180) * longitude1;
			           double lon2 = (Math.PI / 180) * longitude2;

			           // 地球半径
			           double R = 6371;

			            // 两点间距离 km，如果想要米的话，结果*1000就可以了
			          double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;

			           return d * 1000;
		}*/
}
