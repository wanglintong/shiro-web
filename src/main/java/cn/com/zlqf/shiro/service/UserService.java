package cn.com.zlqf.shiro.service;

import java.util.List;

import cn.com.zlqf.shiro.entity.User;

public interface UserService {
	User findUserByUsername(String username);
	void addUser(User user);
	List<User> findAll();
}
