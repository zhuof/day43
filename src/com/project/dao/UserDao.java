package com.project.dao;



import com.project.entity.User;
import com.project.utils.DataSourceUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zhuof
 * @company
 * @date 2019/8/23 14:32
 * @description
 */
public class UserDao {
    private JdbcTemplate template=new JdbcTemplate(DataSourceUtil.getDataSource());

    public User findUser(String username, String password){
        try {
            return  template.queryForObject("select* from demo where username=? and password=?",
                    new BeanPropertyRowMapper<>(User.class),username,password);
        } catch (Exception e) {
            return null;
        }
    }
}
