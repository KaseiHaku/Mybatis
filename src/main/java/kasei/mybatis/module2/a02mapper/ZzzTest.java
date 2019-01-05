package kasei.mybatis.module2.a02mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kasei.mybatis.module1.a03mapper.UserMapper3;
import com.kasei.mybatis.module2.a01entity.A01User;
import com.kasei.mybatis.module2.a01entity.A02Dog;
import com.kasei.mybatis.module2.a01entity.A03Wife;
import com.kasei.mybatis.module2.a01entity.A04Teacher;
import com.kasei.mybatis.module2.a02mapper.UserMapper;

public class ZzzTest {		
	private static Reader  reader;
	private static SqlSessionFactory sessionFactory;
	private static SqlSession sqlSession;
	
	
	@BeforeClass
	public static void beforeClass() throws IOException{
		reader = Resources.getResourceAsReader("config/mybatis.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sessionFactory.openSession();
	}
	
	@Test
	public void test() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		A01User user =  new A01User();
		user.setId(1);
		user.setName("匹夫");
		user.setAge(33);
		userMapper.addUser(user);
		sqlSession.commit();
	}
	
	@AfterClass
	public static void afterClass(){
		sqlSession.close();
	}
}
