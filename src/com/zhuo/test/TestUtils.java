package com.zhuo.test;

import com.zhuo.dao.StudentDao;
import com.zhuo.entity.Student;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author zhuof
 * @company
 * @date 2019/8/27 17:05
 * @description
 */
public class TestUtils {
    @Test
    public  void insert(){
        Student student=new Student(11,"张三","123",new Date());
     StudentDao studentDao=new StudentDao();
       int isTure1=studentDao.save(student);
       if (isTure1==0){
           return;
       }else if (isTure1==1){
           System.out.println("添加成功！");
       }
    }
    @Test
    public  void update(){
        Student student=new Student(1,"zhangsan2","123",new Date());
        StudentDao studentDao=new StudentDao();
        int isTure1=studentDao.update(student);
        if (isTure1==0){
            return;
        }else if (isTure1==1){
            System.out.println("更新成功！");
        }
    }

    @Test
    public  void delete(){
        StudentDao studentDao=new StudentDao();
        int isTure1=studentDao.delete(1);
        if (isTure1==0){
            return;
        }else if (isTure1==1){
            System.out.println("删除成功！");
        }
    }
    @Test
    public  void find(){
        StudentDao studentDao=new StudentDao();
        Student student=studentDao.find(3);

        if (student==null){
            return;
        }else{
            System.out.println("查找成功！");
            System.out.println(student);
        }
    }

    @Test
    public  void findAll(){
        StudentDao studentDao=new StudentDao();
        List<Student> list=studentDao.findAll();

        if (list==null){
            return;
        }else{
            System.out.println("查询成功！");
            for (Student s:list){
            System.out.println(s);
            }
        }
    }
}
