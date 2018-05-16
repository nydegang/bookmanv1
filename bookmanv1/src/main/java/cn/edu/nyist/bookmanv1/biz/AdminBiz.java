package cn.edu.nyist.bookmanv1.biz;
/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月12日下午7:54:26<br>
 * 说明:管理员业务层
 */
public interface AdminBiz {
        //验证用户和密码是否合法
	boolean findAdminByNameAndPwd(String name, String pwd);

}
