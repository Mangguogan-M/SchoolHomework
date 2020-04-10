 package Three.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Three.dao.TeacherDao;



@WebServlet("/findId")
public class VerifyIdServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置返回数据类型
		response.setContentType("text/html;charset = utf-8");
		//得到用户传递过来的anme1
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		//访问数据库，查询数据是否存在
		TeacherDao dao = new TeacherDao();
		List<Integer> list = dao.queryId();
		
		if (list.contains(id)) {
			response.getWriter().println("true");
		}else {//用户存在说明不能使用
			response.getWriter().println("false");
		}
	}
}
