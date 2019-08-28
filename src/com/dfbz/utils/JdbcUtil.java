package com.dfbz.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zhuof
 * @company
 * @date 2019/8/27 14:24
 * @description
 */
public class JdbcUtil {
//    private  static  String driver;
//    private  static String url;
//    private  static  String username;
//    private  static  String password;
//    private  static  String initialSize;//初始化连接数
//    private  static String  minIdle;//最小连接数
//    private  static  String maxActive;//最大连接
//    private  static  String maxWait;//连接超时

    private  static Properties props=new Properties();

    static {
        try {
            props.load(JdbcUtil.class.getClassLoader().getResourceAsStream("resources/db2.properties"));
//               driver=props.getProperty("driver");
//               url=props.getProperty("url");
//               username=props.getProperty("username");
//               password=props.getProperty("password");
//            initialSize=props.getProperty("initialSize");
//               minIdle=props.getProperty("minIdle");
//               maxActive=props.getProperty("maxActive");
//               maxWait=props.getProperty("maxWait");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DruidDataSource getDataSource(){
        DruidDataSource ds=new DruidDataSource();
        ds.configFromPropety(props);
//        ds.setDriverClassName(driver);
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        ds.setMinIdle(Integer.valueOf(minIdle));
//        ds.setInitialSize(Integer.valueOf(initialSize));
//        ds.setMaxActive(Integer.valueOf(maxActive));
//        ds.setMaxWait(Long.valueOf(maxWait));
        return ds;
    }

    public  static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   public  static  void close(Connection conn){
        if (conn!=null){
            try {
                if (!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }

   public  static  void  close(DruidDataSource dataSource){
        dataSource.close();
   }

    public static void main(String[] args) {
        System.out.println(JdbcUtil.getDataSource());
    }
}
