package kasei.mybatis.module2.a01entity;

import java.util.Set;

public class A04Teacher {
	private Integer id;
	private String name;
	private Set<A04Student> students;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<A04Student> getStudents() {
		return students;
	}
	public void setStudents(Set<A04Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "A04Teacher [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	
}
