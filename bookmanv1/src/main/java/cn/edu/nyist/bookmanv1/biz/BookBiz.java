package cn.edu.nyist.bookmanv1.biz;

import java.util.List;

import cn.edu.nyist.bookmanv1.vo.BookVo;
/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月12日下午7:57:52<br>
 * 说明:书籍业务层
 */
public interface BookBiz {

	int saveBook(BookVo bookVo);

	List<BookVo> findAllBooks(int pageNo);

	int findTotal();

}
