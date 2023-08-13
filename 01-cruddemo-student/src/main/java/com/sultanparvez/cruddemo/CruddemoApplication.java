package com.sultanparvez.cruddemo;

import com.sultanparvez.cruddemo.DAO.StudentDAO;
import com.sultanparvez.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner ->{
			//Create
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			// Read
//			readStudent(studentDAO);
//			findAllStudent(studentDAO);
//			findStudentByLastName(studentDAO);
//			//Update
//			updateStudent(studentDAO);
			//Delete
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//Before deleting
		System.out.println(" Before Delete -- > ");
		List <Student> theStudents = studentDAO.findAll();
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

		//delete
		int std_id=1;
		studentDAO.delete(std_id);
		//Display
		//After deleting
		System.out.println(" Before Delete -- > ");
		List <Student> allStudents = studentDAO.findAll();
		for (Student tempStudent : allStudents){
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id

		int studentId=7;
		System.out.println("Retrieving ---- >>>");
		Student myStudent =	studentDAO.findById(studentId);
		System.out.println(myStudent);

		// Change First Name
		myStudent.setFirstName("Sultan");

		// update Student
		studentDAO.update(myStudent);
		//display
		System.out.println("Updated ---- >>> " + myStudent );


	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		System.out.println("Find Student By Last Name --->");
		//get Student
		List <Student> tempStudents = studentDAO.findByLastName("Fang");

		//display
		for (Student tempStudent : tempStudents){
			System.out.println(tempStudent);
		}

	}

	private void findAllStudent(StudentDAO studentDAO) {
		// get a list of student
		List <Student> theStudents = studentDAO.findAll();

		//display
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		Student anotherStudent = new Student("p0wer", "Fang","parvez@gmail.com");
		studentDAO.Save(anotherStudent);
		int std_id = anotherStudent.getId();
		//retrieve student based on id
		Student displayStudent = studentDAO.findById(std_id);

		//Display Students
		System.out.println("The student info is - " + displayStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating three Student Profile");
		Student tempStudent1 = new Student("Fahim", "Dipto","parvez@gmail.com");
		Student tempStudent2 = new Student("Parvez", "Fahim","parvez1@gmail.com");
		Student tempStudent3 = new Student("Oishee", "Zaman","parvez2@gmail.com");

		//save profiles
		System.out.println("Saving profiles");
		studentDAO.Save(tempStudent1);
		studentDAO.Save(tempStudent2);
		studentDAO.Save(tempStudent3);

	}

	;
	private void createStudent(StudentDAO studentDAO){

		//create the student object
		System.out.println("Creating Student Profile");
		Student tempStudent = new Student("Fahim", "Dipto","parvez@gmail.com");
		//save the object
		System.out.println("Saving student profile");
		studentDAO.Save(tempStudent);

		//display
		System.out.println("Student profile saved - " + tempStudent.getId());


	}
}



