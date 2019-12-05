package kasei.mybatis.repository.mysql.dao.mapper;

import kasei.mybatis.repository.mysql.entity.Person;

public interface PersonDaoMapper2 {


    Person selectById(String id);
}
