package cn.com.zlqf.shiro.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static String now() {
		return simpleDateFormat.format(new Date());
	}
}
