package com.epam.training.shop.service.impl;

import com.epam.training.shop.model.CustomerCredentials;
import com.epam.training.shop.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private CustomerService customerService;
 
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        CustomerCredentials customerCredentials = customerService.findByLogin(login);

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority("ROLE_"+customerCredentials.getRole().toString().toUpperCase()));
 
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(customerCredentials.getLogin(),
                                                                       customerCredentials.getPassword(),
                                                                       roles);
 
        return userDetails;
    }
 
}