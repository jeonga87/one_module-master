package com.example.demo.security;

import com.example.demo.admin.domain.Admin;
import com.example.demo.admin.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDetailsService")
public class SecUserDetailService implements UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(SecUserDetailService.class);

	@Autowired
	private AdminService adminService;

	/**
	 * username(=ID)로 정보 조회 (for Spring Security)
	 * @param username 로그인 아이디
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminService.getAdminId(username);

		// 없는 계정일 경우
		if(admin == null) {
			log.info("존재하는 계정이 없음(ID: " + username + ")");
			throw new UsernameNotFoundException("NO ACCOUNT");
		}

		// 탈퇴 계정인 경우
		if(!admin.isEnabled()) {
			log.info("로그인 실패: 탈퇴된 계정(ID: " + username + ")");
			throw new SecAccountStatusException("DISABLED ACCOUNT");
		}

		return admin;
	}
}
