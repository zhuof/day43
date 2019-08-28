package com.zhuo.dao;


import com.dfbz.entity.Users;
import com.dfbz.utils.JdbcUtil;
import com.zhuo.entity.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


/**
 * @author zhuof
 * @company
 * @date 2019/8/27 16:37
 * @description
 */
public class StudentDao {
    //保存
     public int save(Student student){
         QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
         String sql="insert into stu(stuId,birthday,stuName,stuPassword) values(?,?,?,?)";
          Object[] params={student.getStuId(),student.getBirthday(),student.getStuName(),student.getStuPassword()};
         int i=1;
         try {
             runner.update(sql,params);
         } catch (SQLException e) {
             System.out.println("添加失败！");
             i=0;
         }finally {
             JdbcUtil.close(JdbcUtil.getDataSource());
         }
         return i;
     }

     //更新
    public  int update(Student student){
   QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
   String sql="update stu  set birthday=?,stuPassword=?,stuName=? where stuId=?";
        Object[] params={student.getBirthday(),student.getStuPassword(),student.getStuName(),student.getStuId()};
        int i=1;
        try {
            runner.update(sql,params);
        } catch (SQLException e) {
            System.out.println("更新失败！");
            i=0;
        }finally {
            JdbcUtil.close(JdbcUtil.getDataSource());
        }
        return i;
     }
     //通过id删除
    public  int delete(int id){
         QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
        String sql="delete from stu where stuId=?";
        int i=1;
        try {
            runner.update(sql,id);
        } catch (SQLException e) {
            System.out.println("删除失败！");
            i=0;
        }finally {
            JdbcUtil.close(JdbcUtil.getDataSource());
        }
        return i;
    }
    //通过id查询
    public  Student find(int id){
         QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
        String sql="select* from stu where stuId=?";
        Student student=null;

        try {
           student=runner.query(sql,new BeanHandler<>(Student.class),id);
        } catch (SQLException e) {
            System.out.println("查找失败！");

        }finally {
            JdbcUtil.close(JdbcUtil.getDataSource());
        }
        return student;
    }

    //查询所有数据
    public List<Student> findAll(){
         QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
        String sql="select stuId,stuName,stuPassword,birthday from stu";
        List list = null;
        try {
             list=runner.query(sql,new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            System.out.println("查询失败！");
        }finally {
            JdbcUtil.close(JdbcUtil.getDataSource());
        }
        return list;
    }
}
