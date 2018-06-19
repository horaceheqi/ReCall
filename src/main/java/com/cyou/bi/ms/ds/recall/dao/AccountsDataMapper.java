package com.cyou.bi.ms.ds.recall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyou.bi.ms.ds.recall.bean.AccountsData;

public interface AccountsDataMapper {
	int insert(AccountsData record);

	int insertSelective(AccountsData record);

	List<AccountsData> selectByCnmaster(@Param("cnmaster") String cnmaster);
}