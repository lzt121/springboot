package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.User;
@Mapper
public interface UserMapper {
	@Insert("INSERT INTO tb_user(login_name, password) VALUES(#{loginName},#{password})")
    public int insertUser(@Param("loginName") String loginName, @Param("password")  String password);
	
	 /**
     * 插入用户，并将主键设置到user中
     * 注意：返回的是数据库影响条数，即1
     */
    public int insertUserWithBackId(User user);
    
    /**
     *@author lizha 
     */
    public User selectUserById(int id);
    /**
     *@author lizha 
     */
    public int deleteByPrimaryKey(int id);
    /**
     *@author lizha 
     */
    public int updateByPrimaryKey(User user);
}
