package kasei.mybatis.module2.a03dao.b03relationMap;

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
	
	
	/** 关联关系：一对一 */
	@Test		
	public void getWife() {
		String statement = "com.kasei.mybatis.module2.a03dao.b03relationMap.a02b03_relationMap"+".getWife";	
		A03Wife wife = sqlSession.selectOne(statement, 1);
		
		sqlSession.commit();
		System.out.println(wife.getHusband().getName());
	}
	
	@Test		
	public void getWife2() {
		String statement = "com.kasei.mybatis.module2.a03dao.b03relationMap.a02b03_relationMap"+".getWife2";	
		A03Wife wife = sqlSession.selectOne(statement, 1);
		
		sqlSession.commit();
		System.out.println(wife.getHusband().getName());
	}
	
	@Test		
	public void getTeacher() {
		String statement = "com.kasei.mybatis.module2.a03dao.b03relationMap.a02b03_relationMap"+".getTeacher";	
		A04Teacher teacher = sqlSession.selectOne(statement, 1);
		
		sqlSession.commit();
		System.out.println(teacher);
	}
	
	@Test		
	public void getTeacher2() {
		String statement = "com.kasei.mybatis.module2.a03dao.b03relationMap.a02b03_relationMap"+".getTeacher2";	
		A04Teacher teacher = sqlSession.selectOne(statement, 1);
		
		sqlSession.commit();
		System.out.println(teacher);
	}	
	
	
	@AfterClass
	public static void afterClass(){
		sqlSession.close();
	}
}
