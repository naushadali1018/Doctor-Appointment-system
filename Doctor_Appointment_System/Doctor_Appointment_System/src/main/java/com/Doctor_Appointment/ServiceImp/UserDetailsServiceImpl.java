package com.Doctor_Appointment.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Doctor_Appointment.Model.Admin;
import com.Doctor_Appointment.Model.User;
import com.Doctor_Appointment.Repository.AdminRepository;
import com.Doctor_Appointment.Repository.userRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private userRepository userRepo;

    @Autowired
    private AdminRepository adminRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepo.findByUsername(username);
        Admin admin = this.adminRepo.findByUsername(username);

        if (user == null && admin==null) {
            System.out.print("User Not Found");
            throw new UsernameNotFoundException("User is not Available");
        }else if(user!=null && admin==null) return user;
        else if(user==null && admin!=null) return admin;

        return user;

    }


}
