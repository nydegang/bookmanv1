package cn.edu.nyist.bookmanv1.biz;

/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *         2018年5月12日下午7:54:26<br>
 *         说明:管理员业务层
 */
public interface AdminBiz {
	/**
	 * 
	 * @param name
	 * @param pwd
	 * @return 返回登陆是否成功
	 */
	boolean findAdminByNameAndPwd(String name, String pwd);

}
