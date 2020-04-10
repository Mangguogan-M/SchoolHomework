package Three.bean;

public class Teacher {
	private int teacher_id;
	private String teacher_name;
	private String teacher_gendar;
	private String teacher_degree;
	private String teacher_jobtitle;
	private int teacher_age;
	private int deptno;
	private String dept;

	public Teacher(int teacher_id, String teacher_name, String teacher_gendar, String teacher_degree,
			String teacher_jobtitle, int age, String dept) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacher_gendar = teacher_gendar;
		this.teacher_degree = teacher_degree;
		this.teacher_jobtitle = teacher_jobtitle;
		this.teacher_age = age;
		this.dept = dept;
	}

	public Teacher(int teacher_id, String teacher_name, String teacher_gendar, String teacher_degree,
			String teacher_jobtitle, int teacher_age, int deptno) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacher_gendar = teacher_gendar;
		this.teacher_degree = teacher_degree;
		this.teacher_jobtitle = teacher_jobtitle;
		this.teacher_age = teacher_age;
		this.deptno = deptno;
	}

	public Teacher() {
		super();
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_gendar() {
		return teacher_gendar;
	}

	public void setTeacher_gendar(String teacher_gendar) {
		this.teacher_gendar = teacher_gendar;
	}

	public String getTeacher_degree() {
		return teacher_degree;
	}

	public void setTeacher_degree(String teacher_degree) {
		this.teacher_degree = teacher_degree;
	}

	public String getTeacher_jobtitle() {
		return teacher_jobtitle;
	}

	public void setTeacher_jobtitle(String teacher_jobtitle) {
		this.teacher_jobtitle = teacher_jobtitle;
	}

	public int getTeacher_age() {
		return teacher_age;
	}

	public void setTeacher_age(int age) {
		this.teacher_age = age;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
