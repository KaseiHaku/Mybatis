package kasei.mybatis.repository.mysql.dao.mapper;

import kasei.mybatis.repository.mysql.dao.sqlprovider.PersonDaoMapper4SqlProvider;
import kasei.mybatis.repository.mysql.entity.Person;
import org.apache.ibatis.annotations.SelectProvider;

public interface PersonDaoMapper4 {

    @SelectProvider(type= PersonDaoMapper4SqlProvider.class, method = "buildSelectById")
    Person selectById(String id);
}
