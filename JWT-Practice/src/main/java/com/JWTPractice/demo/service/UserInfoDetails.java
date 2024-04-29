package com.JWTPractice.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.JWTPractice.demo.Entity.User;



public class UserInfoDetails implements UserDetails {
	
	 String username=null;
	    String password = null;
	    List<GrantedAuthority> authorities;

	    public UserInfoDetails(User user){
	       username= user.getUsername();
	       password= user.getPassword();
	       authorities= Arrays.stream(user.getRoles().split(","))
	               .map(SimpleGrantedAuthority::new)
	               .collect(Collectors.toList());
	    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities ;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
