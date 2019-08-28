package com.dfbz.test;

import com.dfbz.entity.Users;
import com.dfbz.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author zhuof
 * @company
 * @date 2019/8/27 14:48
 * @description
 */
public class TestDbutils {

   @Test
    public  void  insert() throws SQLException{
       QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
       String sql="insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
       Object params[]={3,"bbb","123","aa@sina.com",new Date()};
       runner.update(sql,params);
   }

   @Test
    public  void update() throws  SQLException{
       QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
       String sql="update users set email=? where id=?";
       Object params[]={"aaaaaa@sina.com",1};
       runner.update(sql,params);
   }

   @Test
    public  void delete() throws  SQLException{
       QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
       String sql="delete from users where id=?";
       runner.update(sql,1);
   }

   @Test
    public  void find() throws  SQLException{
       QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
       String sql="select* where id=?";
       Users user=runner.query(sql,new BeanHandler<>(Users.class),1);
       System.out.println(user.getEmail());
   }

   @Test
    public  void getAll() throws  Exception{
       QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
       String sql="select* from users";
       List list= runner.query(sql,new BeanListHandler<>(Users.class));
       System.out.println(list);
   }
}
