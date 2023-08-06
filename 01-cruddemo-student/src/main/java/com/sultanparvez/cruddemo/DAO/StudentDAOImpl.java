package com.sultanparvez.cruddemo.DAO;

import com.sultanparvez.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class StudentDAOImpl implements StudentDAO{
    //Define Field For entity manger
    private EntityManager entityManger;

    //Inject Entity Manager
    @Autowired
    public StudentDAOImpl(EntityManager entityManger) {
        this.entityManger = entityManger;
    }

    //implement Save Method
    @Override
    @Transactional
    public void Save(Student theStudent) {
        entityManger.persist(theStudent);

    }


}
