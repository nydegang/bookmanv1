package cn.edu.nyist.bookmanv1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import cn.edu.nyist.bookmanv1.dao.BookDao;
import cn.edu.nyist.bookmanv1.util.DsUtil;
/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月12日下午7:58:38<br>
 * 说明:书籍业务层实现
 */
public class BookDaoJdbcImpl implements BookDao {

	@Override
	public int save(String name, String descri, double price, String author, int tid, String newFileName,Date pubDate) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DsUtil.getConn();
			String sql="insert into t_book(tid,name,descri,photo,price,author,pubDate) values(?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, tid);
			stmt.setString(2, name);
			stmt.setString(3, descri);
			stmt.setString(4, newFileName);
			stmt.setDouble(5, price);
			stmt.setString(6, author);
			//java.util.Date-->java.sql.Date
			stmt.setDate(7, new java.sql.Date(pubDate.getTime()));
			int ret=stmt.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@");
			DsUtil.free(stmt, conn);
		}
		
		return 0;
	}

}
