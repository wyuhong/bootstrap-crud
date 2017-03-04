package com.biz.impl;

import com.biz.IUserBiz;
import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.UserInfo;

public class UserBizImpl implements IUserBiz {
	
	private IUserDao udao = new UserDaoImpl();

	@Override
	public boolean login(UserInfo ui) {
		boolean bl = false;
		try {
			bl = udao.showUserBoolByUser(ui);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return bl;
	}

}
