package kasei.mybatis.repository.mysql.dao.mapper;

import kasei.mybatis.repository.mysql.dao.sqlprovider.PersonDaoMapper4SqlProvider;
import kasei.mybatis.repository.mysql.entity.Person;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

public interface PersonDaoMapper5 {

    @SelectProvider(type= SqlProviderAdapter.class, method = "select")
    @Results(id="personTableResult", value = {
        @Result(column="A_ID", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="age", property="age", jdbcType= JdbcType.INTEGER, id=true)
    })
    List<Person> selectMany(SelectStatementProvider selectStatement);
}
