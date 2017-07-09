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

	/** formAuthenticationFilter��¼ʧ��ʱ ����ת������ **/
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		// ����shiro���ص��쳣��·���жϣ��׳�ָ���쳣��Ϣ
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				request.setAttribute("error", "�˻�������");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				request.setAttribute("error", "�û������������");
			} else {
				request.setAttribute("error", "δ֪��������ϵ����Ա");
			}
		}
		return "login";
	}
}
