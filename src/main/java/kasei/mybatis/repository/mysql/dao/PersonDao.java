package kasei.mybatis.repository.mysql.dao;

import kasei.mybatis.repository.mysql.entity.Person;

public interface PersonDao {
    Person getPersonById(String id);
}
