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
	//�����������
		request.setCharacterEncoding("utf-8");
		//���÷�����������
		response.setContentType("text/html;charset = utf-8");
		//�õ��û����ݹ�����anme1
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		//�������ݿ⣬��ѯ�����Ƿ����
		TeacherDao dao = new TeacherDao();
		List<Integer> list = dao.queryId();
		
		if (list.contains(id)) {
			response.getWriter().println("true");
		}else {//�û�����˵������ʹ��
			response.getWriter().println("false");
		}
	}
}
