package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DatabaseUtil;
public class BaseDao {
	private Connection conn;

	/**
	 * 增删改
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	protected int executeUpdate(String sql, Object... params) throws SQLException {
		int result = 0;
		conn=DatabaseUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatabaseUtil.closeAll(null, pstmt, null);
		}
		return result;
	}

	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	protected ResultSet executeQuery(String sql, Object... params) throws SQLException {
		PreparedStatement pstmt = null;
		conn=DatabaseUtil.getConnection();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return rs;
	}
}
