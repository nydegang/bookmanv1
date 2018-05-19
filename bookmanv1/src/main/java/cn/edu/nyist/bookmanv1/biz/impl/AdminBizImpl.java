package cn.edu.nyist.bookmanv1.biz.impl;

import cn.edu.nyist.bookmanv1.biz.AdminBiz;
import cn.edu.nyist.bookmanv1.dao.AdminDao;
import cn.edu.nyist.bookmanv1.dao.impl.AdminDaoJdbcImpl;
/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月13日下午5:10:08<br>
 * 说明:管理员业务层实现
 */
public class AdminBizImpl implements AdminBiz {
	@Override
	public boolean findAdminByNameAndPwd(String name, String pwd) {
		AdminDao adminDao=new AdminDaoJdbcImpl();
		return adminDao.get(name,pwd);
	}

}
