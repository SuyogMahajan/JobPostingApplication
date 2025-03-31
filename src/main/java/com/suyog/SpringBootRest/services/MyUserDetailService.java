package com.suyog.SpringBootRest.services;

import com.suyog.SpringBootRest.models.DTO.UserDTO;
import com.suyog.SpringBootRest.models.authentication_models.User;
import com.suyog.SpringBootRest.models.authentication_models.UserPricipl;
import com.suyog.SpringBootRest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ApplicationContext context;

    public boolean isUserNameAvailable(String userName) {
        User user = userRepo.findByUserName(userName);
        return user == null;
    }

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

    public User signUp(UserDTO userDTO) {
        User user = userDTO.userBuilder();
        user.setPassword(context.getBean(BCryptPasswordEncoder.class).encode(userDTO.getPassword()));
        return userRepo.save(user);
    }

}
