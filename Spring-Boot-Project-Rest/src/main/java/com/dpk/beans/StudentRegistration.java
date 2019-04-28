package com.dpk.beans;
import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {
	
	private List<Student> studentRecords;
	
	private static StudentRegistration stdreg=null;
	
	public static StudentRegistration getInstance()
	{
		if(stdreg==null)
		{
			stdreg = new StudentRegistration();
			return stdreg;
		}else {
			return stdreg;
		}
	}
	
	private StudentRegistration()
	{
		studentRecords = new ArrayList<Student>();
	}
	
	public void add(Student student)
	{
		studentRecords.add(student);
	}
	
	public String updateStudent(Student student)
	{
		for(int i=0;i<studentRecords.size();i++)
		{
			Student student2=studentRecords.get(i);
			if(student2.getRegistrationNumber().equals(student.getRegistrationNumber()))
			{
				studentRecords.set(i, student);
				return "update success";
			}
		}
		return "update Un-success";
	}
	public String deleteStudent(String regNumber)
	{
		for(int i=0;i<studentRecords.size();i++)
		{
			if(studentRecords.get(i).getRegistrationNumber().equals(regNumber))
			{
				studentRecords.remove(i);
				return "delete success";
			}
		}
		return "delete Un-SUccess";
	}
	public List<Student> getStudenetRecords()
	{
		return studentRecords;
	}
}
