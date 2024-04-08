package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
		
	private HibernateTemplate hibernateTemplate;
	
	
		public HibernateTemplate getHibernateTemplate() 
		{
			return hibernateTemplate;
		}
	
	
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) 
		{
			this.hibernateTemplate = hibernateTemplate;
		}

	
	// C R U D Operations..
	
	
	//apply @Transactional operations only on update, insert, delete...
	
		//Insert Student
		@Transactional
		public int insert(Student student) {
			// TODO Auto-generated method stub
			Integer i=(Integer)this.hibernateTemplate.save(student);
			return i;
		}
	
		//Delete Student
		@Transactional
		public void deleteStudent(int studentId)
		{
			Student student=this.hibernateTemplate.get(Student.class, studentId);
			this.hibernateTemplate.delete(student);
		}
		
		//Update Student
		@Transactional
		public void updateStudent(Student student)
		{
			this.hibernateTemplate.update(student);
		}

		
	//Get single student data
	public Student getStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;	
	}
	
	//get all students(all rows)
	public List<Student> getAllStudents()
	{
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	
}
