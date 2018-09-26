package com.lu.code.mybatis;

import com.lu.code.mapper.TableMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @CLassName DynamicDataSource
 * @Description 动态数据源获取
 * @Author ll
 * @Date 2018/9/25 18:01
 **/
public class DynamicDataSource {


    private String driver;

    private String url;

    private String username;

    private String password;

    public DynamicDataSource(String driver , String url , String username , String password){
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    private SqlSessionFactory sqlSessionFactory;

    /*
     * @author ll
     * @Description 创建 SqlSessionFactory
     * @date 2018/9/25 18:10
     * @param []
     * @return org.apache.ibatis.session.SqlSessionFactory
     */
    public  SqlSessionFactory getSqlSessionFactory(){
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development" , transactionFactory,dataSource) ;
        Configuration configuration = new Configuration(environment);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addMapper(TableMapper.class);
        sqlSessionFactory =new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    /*
     * @author ll
     * @Description 获取SqlSession
     * @date 2018/9/25 18:12
     * @param []
     * @return org.apache.ibatis.session.SqlSession
     */
    public SqlSession openSession(){
        return getSqlSessionFactory().openSession();
    }
    /*
     * @author ll
     * @Description 关闭SqlSession
     * @date 2018/9/25 18:12
     * @param [sqlSession]
     * @return void
     */
    public void closeSession(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}
