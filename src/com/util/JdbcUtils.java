package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBC的工具类
 * @author dhc
 *
 */
public class JdbcUtils {
	
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	
	/**
	 * 将结果集转换成List集合
	 * @param rs
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List ResultSetToListMap(ResultSet rs){
		List list = new ArrayList();
		try {
			while(rs.next()){
				ResultSetMetaData md = rs.getMetaData();
				Map map = new HashMap();
				for(int i=1;i<=md.getColumnCount();i++){
					map.put(md.getColumnLabel(i), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}
	/**
	 * 获取预编译的语句对象（普通语句对象和预编译语句都能兼容）
	 * @param sql
	 * @return
	 */
	private static PreparedStatement getPreparedStatement(String sql){
		try {
			conn = ConnectionManager.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return pst;
	}
	/**
	 * 在不使用占位符的简单查询
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List query(String sql){
		try {
			getPreparedStatement(sql);
			rs = pst.executeQuery();
			return ResultSetToListMap(rs);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			ConnectionManager.getInstance().free(rs, pst, conn);
		}
	}
	
	
	/**
	 * 使用占位符的查询方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List query(String sql,Object... params){
		try {
			getPreparedStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);
			}
			rs = pst.executeQuery();
			return ResultSetToListMap(rs);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			ConnectionManager.getInstance().free(rs, pst, conn);
		}
	}
	
	/**
	 * 封装此方法专门用于查询单条记录的方法
	 * 用在聚合函数上（count sum avg max min）
	 * @param sql select count(*) from student;
	 * @return
	 */
	public static int querySingle(String sql){
		int i = 0;
		String str = "";
		try {
			//获取预编译的语句对象
			getPreparedStatement(sql);
			//查询获取结果集
			rs = pst.executeQuery();
			while(rs.next()){
				str = rs.getString(1);
			}
			i = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			ConnectionManager.getInstance().free(rs, pst, conn);
		}
		return i;
	}
	
	/**
	 * 不使用占位符的增删改方法
	 * @param sql
	 * @return
	 */
	public static int update(String sql){
		try {
			getPreparedStatement(sql);
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			ConnectionManager.getInstance().free(rs, pst, conn);
		}
	}
	
	/**
	 * 使用占位符的增删改方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int update(String sql,Object... params){
		try {
			getPreparedStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);
			}
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			ConnectionManager.getInstance().free(rs, pst, conn);
		}
	}

}
