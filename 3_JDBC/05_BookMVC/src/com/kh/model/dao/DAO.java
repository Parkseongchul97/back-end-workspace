package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class DAO {
	
	public DAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection link() {

		try {
			return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public void closeAll(PreparedStatement ps, Connection con) throws SQLException {
			ps.close();
			con.close();
	}
	
	public void closeAll(PreparedStatement ps, Connection con, ResultSet rs) throws SQLException {
		
			closeAll(ps,con);
			rs.close();
		}

}
