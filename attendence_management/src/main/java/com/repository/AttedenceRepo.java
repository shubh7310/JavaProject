package com.repository;

import com.entity.AttendenceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttedenceRepo extends CrudRepository<AttendenceEntity,Long> {



   @Query(value = "select * from attendence_entity where student_id= :studentID ",nativeQuery = true)
   List<AttendenceEntity> findAttedenceByID(Long studentID);


   @Query(value="select * from attendence_entity where  created_time like :localDate%",nativeQuery = true)
   List<AttendenceEntity> findAttendenceByDate(LocalDate localDate);
}
