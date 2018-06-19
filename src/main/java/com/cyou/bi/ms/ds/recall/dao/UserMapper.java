package com.cyou.bi.ms.ds.recall.dao;

import org.apache.ibatis.annotations.Param;

import com.cyou.bi.ms.ds.recall.bean.User;

public interface UserMapper {
	int insert(User record);

	int insertSelective(User record);

	User selectSecurity(@Param("username") String username);
}