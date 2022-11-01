package com.anton.tugasbackend.controller;

import com.anton.tugasbackend.model.UserModel;
import com.anton.tugasbackend.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v2/user")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public String registerUser(@RequestParam("name") String name,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                               @RequestParam("phone") String phone){
        if(registerService.registerUser(name,password,email,phone)){
            return "Register sukses";
        } else {
            return "register gagal, email sudah tersedia";
        }
    }

}
