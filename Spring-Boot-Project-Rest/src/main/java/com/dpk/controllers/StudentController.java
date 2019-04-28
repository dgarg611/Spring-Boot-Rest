package com.dpk.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpk.beans.Student;
import com.dpk.beans.StudentRegistration;
import com.dpk.beans.StudentRegistrationReply;

@Controller
public class StudentController {

	@RequestMapping(method = RequestMethod.GET, value = "/student/allstudent")
	@ResponseBody
	public List<Student> getAllStudents() {
		return StudentRegistration.getInstance().getStudenetRecords();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register/student")
	@ResponseBody
	public StudentRegistrationReply registerStudent(@RequestBody Student student) {
		System.out.println("In registerStudent");
		StudentRegistrationReply stdregreply=new StudentRegistrationReply();
		StudentRegistration.getInstance().add(student);
		
		stdregreply.setId(student.getId());
		stdregreply.setName(student.getName());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
		stdregreply.setRegistrationStatus("successfull");
		
		return stdregreply;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/student")
	@ResponseBody
	public String studentUpdate(@RequestBody Student std)
	{
		System.out.println("In updateStudentRecord");   
		return StudentRegistration.getInstance().updateStudent(std);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/student/{regNum}")
	@ResponseBody
	public String studentDelete(@PathVariable("regNum") String regNumber)
	{
		System.out.println("In deleteStudentRecord");
		return StudentRegistration.getInstance().deleteStudent(regNumber);
	}
}
