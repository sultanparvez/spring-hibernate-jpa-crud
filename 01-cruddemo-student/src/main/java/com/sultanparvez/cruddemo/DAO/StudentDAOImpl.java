package com.sultanparvez.cruddemo.DAO;

import com.sultanparvez.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Override
    public Student findById(Integer id) {
      return  entityManger.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create Query
//        TypedQuery <Student> theQuery = entityManger.createQuery("FROM Student order by lastName desc", Student.class);
        TypedQuery <Student> theQuery = entityManger.createQuery("FROM Student", Student.class);
//        TypedQuery <Student> theQuery = entityManger.createQuery("FROM Student order by lastName", Student.class);
        // Return Result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // Create Query

        TypedQuery <Student> theStudent = entityManger.createQuery("FROM Student where lastName=:theData" , Student.class);

        // Set Parameter

        theStudent.setParameter("theData", theLastName);

        // return

        return theStudent.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManger.merge(theStudent);

    }




}
