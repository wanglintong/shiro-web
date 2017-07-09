package cn.com.zlqf.shiro.controller;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.zlqf.shiro.entity.Permission;
import cn.com.zlqf.shiro.entity.Role;
import cn.com.zlqf.shiro.entity.User;
import cn.com.zlqf.shiro.service.PermissionService;
import cn.com.zlqf.shiro.service.RoleService;
import cn.com.zlqf.shiro.service.UserService;
import cn.com.zlqf.shiro.utils.IdUtil;
import cn.com.zlqf.shiro.utils.PasswordUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/testAdd")
	public @ResponseBody User testAddUser() {
		User user = new User();
		user.setId(IdUtil.getRandomId());
		user.setUsername("wlt");
		user.setPassword(PasswordUtil.encryptPwd("123456",user.getId()));
		user.setEmail("wlt@163.com");
		user.setPhoneNumber("18454451504");
		user.setRegistTime(new Date());
		
		Permission p1 = new Permission();
		p1.setId("001");
		p1.setName("user:create");
		permissionService.addPermission(p1);
		
		Permission p2 = new Permission();
		p2.setId("002");
		p2.setName("user:delete");
		permissionService.addPermission(p2);
		
		Set<Permission> permissions1 = new HashSet<>();
		permissions1.add(p1);
		permissions1.add(p2);
		
		Set<Permission> permissions2 = new HashSet<>();
		permissions2.add(p1);
		
		Role r1 = new Role();
		r1.setId("001");
		r1.setName("admin");
		r1.setPermissions(permissions1);
		roleService.addRole(r1);
		
		Role r2 = new Role();
		r2.setId("002");
		r2.setName("user");
		r2.setPermissions(permissions2);
		roleService.addRole(r2);
		
		Set<Role> roles = new HashSet<>();
		roles.add(r1);
		roles.add(r2);
		
		user.setRoles(roles);
		
		userService.addUser(user);
		return user;
	}
	
	@RequiresPermissions({"user:delete"})
	@RequestMapping("/testHasRoles")
	public @ResponseBody String testHasRoles() {
		Subject subject = SecurityUtils.getSubject();
		boolean hasRole = subject.hasRole("admin");
		System.out.println(hasRole);
		return "testHasRoles";
	}
	
	@RequestMapping("/findUserList")
	public @ResponseBody List<User> findUserList() {
		return userService.findAll();
	}
	
	@RequestMapping("/test2")
	public @ResponseBody String test2() {
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		PrincipalCollection principals = subject.getPrincipals();
		System.out.println(principal);
		System.out.println(principals);
		
		SecurityManager securityManager = SecurityUtils.getSecurityManager();
		System.out.println(securityManager.getClass().getName());
		return "ok";
	}
}
