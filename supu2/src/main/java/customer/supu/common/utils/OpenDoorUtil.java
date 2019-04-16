package customer.supu.common.utils;

/**
 * 开门参数
 * @author Administrator
 *
 */
public class OpenDoorUtil {

	private static String appId="wmj_JYmcF1676WT";

	private static String appSecret="WMMKNWaaWI9rwHZiiMl8gjkQHjCEjJb4";

	//序列号
	private static String lock="WMJ16882104";

	//AES加密密钥
	//private static String AES="LLBWorjVG125o2qmb1i44RP9bSVhLHx3";




	public static String getLock() {
		return lock;
	}

	public static void setLock(String lock) {
		OpenDoorUtil.lock = lock;
	}

/*	public static String getAES() {
		return AES;
	}

	public static void setAES(String aES) {
		AES = aES;
	}*/

	public static String getAppId() {
		return appId;
	}

	public static void setAppId(String appId) {
		OpenDoorUtil.appId = appId;
	}

	public static String getAppSecret() {
		return appSecret;
	}

	public static void setAppSecret(String appSecret) {
		OpenDoorUtil.appSecret = appSecret;
	}

}
