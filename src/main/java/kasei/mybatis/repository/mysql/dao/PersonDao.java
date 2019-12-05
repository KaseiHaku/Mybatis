package kasei.mybatis.repository.mysql.dao;

import kasei.mybatis.repository.mysql.entity.Person;

/**
 * TODO
 *
 * @author Kasei Haku
 * @date 2019/12/5 17:44
 */
public interface PersonDao {


    Person getPersonById(String id);
}
