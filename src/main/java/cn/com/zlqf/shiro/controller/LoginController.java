package cn.com.zlqf.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/** formAuthenticationFilter登录失败时 会跳转到这里 **/
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				request.setAttribute("error", "账户不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				request.setAttribute("error", "用户名或密码错误");
			} else {
				request.setAttribute("error", "未知错误，请联系管理员");
			}
		}
		return "login";
	}
}
