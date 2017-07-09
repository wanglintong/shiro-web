package cn.com.zlqf.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import cn.com.zlqf.shiro.entity.Permission;
import cn.com.zlqf.shiro.entity.Role;
import cn.com.zlqf.shiro.entity.User;
import cn.com.zlqf.shiro.service.UserService;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		User user = (User) pc.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<Role> roles = user.getRoles();
		Set<String> permissions = new HashSet<>();
		Set<String> stringRoles = new HashSet<>();
		
		for (Role role : roles) {
			stringRoles.add(role.getName());
			Set<Permission> permissionSet = role.getPermissions();
			for (Permission p : permissionSet) {
				permissions.add(p.getName());
			}
		}
		authorizationInfo.setRoles(stringRoles);
		authorizationInfo.setStringPermissions(permissions);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		//user是持久化对象
		User user = userService.findUserByUsername(username);
		if (user == null) {
			throw new UnknownAccountException();
		}
		return new SimpleAuthenticationInfo(user, user.getPassword(), new SimpleByteSource(user.getId()),
				"userRealm");
	}

}
