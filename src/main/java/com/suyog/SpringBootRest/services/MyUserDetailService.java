package com.suyog.SpringBootRest.services;

import com.suyog.SpringBootRest.models.User;
import com.suyog.SpringBootRest.models.UserPricipl;
import com.suyog.SpringBootRest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("here");
        User user = userRepo.findByUserName(username);
        System.out.println(user);
        if(user == null) {
            System.out.println("not found");
            throw new UsernameNotFoundException("Not Found");
        }else{
            System.out.println(user);
            return new UserPricipl(user);
        }
    }
}
