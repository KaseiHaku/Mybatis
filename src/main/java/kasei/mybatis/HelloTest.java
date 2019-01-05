package kasei.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class HelloTest {

	public static void main(String[] args) throws IOException {
					
		// 加载 mybatis 的配置文件，其中包含了关联的映射文件
		// 方法一：
		InputStream reader1 = HelloTest.class.getClassLoader().getResourceAsStream("mybatis.xml");
		// 方法二：
		Reader  reader2 = Resources.getResourceAsReader("mybatis.xml");
		
		// 构建 sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader2);
		
		// 创建能执行映射文件中 sql 的 sqlSession,false默认不自动提交
		SqlSession sqlSession = sessionFactory.openSession(false);
		
		// 映射 sql 的标识字符串
		String statement = "com.kasei.mybatis.HelloMapper"+".getHello";
		
		// 执行查询返回一个唯一的 user 对象的 sql
		HelloEntity hello =  sqlSession.selectOne(statement, 2);// 2 就是 sql 语句中的占位符
		
		// 提交
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println(hello.getMessage());
	}
}
