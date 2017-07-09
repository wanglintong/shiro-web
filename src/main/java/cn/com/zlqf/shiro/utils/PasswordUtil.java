package cn.com.zlqf.shiro.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class PasswordUtil {
	
	public static String encryptPwd(String password,String salt) {
		return new Md5Hash(password,salt,2).toString();
	}
}
