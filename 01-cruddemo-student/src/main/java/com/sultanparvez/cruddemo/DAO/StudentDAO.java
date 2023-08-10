package com.sultanparvez.cruddemo.DAO;

import com.sultanparvez.cruddemo.entity.Student;

public interface StudentDAO {
    void Save (Student theStudent);

    Student findById(Integer id);
}
