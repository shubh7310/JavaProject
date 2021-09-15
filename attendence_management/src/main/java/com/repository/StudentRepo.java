package com.repository;


import com.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo   extends CrudRepository<StudentEntity,Long> {



   @Query(value="select * from student where email= :email",nativeQuery = true)
   StudentEntity findByEmailID(String email);


}
