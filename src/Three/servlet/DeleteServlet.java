package Three.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Three.bean.Teacher;
import Three.dao.TeacherDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("teacher_id"));
		Teacher teacher = new Teacher();
		teacher.setTeacher_id(id);
		TeacherDao dao = new TeacherDao();
		dao.deleteTeacher(teacher);
		System.out.println(teacher);
		req.getRequestDispatcher("/view").forward(req, resp);
	}
}
