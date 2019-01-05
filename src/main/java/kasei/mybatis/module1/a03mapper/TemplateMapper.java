package kasei.mybatis.module1.a03mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kasei.mybatis.module1.a01entity.User;

public interface TemplateMapper {
	// CURD: start
	public Integer insert(User user);
	public Integer delete(User user); 
	public Integer update(@Param("condition") User condition, @Param("values") User values); 
	public List<User> select(User user); 
	// CURD: end
}
