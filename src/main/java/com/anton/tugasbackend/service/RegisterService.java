package com.anton.tugasbackend.service;

import com.anton.tugasbackend.dto.UserDto;
import com.anton.tugasbackend.model.UserModel;
import com.anton.tugasbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(String name, String password, String email, String phone) {
        UserModel user = userRepository.findByEmail(email);
        if (user != null) {
            return false;
        } else {
            UserModel userModel = new UserModel();
            userModel.setName(name);
            userModel.setPassword(password);
            userModel.setEmail(email);
            userModel.setPhone(phone);
            userRepository.save(userModel);
            return true;
        }

//    private UserDto convertUser(UserModel userModel){
//        UserDto userDto = new UserDto();
//        userDto.setName(userModel.getName());
//        userDto.setPassword(userModel.getPassword());
//        userDto.setEmail(userModel.getPassword());
//        userDto.setPhone(userModel.getPhone());
//        return userDto;
//    }
    }
}
