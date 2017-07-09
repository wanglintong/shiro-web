package cn.com.zlqf.shiro.utils;

import java.util.UUID;

public class IdUtil {
	public static String getRandomId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
