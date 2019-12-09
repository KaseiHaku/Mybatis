package kasei.mybatis.repository.mysql.dao.impl;

import kasei.mybatis.repository.mysql.dao.PersonDao;
import kasei.mybatis.repository.mysql.entity.Person;
import kasei.mybatis.utility.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class PersonDaoImpl1 implements PersonDao {

    /** todo Mybatis 开发方式 1 */
    @Override
    public Person getPersonById(String id) {

        // todo 1. 获取 SqlSessionFactory 实例
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();

        // todo 2. 创建数据库 session 实例
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // todo 3. 配置绑定的 sql 的位置
        // 需要在 mybatis-config.xml 的 <mappers> 标签中添加一个 <mapper resource="kasei/mybatis/repository/mysql/mapper/PersonDaoMapper1.xml"/>
        String associatedXmlMapper = "kasei.mybatis.repository.mysql.dao.sqlprovider.PersonDaoMapper1";  // 跟 PersonDaoMapper1.xml 中 <mapper> 标签的 namespace 属性值绑定
        String sqlIdInXmlMapper = "selectById";     // 跟 PersonDaoMapper1.xml 中 <select> 标签的 id 属性值绑定
        String sqlLocation = associatedXmlMapper + "." + sqlIdInXmlMapper;

        // todo 4. 执行查询
        Object o = sqlSession.selectOne(sqlLocation, id);

        // todo 5. 提交并关闭会话
        sqlSession.commit();
        sqlSession.close();

        return (Person) o;
    }

}
