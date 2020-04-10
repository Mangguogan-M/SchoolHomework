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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("teacher_id"));
//		System.out.println("id" + id);
		TeacherDao dao = new TeacherDao();
		Teacher tea = dao.queryTeacherById(id);
//		System.out.println("nihao" + tea.getTeacher_gendar());
		
		
		DeptDao deptDao = new DeptDao();
		List<Dept> list = deptDao.getDept();
		req.setAttribute("dept", list);
		req.setAttribute("teacher", tea);	
//		System.out.println(tea.getTeacher_gendar());
		req.getRequestDispatcher("jsp/update.jsp").forward(req, resp);
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
		int age = Integer.parseInt(req.getParameter("teacher_age")==""?"0":req.getParameter("teacher_age"));
		int deptno = Integer.parseInt(req.getParameter("deptno"));
		
		teacher.setTeacher_id(id);
		teacher.setTeacher_name(name);
		teacher.setTeacher_gendar(gendar);
		teacher.setTeacher_degree(degree);
		teacher.setTeacher_jobtitle(jobtitle);
		teacher.setTeacher_age(age);
		teacher.setDeptno(deptno);
		
//		System.out.println(teacher);
		
		TeacherDao dao = new TeacherDao();
		
		
		dao.updateTeacher(teacher);
		req.getRequestDispatcher("/view").forward(req, resp);
	}
	

}
