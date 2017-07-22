package com.dep.sspanel.service.impl;

import java.util.Collections;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dep.sspanel.dao.UserDao;
import com.dep.sspanel.entity.User;
import com.dep.sspanel.service.UserService;
import com.dep.sspanel.shiro.SecurityUtil;
import com.dep.sspanel.util.vo.Page;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService{
	private UserDao userDao;
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		this.genericDao=userDao;
	}

	@Override
	public User findUserByName(String name) {
		return userDao.findUserByName(name);
	}
	
	@Override
	public User findUserByNameOrEmail(String condition) {
		return userDao.findUserByNameOrEmail(condition);
	}

	@Override
	public Set<String> findRolesByNameOrEmail(String condition) {
		User user=findUserByNameOrEmail(condition);
		if(user == null) {
            return Collections.emptySet();
        }
		return user.getRoleNameSet();
	}

	@Override
	public Set<String> findPermissionsByNameOrEmail(String condition) {
		User user=findUserByNameOrEmail(condition);
		if(user == null) {
            return Collections.emptySet();
        }
		return user.getRolePermissionSet();
	}

	@Override
	public boolean changePassword(String username, String oldpassword, String password) {
		User user=findUserByName(username);
		if(!user.getPass().equals(SecurityUtil.encrypt(user.getUsername(), oldpassword))){
			return false;
		}
		user.setPass(SecurityUtil.encrypt(user.getUsername(), password));
		return true;
	}

	@Override
	public Page<User> findByPage(Page<User> page,User condition) {
		return userDao.findByPage(page,condition);
	}

	@Override
	public Integer checkExpires() {
		return userDao.updateAllOutDate();
	}

}
