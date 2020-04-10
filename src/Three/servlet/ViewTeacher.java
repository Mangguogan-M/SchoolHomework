package Three.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Three.bean.Teacher;
import Three.dao.TeacherDao;

@WebServlet("/view")
public class ViewTeacher extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		TeacherDao dao = new TeacherDao();
		List<Teacher> list = dao.queryTeacher();
		req.setAttribute("teacher", list);
		req.getRequestDispatcher("jsp/view.jsp").forward(req, resp);
	}
}
