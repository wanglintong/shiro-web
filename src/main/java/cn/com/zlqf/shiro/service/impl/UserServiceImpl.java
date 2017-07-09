package cn.com.zlqf.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.zlqf.shiro.dao.UserDao;
import cn.com.zlqf.shiro.entity.User;
import cn.com.zlqf.shiro.service.UserService;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly=false)
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
}
