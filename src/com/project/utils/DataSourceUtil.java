package com.project.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author zhuof
 * @company
 * @date 2019/8/23 11:24
 * @description
 */
public class DataSourceUtil {
    private  static DataSource ds;

    static {
        Properties info=new Properties();
        try (InputStream in=DataSourceUtil.class.getResourceAsStream("/resources/db.properties")){
            info.load(in);
            ds= DruidDataSourceFactory.createDataSource(info);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static  DataSource getDataSource(){
        return  ds;
    }

    public  static Connection getConnection() throws SQLException{
        return  ds.getConnection();
    }
}
