package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.impl.UserServiceImpl;
 


/**
 *@author lizha 
 */
@RestController
@RequestMapping("/user")
@Api("userController相关api")
@EnableSwagger2
public class UserController {
	 	@Autowired
	    private UserServiceImpl userServiceImpl;
	    
	@ApiOperation("添加用户")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "loginname", dataType = "String", required = true, value = "用户的姓名", defaultValue = "lizhaoteng"),
			@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "123456") })
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public boolean addUser(@RequestParam("loginname") String loginname, @RequestParam("password") String password) {
		return userServiceImpl.addUser(loginname, password);
	}

	@ApiOperation("添加用户且返回已经设置了主键的user实例")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "loginname", dataType = "String", required = true, value = "用户的姓名", defaultValue = "lizhaoteng"),
			@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "123456") })
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/addUserWithBackId", method = RequestMethod.GET)
	public User addUserWithBackId(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password) {
		return userServiceImpl.addUserWithBackId(loginname, password);
	}
	@RequestMapping(value= "/selectUserById", method = RequestMethod.GET)
	@ResponseBody
	public User serlctUserById(@RequestParam("id") int id) {
		return userServiceImpl.selectUser(id);
	}
	@RequestMapping(value= "/deleteByPrimaryKey", method = RequestMethod.GET)
	@ResponseBody
	public int deleteByPrimaryKey(@RequestParam("id") int id) {
		return userServiceImpl.deleteByPrimaryKey(id);
	}
	@RequestMapping(value= "/updateByPrimaryKey", method = RequestMethod.GET)
	@ResponseBody
	public int updateByPrimaryKey(@RequestParam("id") int id,@RequestParam("loginname") String loginname,
			@RequestParam("password") String password) {
		User user = new User();
		user.setId(id);
		user.setLoginName(loginname);
		user.setPassword(password);
		return userServiceImpl.updateByPrimaryKey(user);
	}

}
