package kasei.mybatis.module2.a01entity;

public class A03Wife {
	private Integer id;
	private String name;
	private A03Husband husband;
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
	public A03Husband getHusband() {
		return husband;
	}
	public void setHusband(A03Husband husband) {
		this.husband = husband;
	}
	@Override
	public String toString() {
		return "A03Wife [id=" + id + ", name=" + name + ", husband=" + husband + "]";
	}
	
	
}
