package com.zhuo.entity;

import java.util.Date;

/**
 * @author zhuof
 * @company
 * @date 2019/8/27 16:37
 * @description
 */
public class Student {
 private  Integer stuId;
 private  String stuName;
 private  String stuPassword;
 private Date birthday;

    public Student() {
    }

    public Student(Integer stuId, String stuName, String stuPassword, Date birthday) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuPassword = stuPassword;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
