package cn.com.zlqf.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	/**UnauthorizedException统一异常处理**/
	@ExceptionHandler({UnauthorizedException.class})
	public String unAuthorizedExceptionHandle(HttpServletRequest request,UnauthorizedException e) {
		System.out.println(e.getMessage());
		return "unauthorized";
	}
}
