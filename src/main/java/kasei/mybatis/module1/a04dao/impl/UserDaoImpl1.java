package kasei.mybatis.module1.a04dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kasei.mybatis.module1.a01entity.User;

public class UserDaoImpl1 {

	// mybatis 开发方式之一
	public void test1() throws IOException {
		// 加载 mybatis 的配置文件，其中包含了关联的映射文件
		// 方法一：
		InputStream reader1 = User.class.getClassLoader().getResourceAsStream("config/mybatis.xml");
		
		// 方法二：
		Reader  reader2 = Resources.getResourceAsReader("config/mybatis.xml");
		
		// 构建 sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader2);
		
		// 创建能执行映射文件中 sql 的 sqlSession,false默认不自动提交
		SqlSession sqlSession = sessionFactory.openSession(false);
		
		// 映射 sql 的标识字符串
		String statement = "com.kasei.mybatis.module1.a01entity.User"+".selectOne";
		
		// 执行查询返回一个唯一的 user 对象的 sql
		User user =  sqlSession.selectOne(statement, 8);// 2 就是 sql 语句中的占位符
		
		// 提交
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println(user.getAge());
	}	
}
