package com.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "student")
public class StudentEntity  {

   @Id // primary key // 1,1 // constraint Voilation
   @GeneratedValue(strategy = GenerationType.AUTO)  // 1,2,3,4 Auto increment
   private Long id;   // primary key


   private String name;

   private Integer phoneNumber;

//   @Id
   private String email;


   private String password;


   private String role;



   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "student_id")
   private List<AdressEntity> adressEntity;

   public List<AdressEntity> getAdressEntity() {
      return adressEntity;
   }

   public void setAdressEntity(List<AdressEntity> adressEntity) {
      this.adressEntity = adressEntity;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public StudentEntity(String name, Integer phoneNumber, String email, String password, List<AdressEntity> adressEntity) {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.password = password;
      this.adressEntity = adressEntity;
   }

   public StudentEntity() {
   }



   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(Integer phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}















// hibernate_sequence-> 1,2,3,4,5,6,7,8,9,
// dusre database me ye same id exist kr sakti hai leking same database me kisi dusre table me nahi kregi

