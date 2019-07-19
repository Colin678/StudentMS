package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/***
 * 工具类  得到数据库连接以及关闭连接
 * @author 昭兵bbb
 *
 */

public class DBUtil {
	public Connection connection;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public Connection getConnection () {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/oyzb";
		String user="oyzb";
		String password="qq1020084984";
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	//查询用preparestatement防止sql注入返回值为结果集
	public ResultSet querySql(String sql,Object[] objarr) {
		try {
			connection = getConnection();
			ps=connection.prepareStatement(sql);
			if(objarr!=null&&objarr.length!=0) {
				for(int i=0;i<objarr.length;i++) {
					ps.setObject(i+1,objarr[i]);
				}
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs; 
	}
	//返回int
	public int querySqlint(String sql,Object[] objarr) {
		int i=0;
		try {
			connection = getConnection();
			ps=connection.prepareStatement(sql);
			System.out.println(ps);
			if(objarr!=null&&objarr.length!=0) {
				for(int n=0;n<objarr.length;n++) {
					ps.setObject(n+1,objarr[n]);
					
				}
			}
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i; 
	}
	
	//关闭所有连接
	public void clossAll(Connection conn,Statement stmt,ResultSet rs) {
			try {
				if(null!=rs) {
					rs.close();
				}
				if(null!=stmt) {
					stmt.close();
				}
				if(null!=conn) {
					conn.close();
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
}
