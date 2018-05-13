package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.biz.impl.BookBizImpl;
import cn.edu.nyist.bookmanv1.util.MyBeanUtils;
import cn.edu.nyist.bookmanv1.vo.BookVo;

@WebServlet("/bookAdd")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookAddServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 0 鐟欙絽鍠呮稉濠佺炊
		Part part = request.getPart("photo");
		String fileName = part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
		// 鐟欙絽鍠匢E娑撳鏁婄拠顖炴６妫帮拷
		fileName = fileName.lastIndexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\") + 1);

		// 鐎涙ê婀猦ibernate.cfg.xml鏉╂瑧顫掗エ鍌欐閸氾拷
		String ext = fileName.substring(fileName.lastIndexOf('.') + 1);
		String newFileName = UUID.randomUUID().toString() + "." + ext;
		part.write(request.getServletContext().getRealPath("upload/" + newFileName));
		// 1閼惧嘲褰囬崣鍌涙殶
		/*String name = request.getParameter("name");
		String descri = request.getParameter("descri");
		String strPrice = request.getParameter("price");
		double price = Double.parseDouble(strPrice);
		String author = request.getParameter("author");
		String strTid = request.getParameter("tid");
		int tid = Integer.parseInt(strTid);
		String strPubDate = request.getParameter("pubDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date pubDate = null;
		try {
			pubDate = sdf.parse(strPubDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		BookVo bookVo=new BookVo();
		//
		/*try {
			BeanUtils.populate(bookVo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		MyBeanUtils.populate(bookVo, request.getParameterMap(), "yyyy-MM-dd");
		bookVo.setPhoto(newFileName);
		// 2 鐠嬪啰鏁ゆ稉姘鐏炲倷绻氱�涳拷
		BookBiz bookBiz = new BookBizImpl();
		//int ret = bookBiz.saveBook(name, descri, price, author, tid, newFileName, pubDate);
		int ret = bookBiz.saveBook(bookVo);
		// 3 缂佹瑧鏁ら幋宄板冀妫ｏ拷
		response.setContentType("text/html;charset=utf-8");
		if (ret > 0) {
			response.getWriter().write("濞ｈ濮為幋鎰");
		} else {
			request.setAttribute("msg", "濞ｈ濮炴径杈Е");
			request.getRequestDispatcher("bookAdd.jsp").forward(request, response);
		}

	}

}
