package cn.com.zlqf.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavController {
	
	@RequestMapping(value="/loginPage")
	public String login() {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {
			return "index";
		}
		return "login";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	@RequestMapping("/unauthorized")
	public String unauthorized() {
		return "unauthorized";
	}
	
}
