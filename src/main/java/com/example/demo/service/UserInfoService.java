package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("UserInfoService")
public class UserInfoService implements UserDetailsService {
	
	private final UserInfoDao userInfoDao;
	
	private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserInfoService(UserInfoDao userInfoDao, BCryptPasswordEncoder passwordEncoder) {
        this.userInfoDao = userInfoDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		if(email == null || email.isEmpty()) {
			throw new UsernameNotFoundException("Username is empty");
		}
		
		UserInfo userInfo = userInfoDao.findByEmail(email);

		if(userInfo == null) {
			throw new UsernameNotFoundException("User not found for email:" + email);
		}

		return userInfo;
	}
	
	@Transactional
	public void save(UserInfo userInfo) {
		String hushPass = passwordEncoder.encode(userInfo.getPassword());
		userInfo.setPassword(hushPass);
		userInfoDao.insert(userInfo);
	}

}