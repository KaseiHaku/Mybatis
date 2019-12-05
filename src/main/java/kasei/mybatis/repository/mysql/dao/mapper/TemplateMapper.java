package kasei.mybatis.repository.mysql.dao.mapper;

import kasei.mybatis.repository.mysql.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateMapper {
	// CURD: start
	public Integer insert(Person person);
	public Integer delete(Person person);
	public Integer update(@Param("condition") Person condition, @Param("values") Person values);
	public List<Person> select(Person user);
	// CURD: end
}
