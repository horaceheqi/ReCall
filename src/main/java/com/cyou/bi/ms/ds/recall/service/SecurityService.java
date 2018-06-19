package com.cyou.bi.ms.ds.recall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cyou.bi.ms.ds.recall.bean.User;
import com.cyou.bi.ms.ds.recall.dao.UserMapper;

@Component
public class SecurityService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userMapper.selectSecurity(username);
		if (user == null) {
			throw new UsernameNotFoundException(String
					.format("User with username=%s was not found", username));
		}

		return user;
	}
}
