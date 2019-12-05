package kasei.mybatis.repository.mysql.dao.impl;

import kasei.mybatis.repository.mysql.dao.PersonDao;
import kasei.mybatis.repository.mysql.dao.mapper.PersonDaoMapper3;
import kasei.mybatis.repository.mysql.dao.mapper.PersonDaoMapper4;
import kasei.mybatis.repository.mysql.entity.Person;
import kasei.mybatis.utility.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class PersonDaoImpl4 implements PersonDao {

    /** todo Mybatis 开发方式 4 */
    @Override
    public Person getPersonById(String id) {

        // todo 1. 获取 SqlSessionFactory 实例
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();

        // todo 2. 创建数据库 session 实例
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // todo 3. 配置绑定的 sql 的位置
        // 需要在 mybatis-config.xml 的 <mappers> 标签中添加一个 <mapper class="kasei.mybatis.repository.mysql.dao.mapper.PersonDaoMapper3"/>
        // sql 直接写在 PersonDaoMapper3 方法的注解上
        PersonDaoMapper4 mapper4 = sqlSession.getMapper(PersonDaoMapper4.class);



        // todo 4. 执行查询
        Person person = mapper4.selectById(id);

        // todo 5. 提交并关闭会话
        sqlSession.commit();
        sqlSession.close();

        return person;
    }

}
