package cn.edu.nyist.bookmanv1.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmanv1.biz.TypeBiz;
import cn.edu.nyist.bookmanv1.biz.impl.TypeBizImpl;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月13日上午10:59:00<br>
 * 说明:获取所有类型
 */
@WebServlet("/findAllTypes")
public class FindAllTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FindAllTypesServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TypeBiz typeBiz=new TypeBizImpl();
		List<TypeVo> ls=typeBiz.findAllTypes();
		//返回JavaScript类型类型
		response.setContentType("text/javascript;charset=utf-8");
		String js="var types= [";
		for (int i=0;i<ls.size();i++) {
			js+="{id:"+ls.get(i).getId()+",name:'"+ls.get(i).getName()+"'}";
			if (i<ls.size()-1) {
				js+=",";
			}
		}
		js+="]";
		response.getWriter().write(js);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
