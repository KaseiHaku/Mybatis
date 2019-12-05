package kasei.mybatis.repository.mysql.dao.mapper;

import kasei.mybatis.repository.mysql.entity.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonDaoMapper3 {

    @Select("select * from person where id = #{id}")
    Person selectById(String id);
}
