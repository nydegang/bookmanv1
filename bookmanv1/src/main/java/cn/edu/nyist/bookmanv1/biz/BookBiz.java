package cn.edu.nyist.bookmanv1.biz;

import cn.edu.nyist.bookmanv1.vo.BookVo;
/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月12日下午7:57:52<br>
 * 说明:书籍业务层
 */
public interface BookBiz {

	//int saveBook(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);
	int saveBook(BookVo bookVo);

}
