package kasei.mybatis.module2.a03dao.b02sql;

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
	
	/** 增  删  改  查   */
	@Test		
	public void insertUser() {
		String statement = "com.kasei.mybatis.module2.a03dao.b02sql.a02b02_sql"+".insertUser";
		A01User user = new A01User();
		user.setId(8);
		user.setName("tty");
		user.setAge(-1);		
		int result = sqlSession.insert(statement, user); // result = 影响记录的条数
		sqlSession.commit();
		System.out.println(result);
	}	
	
	
	@Test		
	public void deleteUser() {
		String statement = "com.kasei.mybatis.module2.a03dao.b02sql.a02b02_sql"+".deleteUser";		
		int result = sqlSession.delete(statement, 8);		
		sqlSession.commit();
		System.out.println(result);
	}
	
	
	@Test		
	public void updateUser() {
		String statement = "com.kasei.mybatis.module2.a03dao.b02sql.a02b02_sql"+".updateUser";		
		A01User user = new A01User();
		user.setId(8);
		user.setName("b");
		user.setAge(66);		
		int result = sqlSession.update(statement, user);		
		sqlSession.commit();
		System.out.println(result);
	}
	
	
		
	/** 表列名跟实体类属性名不一致的情况 */
	@Test		
	public void getDog() {
		String statement = "com.kasei.mybatis.module2.a03dao.b02sql.a02b02_sql"+".getDog";	
		A02Dog dog = sqlSession.selectOne(statement, 1);		
		sqlSession.commit();
		System.out.println(dog.getKind());
	}
	
	@Test		
	public void getDog2() {
		String statement = "com.kasei.mybatis.module2.a03dao.b02sql.a02b02_sql"+".getDog2";	
		A02Dog dog = sqlSession.selectOne(statement, 1);		
		sqlSession.commit();
		System.out.println(dog.getKind());
	}
	
	/** mybatis 动态 sql */
	@Test		
	public void testIf() {
		String statement = "com.kasei.mybatis.module2.a03dao.b02sql.a02b02_sql"+".if";	
		
		List<A01User> users = sqlSession.selectList(statement, new A01User(null, "b", null));		
		sqlSession.commit();
		System.out.println(users);
	}
	
	@Test		
	public void testChoose() {
		String statement = "com.kasei.mybatis.module2.a03dao.b02sql.a02b02_sql"+".choose";	
				
		List<A01User> users = sqlSession.selectList(statement, 3);		
		sqlSession.commit();
		System.out.println(users);
	}
	
	@AfterClass
	public static void afterClass(){
		sqlSession.close();
	}
}
