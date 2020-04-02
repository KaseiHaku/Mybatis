package kasei.mybatis.repository.mysql.dao.impl;

import kasei.mybatis.repository.mysql.dao.mapper.PersonDaoMapper5;
import kasei.mybatis.repository.mysql.entity.Person;
import kasei.mybatis.repository.mysql.dao.dynamicsqlsupport.PersonDynamicSqlSupport;
import kasei.mybatis.utility.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import java.util.List;

/** TODO 静态方法，静态变量 导入 */
import static kasei.mybatis.repository.mysql.dao.dynamicsqlsupport.PersonDynamicSqlSupport.*;


public class PersonDaoImpl5  {

    /** todo Mybatis 开发方式 5 */
    public List<Person> getPersonById(String id) {

        // todo 1. 获取 SqlSessionFactory 实例
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();

        // todo 2. 创建数据库 session 实例
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // todo 3. 配置绑定的 sql 的位置
        // 需要在 mybatis-config.xml 的 <mappers> 标签中添加一个 <mapper class="kasei.mybatis.repository.mysql.dao.mapper.PersonDaoMapper3"/>
        // sql 直接写在 PersonDaoMapper3 方法的注解上
        PersonDaoMapper5 mapper5 = sqlSession.getMapper(PersonDaoMapper5.class);



        // todo 4. 执行查询
        SelectStatementProvider selectStatement = SqlBuilder
                .select(PersonDynamicSqlSupport.id, name, age)  // 这里没有前缀的 name ,因为使用了静态导入
                .from(PERSON_TABLE)
                .where(PersonDynamicSqlSupport.id, SqlBuilder.isIn("1"))
                .and(age, SqlBuilder.isBetween(1).and(33))
                .orderBy(PersonDynamicSqlSupport.id.descending(), name)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<Person> persons = mapper5.selectMany(selectStatement);

        // todo 5. 提交并关闭会话
        sqlSession.commit();
        sqlSession.close();

        return persons;
    }



}
