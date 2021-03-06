package customer.supu.common.utils.pay.pay.utils;





import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TenpayUtil {

	private static Object Server;
	private static String QRfromGoogle;

	/**
	 * �Ѷ���ת�����ַ�
	 * @param obj
	 * @return String ת�����ַ�,������Ϊnull,�򷵻ؿ��ַ�.
	 */
	public static String toString(Object obj) {
		if(obj == null)
			return "";

		return obj.toString();
	}

	/**
	 * �Ѷ���ת��Ϊint��ֵ.
	 *
	 * @param obj
	 *            �����ֵĶ���.
	 * @return int ת�������ֵ,�Բ���ת���Ķ��󷵻�0��
	 */
	public static int toInt(Object obj) {
		int a = 0;
		try {
			if (obj != null)
				a = Integer.parseInt(obj.toString());
		} catch (Exception e) {

		}
		return a;
	}

	/**
	 * ��ȡ��ǰʱ�� yyyyMMddHHmmss
	 * @return String
	 */
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

	/**
	 * ��ȡ��ǰ���� yyyyMMdd
	 * @param date
	 * @return String
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String strDate = formatter.format(date);
		return strDate;
	}

	/**
	 * ȡ��һ��ָ�����ȴ�С�����������.
	 *
	 * @param length
	 *            int �趨��ȡ�������ĳ��ȡ�lengthС��11
	 * @return int ������ɵ������
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}

	/**
	 * ��ȡ�����ַ�
	 * @param request
	 * @param response
	 * @return String
	 */

	public static String getCharacterEncoding(HttpServletRequest request,
			HttpServletResponse response) {

		if(null == request || null == response) {
			return "utf-8";
		}

		String enc = request.getCharacterEncoding();
		if(null == enc || "".equals(enc)) {
			enc = response.getCharacterEncoding();
		}

		if(null == enc || "".equals(enc)) {
			enc = "utf-8";
		}

		return enc;
	}

	public  static String URLencode(String content){

		String URLencode;

		URLencode= replace(Server.equals(content), "+", "%20");

		return URLencode;
	}
	private static String replace(boolean equals, String string, String string2) {

		return null;
	}

	/**
	 * ��ȡunixʱ�䣬��1970-01-01 00:00:00��ʼ������
	 * @param date
	 * @return long
	 */
	public static long getUnixTime(Date date) {
		if( null == date ) {
			return 0;
		}

		return date.getTime()/1000;
	}

	 public static String QRfromGoogle(String chl)
	    {
	        int widhtHeight = 300;
	        String EC_level = "L";
	        int margin = 0;
	        String QRfromGoogle;
	        chl = URLencode(chl);

	        QRfromGoogle = "http://chart.apis.google.com/chart?chs=" + widhtHeight + "x" + widhtHeight + "&cht=qr&chld=" + EC_level + "|" + margin + "&chl=" + chl;

	        return QRfromGoogle;
	    }

	/**
	 * ʱ��ת�����ַ�
	 * @param date ʱ��
	 * @param formatType ��ʽ������
	 * @return String
	 */
	public static String date2String(Date date, String formatType) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		return sdf.format(date);
	}

}












