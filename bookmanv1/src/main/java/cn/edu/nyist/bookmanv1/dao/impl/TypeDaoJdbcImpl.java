package cn.edu.nyist.bookmanv1.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nyist.bookmanv1.dao.TypeDao;
import cn.edu.nyist.bookmanv1.util.DsUtil;
import cn.edu.nyist.bookmanv1.vo.TypeVo;
/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月19日下午2:58:21<br>
 * 说明:TypeDao实现类
 */
public class TypeDaoJdbcImpl implements TypeDao {

	@Override
	public List<TypeVo> findAll() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DsUtil.getConn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from t_type");
			List<TypeVo> ls=new ArrayList<>();
			while (rs.next()) {//每行对应一个对象
				TypeVo typeVo=new TypeVo();
				typeVo.setId(rs.getInt("id"));
				typeVo.setName(rs.getString("name"));
				ls.add(typeVo);
			}
			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			DsUtil.free(rs, stmt, conn);
		}
		
		return null;
	}

}
