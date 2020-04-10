package Three.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import Three.bean.Teacher;

import Three.utils.DbUtil;

public class TeacherDao {
	public boolean addTeacher(Teacher tea) {

		Connection conn = DbUtil.getConnection();
		String sql = "insert into teacher (teacher_id,teacher_name,teacher_gendar,teacher_degree,teacher_jobtitle,teacher_age,deptno) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, tea.getTeacher_id());
			ptmt.setString(2, tea.getTeacher_name());
			ptmt.setString(3, tea.getTeacher_gendar());
			ptmt.setString(4, tea.getTeacher_degree());
			ptmt.setString(5, tea.getTeacher_jobtitle());
			ptmt.setInt(6, tea.getTeacher_age());
			ptmt.setInt(7, tea.getDeptno());
			int count = ptmt.executeUpdate();
			ptmt.close();
			return count == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteTeacher(Teacher tea) {

		Connection conn = DbUtil.getConnection();
		String sql = "delete from dbo.teacher where teacher_id = ?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, tea.getTeacher_id());
			int count = ptmt.executeUpdate();
			ptmt.close();
			return count == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Teacher> queryTeacher() {
		Connection conn = DbUtil.getConnection();
		String sql1 = "select teacher_id,teacher_name,teacher_gendar,teacher_degree,teacher_jobtitle,teacher_age,dept_name from teacher,dept where teacher.deptno=dept.deptno";
		List<Teacher> list = new ArrayList<Teacher>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacher_id(rs.getInt("teacher_id"));
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setTeacher_gendar(rs.getString("teacher_gendar"));
				teacher.setTeacher_degree(rs.getString("teacher_degree"));
				teacher.setTeacher_jobtitle(rs.getString("teacher_jobtitle"));
				teacher.setTeacher_age(rs.getInt("teacher_age"));
				teacher.setDept(rs.getString("dept_name"));
				list.add(teacher);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean login(Teacher tea) {
		Connection conn = DbUtil.getConnection();
		String sql = "select COUNT(*) cnt from teacher where teacher_id=? and teacher_name=?";
		List<Teacher> list = new ArrayList<Teacher>();
		int count = 0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, tea.getTeacher_id());
			ptmt.setString(2, tea.getTeacher_name());
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("cnt");
			}
			rs.close();
			ptmt.close();
			return count == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Integer> queryId() {
		// 获取数据库连接
		Connection conn = DbUtil.getConnection();
		String sql = "select teacher_id from teacher";
		List<Integer> list = new ArrayList<Integer>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Teacher teacher = new Teacher();
				int id = rs.getInt("teacher_id");
				list.add(id);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateTeacher(Teacher tea) {
		Connection conn = DbUtil.getConnection();
		String sql = "update teacher set teacher_name=?,teacher_gendar=?,teacher_degree=?,teacher_jobtitle=?,teacher_age=?,deptno=? where teacher_id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, tea.getTeacher_name());
			ptmt.setString(2, tea.getTeacher_gendar());
			ptmt.setString(3, tea.getTeacher_degree());
			ptmt.setString(4, tea.getTeacher_jobtitle());
			ptmt.setInt(5, tea.getTeacher_age());
			ptmt.setInt(6, tea.getDeptno());
			ptmt.setInt(7, tea.getTeacher_id());
			int count = ptmt.executeUpdate();
			ptmt.close();
			return count == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Teacher queryTeacherById(int id) {
		Connection conn = DbUtil.getConnection();
		String sql = "select * from teacher where teacher_id=?";
		Teacher teacher = new Teacher();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				teacher.setTeacher_id(id);
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setTeacher_gendar(rs.getString("teacher_gendar"));
				teacher.setTeacher_degree(rs.getString("teacher_degree"));
				teacher.setTeacher_jobtitle(rs.getString("teacher_jobtitle"));
				teacher.setTeacher_age(rs.getInt("teacher_age"));
				teacher.setDeptno(rs.getInt("deptno"));
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}

	public int getMaxId() {
		Connection connection = DbUtil.getConnection();
		String sql = "select max(teacher_id) id from teacher";
		int count = 0;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("id");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count + 1;
	}

	// public static void main(String[] args) {
	// TeacherDao dao = new TeacherDao();
	// dao.queryTeacher();
	// }
}
