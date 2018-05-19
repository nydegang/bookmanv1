package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.biz.impl.BookBizImpl;

@WebServlet("/bookDel")
public class BookDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookDelServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1
		  String strId=request.getParameter("id");
		  int id=Integer.parseInt(strId);
		// 2
		  BookBiz bookBiz=new BookBizImpl();
		  boolean ret=bookBiz.delById(id);
		// 3
		 if (!ret) {
			request.setAttribute("msg", "删除失败");
		}
		 request.getRequestDispatcher("bookList").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
