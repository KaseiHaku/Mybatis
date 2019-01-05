package kasei.mybatis.module1.a04dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kasei.mybatis.module1.a01entity.User;
import com.kasei.mybatis.module1.a03mapper.UserMapper2;

public class UserDaoImpl2 {

	// mybatis 开发方式之二
	public void test2() throws IOException {
		
		// 加载 mybatis 的配置文件，其中包含了关联的映射文件
		// 方法一：
		InputStream reader1 = User.class.getClassLoader().getResourceAsStream("config/mybatis.xml");
		// 方法二：
		Reader  reader2 = Resources.getResourceAsReader("config/mybatis.xml");
		
		// 构建 sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader2);
		
		// 创建能执行映射文件中 sql 的 sqlSession,false默认不自动提交
		SqlSession sqlSession = sessionFactory.openSession(false);
		
		// 创建接口对象，这个是session对象通过动态代理自动帮我们创建的
		UserMapper2 userMapper2 = sqlSession.getMapper(UserMapper2.class);
		
		// 使用创建好的接口对象来调用方法
		List<User> list = userMapper2.selectAll();
		
		Map<String, Object> map = userMapper2.returnMap();
		System.out.println(map.toString());
		
		// 提交
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println(list);
	}
}
