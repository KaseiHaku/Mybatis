package kasei.mybatis.module2.a02mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kasei.mybatis.module2.a01entity.A01User;

public interface UserMapper {
	
	// 参数绑定：基本类型
	// 参数绑定：java bean
	// 参数绑定：嵌套 java bean
	// 参数绑定：HashMap
	// 参数绑定：List Set
	// 参数绑定：Array
	// 返回类型：基本类型
	// 返回类型：java bean
	// 返回类型：List<?>
	
	
	@Insert("insert into mybatis_user(id, name, age) values(#{id}, #{name}, #{age})")
	public int addUser(A01User user);
	
	@Delete("delete from mybatis_user where id=#{id}")
	public int deleteUser(int id);
	
	@Update("update mybatis_user set name=#{name}, age=#{age} where id=#{id}")
	public int updateUser(A01User user);
	
	@Select("select * from mybatis_user where id=#{id}")
	public A01User getUser(@Param("id") int id); // @Param("id")表示改变参数和sql对应的占位符名
	
	@Select("select * from mybatis_user")
	public List<A01User> getAllUsers();
}
