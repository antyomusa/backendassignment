package com.anton.tugasbackend.service;

import com.anton.tugasbackend.model.UserModel;
import com.anton.tugasbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirstService {

    private UserRepository userRepository;

    public FirstService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUser(){
        return userRepository.findAll();
    }

    public UserModel getUser(int personId){
        Optional<UserModel> userOpt = userRepository.findById(personId);
        if(userOpt.isEmpty()){
            return null;
        } else {
            return userOpt.get();
        }
    }

//    public UserModel loginUser(String email, String password){
//        List<UserModel> userOpt = userRepository.getUsers(email, password);
//        if(userOpt.isEmpty()){
//            return null;
//        } else {
//            return userOpt.get('1');
//        }
//    }

    public UserModel getUsers(String email, String password){
        return userRepository.getUsers(email, password);
    }

}
