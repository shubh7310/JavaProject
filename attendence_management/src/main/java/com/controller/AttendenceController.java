package com.controller;


import com.service.AttedenceService;
import com.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/attendence")
@CrossOrigin(value="*")
public class AttendenceController {

@Autowired
private AttedenceService attedenceService;


    @GetMapping(value="/createAttendece")
    public ResponseEntity createAttendece(@RequestParam Long studentId){
        String response=attedenceService.createAttendence(studentId);
        return new ResponseEntity(JsonUtils.getSuccesJsonWithMessage(response), HttpStatus.OK);
    }




    @GetMapping(value="/getAttendeceByStudentId")
    public ResponseEntity getAttendece(@RequestParam Long studentId){
        return new ResponseEntity(JsonUtils.getSuccesJson(attedenceService.getAttedence(studentId)), HttpStatus.OK);
    }



}
