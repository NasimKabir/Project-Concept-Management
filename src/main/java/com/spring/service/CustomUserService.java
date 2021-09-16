package com.spring.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Role;
import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userDetailsRepository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user=userDetailsRepository.findByUsername(username);
		List<Role> authorities = (List<Role>) user.getAuthorities();

		Hibernate.initialize(authorities);
		if(null==user) {
			throw new UsernameNotFoundException("User Not Found with userName "+username);
		}
		return user;
	}

}

