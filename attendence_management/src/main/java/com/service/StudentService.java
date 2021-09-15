package com.service;


import com.dto.AddressDTO;
import com.dto.StudentDTO;
import com.entity.AdressEntity;
import com.entity.StudentEntity;
import com.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service  // to make class as service
public class StudentService {

    // Spring container

    @Autowired
    private StudentRepo studentRepo;


    public List<StudentEntity>  getStudents(){
       return  (List<StudentEntity>)studentRepo.findAll(); /// student table ke saare record
    }



    public StudentEntity  getStudentByID(String emailId){
       return studentRepo.findByEmailID(emailId);

         /// student table me search 45
    }

    @Autowired
    PasswordEncoder passwordEncoder;



    public void createStudent(StudentDTO studentDTO){
        String encryptedPassword=passwordEncoder.encode(studentDTO.getPassword());

         List<AdressEntity> adressEntities=new ArrayList<>();
       //
        if(studentDTO.getAddressDTOS() != null && studentDTO.getAddressDTOS().size() >0 ){
            for(AddressDTO  addressDTO:studentDTO.getAddressDTOS()){
             AdressEntity adressEntity=new AdressEntity(addressDTO.getDistict(),addressDTO.getState(),addressDTO.getCountry(),addressDTO.getPinCode());
             adressEntities.add(adressEntity);

            }

        }


        if(studentDTO.getId() != null){
            // update
          StudentEntity studentEntity= studentRepo.findById(studentDTO.getId()).get();
          studentEntity.setEmail(studentDTO.getEmailId());
          studentEntity.setPhoneNumber(studentDTO.getPhoneNumber());
          studentEntity.setName(studentDTO.getName());
          studentEntity.setAdressEntity(adressEntities);
          studentRepo.save(studentEntity);
        }else{
            // create
            StudentEntity studentEntity=new StudentEntity(studentDTO.getName(),studentDTO.getPhoneNumber(),studentDTO.getEmailId(),encryptedPassword,adressEntities);
            studentRepo.save(studentEntity);
        }

    }




    public  void deleteStudent(Long id){
        studentRepo.deleteById(id);
    }





//    public List<StudentDTO>  getStudents() {
//        StudentDTO studentDTO=new StudentDTO();
//        studentDTO.setName("Rajesh");
//        studentDTO.setPhoneNumber(98765432);
//        studentDTO.setEmailId("sdbjkshfkjs");
//        List<StudentDTO> studentDTOS=new ArrayList<>();
//        studentDTOS.add(studentDTO);
//        return new ArrayList<>();
//    }

}
