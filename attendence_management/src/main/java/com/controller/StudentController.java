package com.controller;


import com.dto.StudentDTO;
import com.entity.StudentEntity;
import com.service.EmailService;
import com.service.StudentService;
import com.utils.JsonUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(value = "*")
@Api(value = "Student Controller Test", description = "Perform Student Curd")
@RestController  // annotation
public class StudentController {
    //dto -> data transfer object (UI)

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmailService emailService;




    @GetMapping(value="/getStudent")   // get type ki reuqest ki mapping define kr rha hu
    public ResponseEntity getStudentById(@RequestParam String emailID ){

        return new ResponseEntity(JsonUtils.getSuccesJson(studentService.getStudentByID(emailID)),HttpStatus.OK);
    }

    @GetMapping(value="/getStudents")
    public ResponseEntity getAllStudents(){
       try {



           List<StudentEntity> studentEntities=studentService.getStudents();
         return   new ResponseEntity(JsonUtils.getSuccesJson(studentEntities),HttpStatus.OK);

       }catch (Exception e){
         return   new ResponseEntity(JsonUtils.getUnSuccesJson(e.getMessage()),HttpStatus.PRECONDITION_FAILED);
       }

    }




    @PostMapping(value="/createOrUpdateStudent")
    public  ResponseEntity createStudents(@RequestBody StudentDTO studentDTO){
        studentService.createStudent(studentDTO);
        return   new ResponseEntity(JsonUtils.getSuccesJsonWithMessage("SucessFully Created"),HttpStatus.OK);
    }



    @DeleteMapping(value="/deleteStudent")
    public  String deleteStudents(@RequestParam Long id){
        studentService.deleteStudent(id);
        return "Sucessfully Deleted";
    }





    // Get APi // read
    // Post Api and update Api // create and update
    // Delete Api  // delete


    @GetMapping(value="/sendEmail")
    public  String sendEmail(@RequestParam String to,@RequestParam String subject,@RequestParam String text){

        return emailService.sendSimpleMessage(to,subject,text);
    }





}
