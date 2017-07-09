package cn.com.zlqf.shiro.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.zlqf.shiro.dao.PermissionDao;
import cn.com.zlqf.shiro.entity.Permission;
import cn.com.zlqf.shiro.service.PermissionService;

@Service
@Transactional(readOnly=false)
public class PermissionServiceImpl implements PermissionService{
	@Autowired
	private PermissionDao permissionDao;
	@Override
	public void addPermission(Permission permission) {
		permissionDao.save(permission);
	}

}
