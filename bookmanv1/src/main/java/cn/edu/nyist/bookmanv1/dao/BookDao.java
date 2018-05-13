package cn.edu.nyist.bookmanv1.dao;

import java.util.List;

import cn.edu.nyist.bookmanv1.vo.BookVo;

public interface BookDao {

	//int save(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);
	int save(BookVo bookVo);

	List<BookVo> findAll(int pageNo);

	int getTotal();
}
