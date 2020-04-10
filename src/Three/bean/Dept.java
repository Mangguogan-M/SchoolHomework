package Three.bean;

public class Dept {
	private int deptno;
	private String dept_name;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dept_name=" + dept_name + "]";
	}

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(int deptno, String dept_name) {
		super();
		this.deptno = deptno;
		this.dept_name = dept_name;
	}

}
