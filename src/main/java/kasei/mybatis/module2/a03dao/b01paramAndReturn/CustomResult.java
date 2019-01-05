package kasei.mybatis.module2.a03dao.b01paramAndReturn;

public class CustomResult {
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "CustomResult [name=" + name + ", age=" + age + "]";
	}
	
}
