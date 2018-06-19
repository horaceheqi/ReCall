package com.cyou.bi.ms.ds.recall.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cyou.bi.ms.ds.recall.bean.AccountsData;
import com.cyou.bi.ms.ds.recall.dao.AccountsDataMapper;

@Component
public class AccountsDataService {
	@Autowired
	private AccountsDataMapper accountsDataMapper;

	public List<AccountsData> getAccountsData(
			@Param("cnmaster") String cnmaster) {
		List<AccountsData> accountsData = accountsDataMapper
				.selectByCnmaster(cnmaster);
		return accountsData;
	}
}
