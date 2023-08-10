package com.sultanparvez.cruddemo.DAO;

import com.sultanparvez.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void Save (Student theStudent);

    Student findById(Integer id);

    List <Student> findAll();

    List <Student> findByLastName(String theLastName);
}
