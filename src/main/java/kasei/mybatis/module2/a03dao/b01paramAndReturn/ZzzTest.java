package kasei.mybatis.module2.a03dao.b01paramAndReturn;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kasei.mybatis.module2.a01entity.A01User;

public class ZzzTest {		
	private static Reader reader;
	private static SqlSessionFactory sessionFactory;
	private static SqlSession sqlSession;
	
	
	@BeforeClass
	public static void beforeClass() throws IOException{
		reader = Resources.getResourceAsReader("config/mybatis.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		sqlSession = sessionFactory.openSession();
	}
	
	
	@Test		
	public void baseType() {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".baseType";
		A01User user = sqlSession.selectOne(statement, 2);
		sqlSession.commit();
		System.out.println(user);
	}
	
	@Test		
	public void javaBean() {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".javaBean";
		List<A01User> users = sqlSession.selectList(statement, new A01User(2, "c", 3));
		sqlSession.commit();
		System.out.println(users);
	}
	
	@Test		
	public void nestJavaBean() {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".nestJavaBean";
		
		A01User user = new A01User(2, "c", 3);
		NestJavaBean nestJavaBean = new NestJavaBean();
		nestJavaBean.setUser(user);
					
		List<A01User> users = sqlSession.selectList(statement, nestJavaBean);
		sqlSession.commit();
		System.out.println(users);
	}
	
	@Test		
	public void map() {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".map";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 3);
		map.put("name", "c");
					
		List<A01User> users = sqlSession.selectList(statement, map);
		sqlSession.commit();
		System.out.println(users);
	}
	
	@Test		
	public void list() {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".list";
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
					
		List<A01User> users = sqlSession.selectList(statement, list);
		sqlSession.commit();
		System.out.println(users);
	}
	
	@Test		
	public void array() {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".array";
		
		int[] array = new int[3];
		array[0] = 2;
		array[1] = 3;
					
		List<A01User> users = sqlSession.selectList(statement, array);
		sqlSession.commit();
		System.out.println(users);
	}
	
	@Test		
	public void parameterMap() {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".parameterMap";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 8);
		map.put("name", "dfd");
		map.put("age", 0);
		
		sqlSession.selectOne(statement, map);
		
		sqlSession.commit();
		System.out.println("name="+map.get("name")
				+" age="+map.get("age"));
	}
	
	
	@Test		
	public void returnBaseType () {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".returnBaseType";
					
		List<Integer> ids = sqlSession.selectList(statement);
		sqlSession.commit();
		System.out.println(ids);
	}
	
	
	@Test		
	public void returnJavaBean () {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".returnJavaBean";					
		List<A01User> users = sqlSession.selectList(statement);
		sqlSession.commit();
		System.out.println(users);
	}
	
	
	@Test		
	public void returnCustom () {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".returnCustom";
					
		List<CustomResult> list = sqlSession.selectList(statement);
		sqlSession.commit();
		System.out.println(list);
	}
	
	@Test
	public void returnMap() {
		String statement = "com.kasei.mybatis.module2.a03dao.b01paramAndReturn.a02b01_param"+".returnMap";
		Map<String, Map<String, String>> map = sqlSession.selectMap(statement, "age");
		System.out.println(map.toString());
		System.out.println(map.get(33).get("name"));// 对比与上一行代码的区别
	}

	
	@AfterClass
	public static void afterClass(){
		sqlSession.close();
	}
}
