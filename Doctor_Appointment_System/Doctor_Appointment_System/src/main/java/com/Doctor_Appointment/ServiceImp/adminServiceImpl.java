package com.Doctor_Appointment.ServiceImp;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Doctor_Appointment.Model.Admin;
import com.Doctor_Appointment.Repository.AdminRepository;
import com.Doctor_Appointment.Services.AdminServices;

@Component
public class adminServiceImpl implements AdminServices{

    @Autowired
    private AdminRepository adminRepo;

    public Admin createAdmin(Admin user) {
        Admin local = adminRepo.findByUsername(user.getUsername());
        if(local!=null) {
            System.out.println("User is already registered");
        }else {
            return this.adminRepo.save(user);
        }
        return null;
    }

    public Admin updateAdmin(Admin user) {
        return this.adminRepo.save(user);
    }

    public Admin getUser(String username) {
        return this.adminRepo.findByUsername(username);
    }

    @Override
    public Set<Admin> getAllAdmin() {
        return new LinkedHashSet<>(this.adminRepo.findAll());
    }




}