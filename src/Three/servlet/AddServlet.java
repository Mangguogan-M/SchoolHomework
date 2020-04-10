package Three.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Three.bean.Dept;
import Three.bean.Teacher;
import Three.dao.DeptDao;
import Three.dao.TeacherDao;


@WebServlet("/add")
public class AddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherDao Tdao = new TeacherDao();
		int id = Tdao.getMaxId();
		req.setAttribute("id", id);
		DeptDao dao = new DeptDao();
		List<Dept> list = dao.getDept();
		req.setAttribute("dept", list);
		req.getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		Teacher teacher = new Teacher();
		
		int id = Integer.parseInt(req.getParameter("teacher_id"));
		String name = req.getParameter("teacher_name");
		String gendar = req.getParameter("teacher_gendar");
		String degree = req.getParameter("teacher_degree");
		String jobtitle = req.getParameter("teacher_jobtitle");
		System.out.println(jobtitle);
		int age = Integer.parseInt(req.getParameter("teacher_age")==""?"0":req.getParameter("teacher_age"));
		int deptno = Integer.parseInt(req.getParameter("deptno"));
		
		teacher.setTeacher_id(id);
		teacher.setTeacher_name(name);
		teacher.setTeacher_gendar(gendar);
		teacher.setTeacher_degree(degree);
		teacher.setTeacher_jobtitle(jobtitle);
		teacher.setTeacher_age(Integer.parseInt(req.getParameter("teacher_age")==""?"0":req.getParameter("teacher_age")));
		teacher.setDeptno(deptno);
		
		TeacherDao dao = new TeacherDao();
		dao.addTeacher(teacher);
		req.getRequestDispatcher("/view").forward(req, resp);
	}
	
}
