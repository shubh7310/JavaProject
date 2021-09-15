package com.controller;


import com.entity.StudentEntity;
import com.repository.StudentRepo;
import com.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class StudentAuthenticationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  StudentRepo studentRepo;
    //ResponseEntity

    @GetMapping(value="/login")
    public  ResponseEntity authenticateStudent(@RequestParam String email, @RequestParam String password){

         StudentEntity studentEntity= studentRepo.findByEmailID(email);
        if(studentEntity != null){
            if(passwordEncoder.matches(password,studentEntity.getPassword())){
                return new ResponseEntity(JsonUtils.getSuccesJsonWithMessage("Sucessfully Login"), HttpStatus.OK);


            }else{
                return new ResponseEntity(JsonUtils.getUnSuccesJson("Please enter Correct Paswword "), HttpStatus.UNAUTHORIZED);
            }

        } else{
            return new ResponseEntity(JsonUtils.getUnSuccesJson("Please enter Valid email"), HttpStatus.UNAUTHORIZED);
        }
    }







    @GetMapping(value="/updatePassword")
    public  String updatePassword(@RequestParam String email, @RequestParam String newPassword,@RequestParam String confirmPassword){

        if(newPassword.equals(confirmPassword)){
            StudentEntity studentEntity= studentRepo.findByEmailID(email);
            if(studentEntity != null){
                studentEntity.setPassword(passwordEncoder.encode(newPassword));
                studentRepo.save(studentEntity);
                return "SucessFully Updated";
            } else{
                return "Please enter Valid email";
            }
        }else{
            return "Password Does Not Match";
        }

    }



}
