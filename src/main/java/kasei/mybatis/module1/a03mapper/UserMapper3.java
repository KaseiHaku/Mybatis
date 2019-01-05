package kasei.mybatis.module1.a03mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kasei.mybatis.module1.a01entity.User;


public interface UserMapper3 {

	@Select("select * from mybatis_user")
	public List<User> selectAll();
	
}
