package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接管理器
 * @author dhc
 * 开发思路：
 * 1、计划使用ConnectionManager.getInstance().getConnection()
 *
 */
public class ConnectionManager {
	
	private static ConnectionManager cm = null;
	private static Properties pro = null;
	
	private ConnectionManager() {
		try {
//			File file = new File("config/db.properties");
//			InputStream is = new BufferedInputStream(new FileInputStream(file));
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("db.properties");
			pro = new Properties();
			pro.load(is);
			//注册驱动
			Class.forName(pro.getProperty("driver"));
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	public static ConnectionManager getInstance(){
		if(cm == null){
			//双重锁
			synchronized (ConnectionManager.class) {
				if(cm == null){
					cm = new ConnectionManager();
				}
			}
		}
		return cm;
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return conn;
	}
	/**
	 * 释放所有资源（结果集对象，语句对象，连接对象）
	 * @param rs
	 * @param sta
	 * @param conn
	 */
	public void free(ResultSet rs,Statement sta,Connection conn){
		try {
			if(rs != null){
				rs.close();
			}
			if(sta != null){
				sta.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

}
