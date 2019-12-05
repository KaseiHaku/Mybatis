package kasei.mybatis;


import kasei.mybatis.repository.mysql.dao.impl.*;
import kasei.mybatis.repository.mysql.entity.Person;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.SqlTable;

import java.io.IOException;
import java.util.List;

public class MainTest {

    @Test
    public void devStyle1() {
        PersonDaoImpl1 personDaoImpl1 = new PersonDaoImpl1();
        Person personById = personDaoImpl1.getPersonById("1");
        System.out.println(personById.getName());
    }

    @Test
    public void devStyle2() {
        PersonDaoImpl2 personDaoImpl2 = new PersonDaoImpl2();
        Person personById = personDaoImpl2.getPersonById("1");
        System.out.println(personById.getName());
    }

    @Test
    public void devStyle3() {
        PersonDaoImpl3 personDaoImpl3 = new PersonDaoImpl3();
        Person personById = personDaoImpl3.getPersonById("1");
        System.out.println(personById.getName());
    }

    @Test
    public void devStyle4() {
        PersonDaoImpl4 personDaoImpl4 = new PersonDaoImpl4();
        Person personById = personDaoImpl4.getPersonById("1");
        System.out.println(personById.getName());
    }

    @Test
    public void devStyle5() {
        PersonDaoImpl5 personDaoImpl5 = new PersonDaoImpl5();
        List<Person> personById1 = personDaoImpl5.getPersonById("");
        System.out.println(personById1.get(0).getAge());
    }
}
