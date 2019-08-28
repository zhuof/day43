package com.zhuo.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zhuof
 * @company
 * @date 2019/8/27 16:52
 * @description
 */
public class DruidUtil {
    private  static Properties props=new Properties();

    public  static DruidDataSource getDataSource(){
        DruidDataSource ds=new DruidDataSource();
        ds.configFromPropety(props);
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
            try {
                if (!conn.isClosed()&&conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

   }
   public  static  void close(DruidDataSource dataSource){
        dataSource.close();
   }

    public static void main(String[] args) {
        System.out.println(DruidUtil.getDataSource());
    }
}
