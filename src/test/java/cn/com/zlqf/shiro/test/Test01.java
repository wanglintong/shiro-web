package cn.com.zlqf.shiro.test;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

import cn.com.zlqf.shiro.utils.PasswordUtil;

public class Test01 {
	
	@Test
	public void testHashedCredentialsMatcher() {
		String password = "123456";
		String pwd1 = PasswordUtil.encryptPwd(password,"ae1fc8a6803e46fd9719c4006ae77b1a");
		System.out.println(pwd1);
		/*
		HashedCredentialsMatcher hm = new HashedCredentialsMatcher();
		hm.setHashAlgorithmName("MD5");
		hm.setHashIterations(2);
		boolean b = hm.doCredentialsMatch(new UsernamePasswordToken("admin", password), new SimpleAuthenticationInfo("admin",pwd1,new SimpleByteSource("12345"),"xx"));
		System.out.println(b);
		 */
	}
}
