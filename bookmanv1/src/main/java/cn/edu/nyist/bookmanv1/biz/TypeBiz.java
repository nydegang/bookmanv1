package cn.edu.nyist.bookmanv1.biz;

import java.util.List;

import cn.edu.nyist.bookmanv1.vo.TypeVo;

/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *         2018年5月13日上午10:52:12<br>
 *         说明:书籍类型业务层
 */
public interface TypeBiz {
/**
 * 
 * @return 返回所有类型
 */
	List<TypeVo> findAllTypes();

}
