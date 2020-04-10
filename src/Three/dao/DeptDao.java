package Three.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Three.bean.Dept;
import Three.utils.DbUtil;

public class DeptDao {
	public List<Dept> getDept() {
		Connection conn = DbUtil.getConnection();
		String sql = "select * from dept";
		List<Dept> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDept_name(rs.getString("dept_name"));
				list.add(dept);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
