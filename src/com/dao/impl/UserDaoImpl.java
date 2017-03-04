package com.dao.impl;

import java.util.List;

import com.dao.IUserDao;
import com.entity.UserInfo;
import com.util.JdbcUtils;

public class UserDaoImpl implements IUserDao {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean showUserBoolByUser(UserInfo ui) {
		boolean bl = false;
		try {
			List list = JdbcUtils.query("select * from userInfo where userName=? and userPwd=?", new Object[]{ui.getUserName(),ui.getUserPwd()});
			if(list.size()>0){
				bl = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return bl;
	}

}
