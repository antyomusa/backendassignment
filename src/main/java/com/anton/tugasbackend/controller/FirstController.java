package com.anton.tugasbackend.controller;

import com.anton.tugasbackend.service.FirstService;
import com.anton.tugasbackend.model.UserModel;
import com.anton.tugasbackend.utils.response.DataResponse;
import com.anton.tugasbackend.utils.response.HandlerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v2/tugas")
public class FirstController {

    @Autowired
    private FirstService firstService;

    @GetMapping("/users")
    public List<UserModel> getAllUser(){
        return firstService.getAllUser();
    }

    @GetMapping("/user/{userId}")
    public void getUser(HttpServletRequest request, HttpServletResponse response,
                        @PathVariable int userId){
        UserModel user = firstService.getUser(userId);
        if (user == null){
            HandlerResponse.responseBadRequest(response, "02", "User not found");
        } else {
            DataResponse<UserModel> data = new DataResponse<>();
            data.setData(user);
            HandlerResponse.responseSuccessWithData(response, data);
        }
    }

//    @GetMapping("/login")
//    public UserModel getPersonParam(@RequestParam("email") String email,
//                                    @RequestParam("password") String password){
//        UserModel person = firstService.loginUser(email,password);
//        if (person == null){
//            return new UserModel();
//        } else {
//            return person;
//        }
//    }

//    @GetMapping("/login")
//    public List<UserModel> getUsers(@RequestParam("email") String email,
//                                    @RequestParam("password") String password){
//       return firstService.getUsers(email, password);

        @GetMapping("/login")
        public void getUsers(HttpServletRequest request, HttpServletResponse response,
                @RequestParam("email") String email,
                @RequestParam("password") String password){
            UserModel user = firstService.getUsers(email, password);
            if (user == null) {
//                return "Your Email or Password is incorrect";
                HandlerResponse.responseBadRequest(response, "02", "Your Email or Password is incorrect");
            } else {
//                return "Login Success";
                HandlerResponse.responseSuccessOK(response, "Login Success");
            }

//        if(firstService.getUsers(email,password)){
//            return "Sukses register";
//        } else {
//            return "register gagal";
//        }
    }
}
