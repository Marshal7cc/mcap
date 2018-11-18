package com.marshal.mcap.security.service.impl;

import com.marshal.mcap.account.entity.SysUser;
import com.marshal.mcap.account.mapper.SysUserMapper;
import com.marshal.mcap.account.service.SysUserService;
import com.marshal.mcap.security.bean.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/12
 * Time: 20:03
 * Description:Spring Security UserService
 */
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.getUserByUsername(username);
        if(sysUser==null){
            throw new UsernameNotFoundException("user not found:"+username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

//        for(String role:user.getRoleCode()){
//            authorities.add(new SimpleGrantedAuthority(role));
//        }

        UserDetails userDetails = new CustomUserDetails(sysUser.getUserId(), sysUser.getUserName(),
                sysUser.getPasswordEncrypted(), true, true, true, true, authorities) {
        };
        return userDetails;
    }
}
