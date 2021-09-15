package com.service;


import com.entity.AttendenceEntity;
import com.entity.StudentEntity;
import com.repository.AttedenceRepo;
import com.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttedenceService {

    @Autowired
    private AttedenceRepo attedenceRepo;

    @Autowired
    private StudentRepo studentRepo;


    public   String  createAttendence(Long studentId){
        AttendenceEntity attendenceEntity=new AttendenceEntity();
        attendenceEntity.setBlock(true);
        attendenceEntity.setCreatedTime(LocalDateTime.now());
        attendenceEntity.setPresent(true);
        attendenceEntity.setStudentId(studentId);

        attedenceRepo.save(attendenceEntity);
        return "Attendece Loggged SucessFully";
    }



    public List<AttendenceEntity> getAttedence(Long studentId){
       return attedenceRepo.findAttedenceByID(studentId);
    }



    @Scheduled(cron ="0 0 10 * *")
    public void   autoAttedence(){
        LocalDate currentDate=LocalDate.now();
      List<StudentEntity> studentEntities=(List<StudentEntity>) studentRepo.findAll();

      List<AttendenceEntity> attendenceEntities=  attedenceRepo.findAttendenceByDate(currentDate);    /// aaj ki dat eki sare attendecne chiye mughe

        for(StudentEntity studentEntity:studentEntities){
            for(AttendenceEntity attendenceEntity:attendenceEntities){
                if(!studentEntity.getId().equals(attendenceEntity.getStudentId())){
                    AttendenceEntity attendenceEntity1=new AttendenceEntity();
                    attendenceEntity.setBlock(true);
                    attendenceEntity.setCreatedTime(LocalDateTime.now());
                    attendenceEntity.setPresent(false);
                    attendenceEntity.setStudentId(studentEntity.getId());
                    attedenceRepo.save(attendenceEntity);
                }

            }

        }


    }




}
