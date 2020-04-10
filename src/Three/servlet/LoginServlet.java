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


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(req.getParameter("teacher_id"));
		String name = req.getParameter("teacher_name");
		Teacher teacher = new Teacher();
		teacher.setTeacher_id(id);
		teacher.setTeacher_name(name);
		TeacherDao dao = new TeacherDao();
		if (dao.login(teacher)) {
			System.out.println("µÇÂ¼³É¹¦£¡£¡£¡£¡£¡");
		}else {
			System.out.println("µÇÂ¼Ê§°Ü£¡£¡£¡£¡£¡");
		}
		resp.sendRedirect("view");
	}

}
