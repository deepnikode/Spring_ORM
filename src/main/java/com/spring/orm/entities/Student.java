package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.DocFlavor.STRING;


@Entity
@Table(name="student_details")
public class Student {
	
	
	//By using column we are changing the column name/label of column...
		@Id
		@Column(name="student_id")
		private int id;
		
		@Column(name="student_name")
		private String studentName;
		
		@Column(name="student_city")
		private String studenCity;

		
		
		
		



		public Student(int id, String studentName, String studenCity) {
			super();
			this.id = id;
			this.studentName = studentName;
			this.studenCity = studenCity;
		}
		
		

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getStudenCity() {
			return studenCity;
		}

		public void setStudenCity(String studenCity) {
			this.studenCity = studenCity;
		}
		
		
		
}
