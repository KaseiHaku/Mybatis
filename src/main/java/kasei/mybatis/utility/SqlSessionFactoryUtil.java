package kasei.mybatis.utility;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;

    private SqlSessionFactoryUtil(){}


    public static SqlSessionFactory getInstance(){
        if (sqlSessionFactory == null) {
            String classpathConfigFile = "mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(classpathConfigFile);  // 加载 mybatis 配置文件
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // 根据配置文件创建 SqlSessionFactory 实例
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sqlSessionFactory;
    }


}
