package cn.edu.nyist.bookmanv1.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月12日下午8:00:43<br>
 * 说明:c3p0数据源工具类
 */
public class DsUtil {
	// ���web��Ҫһ���Ϳ�����
	private static ComboPooledDataSource cds = new ComboPooledDataSource();

	public static Connection getConn() throws SQLException {
		return cds.getConnection();
	}
	public static void free(Statement stmt, Connection conn) {
		// ���Ȳ�����һ��try,��Ϊstmtľ�йرգ�conn��ȻҪ�ر�
		/*
		 * try { stmt.close(); conn.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		if (stmt != null) {

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void free(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {

			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (stmt != null) {

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
