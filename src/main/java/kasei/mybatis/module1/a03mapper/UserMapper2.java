package kasei.mybatis.module1.a03mapper;

import java.util.List;
import java.util.Map;

import com.kasei.mybatis.module1.a01entity.User;

public interface UserMapper2 {

	// 查询所有
	public List<User> selectAll();
	
	// 查询单一
	public User selectOne(Integer id);
	
	public Map<String, Object> returnMap();
}
