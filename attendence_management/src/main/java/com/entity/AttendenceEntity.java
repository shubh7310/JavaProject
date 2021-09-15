package com.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendence_entity")
public class AttendenceEntity {

    @Id // primary key // 1,1 // constraint Voilation
    @GeneratedValue(strategy = GenerationType.AUTO)  // 1,2,3,4 Auto increment
    private Long id;   // primary key


   @Column(name = "student_id")
    private Long studentId;

    private Boolean isPresent;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    private Boolean isBlock;


    public AttendenceEntity(Long id, Long studentId, Boolean isPresent, LocalDateTime createdTime, Boolean isBlock) {
        this.id = id;
        this.studentId = studentId;
        this.isPresent = isPresent;
        this.createdTime = createdTime;
        this.isBlock = isBlock;
    }

    public AttendenceEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getBlock() {
        return isBlock;
    }

    public void setBlock(Boolean block) {
        isBlock = block;
    }
}
