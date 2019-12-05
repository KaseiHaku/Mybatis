package kasei.mybatis.repository.mysql.dao.impl;

import kasei.mybatis.repository.mysql.dao.PersonDao;
import kasei.mybatis.repository.mysql.dao.mapper.PersonDaoMapper2;
import kasei.mybatis.repository.mysql.entity.Person;
import kasei.mybatis.utility.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class PersonDaoImpl2 implements PersonDao {

    /** todo Mybatis 开发方式 2 */
    @Override
    public Person getPersonById(String id) {

        // todo 1. 获取 SqlSessionFactory 实例
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();

        // todo 2. 创建数据库 session 实例
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // todo 3. 配置绑定的 sql 的位置
        // 需要在 mybatis-config.xml 的 <mappers> 标签中添加一个 <mapper resource="kasei/mybatis/repository/mysql/mapper/PersonDaoMapper2.xml"/>
        // PersonDaoMapper2 的全类名必须跟 PersonDaoMapper2.xml 中的 namespace 相同
        // PersonDaoMapper2 中的方法名必须跟 PersonDaoMapper2.xml 中的 id 相同
        PersonDaoMapper2 mapper2 = sqlSession.getMapper(PersonDaoMapper2.class);



        // todo 4. 执行查询
        Person person = mapper2.selectById(id);

        // todo 5. 提交并关闭会话
        sqlSession.commit();
        sqlSession.close();

        return person;
    }

}
