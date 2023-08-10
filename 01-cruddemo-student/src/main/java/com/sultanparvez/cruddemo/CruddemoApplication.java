package com.sultanparvez.cruddemo;

import com.sultanparvez.cruddemo.DAO.StudentDAO;
import com.sultanparvez.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			readStudent(studentDAO);
		};
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



