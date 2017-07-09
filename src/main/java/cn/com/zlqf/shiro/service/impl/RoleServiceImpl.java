package cn.com.zlqf.shiro.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.zlqf.shiro.dao.RoleDao;
import cn.com.zlqf.shiro.entity.Role;
import cn.com.zlqf.shiro.service.RoleService;

@Service
@Transactional(readOnly=false)
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;
	@Override
	public void addRole(Role role) {
		roleDao.save(role);
	}
}
