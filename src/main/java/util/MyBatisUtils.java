package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtils {
    private  static SqlSessionFactory factory=null;
    static{
        String config="Mapper/AccountMapConfig.xml";
        try{
            InputStream in= Resources.getResourceAsStream(config);
            factory=new SqlSessionFactoryBuilder().build(in);
        }
        catch (Exception ex){ex.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        SqlSession session=null;
        if (factory!=null){
            session=factory.openSession();
        }
        return  session;
    }
}
