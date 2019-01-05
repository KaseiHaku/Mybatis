package kasei.mybatis.module2.a01entity;


public class A02Dog {
	private Integer id;
	private String name;
	private String kind;
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	@Override
	public String toString() {
		return "A02Dog [id=" + id + ", name=" + name + ", kind=" + kind + "]";
	}
	
}
