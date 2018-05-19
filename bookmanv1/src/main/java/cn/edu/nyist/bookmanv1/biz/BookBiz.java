package cn.edu.nyist.bookmanv1.biz;

import java.util.List;

import cn.edu.nyist.bookmanv1.vo.BookVo;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *         2018年5月12日下午7:57:52<br>
 *         说明:书籍业务层
 */
public interface BookBiz {
	/**
	 * 
	 * @param bookVo
	 *            要保存的book值对象
	 * @return 成功返回0；否则返回1
	 */
	int saveBook(BookVo bookVo);

	/**
	 * 
	 * @param pageNo
	 *            要查看的页面
	 * @param tid
	 * @param name
	 * @return 当前页的书籍列表
	 */
	List<BookVo> findAllBooks(int pageNo, String name, int tid);

	/**
	 * 
	 * @param tid
	 * @param name
	 * @return 返回总行数
	 */
	int findTotal(String name, int tid);

	List<TypeVo> findAllTypes();

	/**
	 * 
	 * @param id
	 * @return 根据id删除
	 */
	boolean delById(int id);

	/**
	 * 
	 * @param id
	 * @return 根据id找Book
	 */
	BookVo findBookById(int id);

	/**
	 * 
	 * @param bookVo
	 * @return 更新书籍
	 */
	int editBook(BookVo bookVo);

}
