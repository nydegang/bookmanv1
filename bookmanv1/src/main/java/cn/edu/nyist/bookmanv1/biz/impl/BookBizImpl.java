package cn.edu.nyist.bookmanv1.biz.impl;

import java.util.List;

import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.dao.BookDao;
import cn.edu.nyist.bookmanv1.dao.TypeDao;
import cn.edu.nyist.bookmanv1.dao.impl.BookDaoJdbcImpl;
import cn.edu.nyist.bookmanv1.dao.impl.TypeDaoJdbcImpl;
import cn.edu.nyist.bookmanv1.vo.BookVo;
import cn.edu.nyist.bookmanv1.vo.TypeVo;
/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月13日下午5:10:50<br>
 * 说明:书籍业务层实现类
 */
public class BookBizImpl implements BookBiz {

	@Override
	public int saveBook(BookVo bookVo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(bookVo);
	}

	@Override
	public List<BookVo> findAllBooks(int pageNo,String name,int tid) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return  bookDao.findAll(pageNo,name,tid);
	}

	@Override
	public int findTotal(String name,int tid) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.getTotal(name,tid);
	}

	@Override
	public List<TypeVo> findAllTypes() {
      TypeDao typeDao=new TypeDaoJdbcImpl();
		return  typeDao.findAll();
	}

	@Override
	public boolean delById(int id) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.del(id);
	}

	@Override
	public BookVo findBookById(int id) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.get(id);
	}

	@Override
	public int editBook(BookVo bookVo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.edit(bookVo);
	}

}
