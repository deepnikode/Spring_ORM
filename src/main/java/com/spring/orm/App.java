package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
			
		
		  
		  
		 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean flag = true;

		while (flag) {
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");
			System.out.println("4");
			System.out.println("5");
			System.out.println("6");

			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {

				case 1:
					         // add
					
					// taking input
					System.out.println("Enter ID");
					int uId=Integer.parseInt(br.readLine());
					System.out.println("Enter Name");
					String uName=br.readLine();
					System.out.println("Enter Address");
					String uAddress=br.readLine();
					
					//creating object and setting values
					Student s= new Student();
					s.setId(uId);
					s.setStudentName(uName);
					s.setStudenCity(uAddress);
					
					//saving student object to DB by calling insert method
					int r=studentDao.insert(s);
					System.out.println("done"+r);
					System.out.println("Student added successfully");
					System.out.println("____________________________");
					System.out.println();
					break;
					
				case 2:
					// display
					System.out.println("____________________________");

					List<Student> allStudents=studentDao.getAllStudents();
					for(Student st:allStudents)
					{
						System.out.println("ID:" +st.getId());
						System.out.println("Name:" +st.getStudentName());
						System.out.println("Address:" +st.getStudenCity());
						System.out.println("____________________________");
					}
					break;
					
				case 3:
					// get (single)
					
					// taking input
					System.out.println("Enter ID");
					int userId=Integer.parseInt(br.readLine());
					Student student=studentDao.getStudent(userId);
					
					System.out.println("ID: "+student.getId());
					System.out.println("ID: "+student.getStudentName());
					System.out.println("ID: "+student.getStudenCity());
					System.out.println("____________________________");

					break;
					
				case 4:
					// delete
					
					System.out.println("Enter ID");
					int id=Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Student deleted");
					System.out.println("____________________________");

					break;
				case 5:
					// update
					System.out.println("____________________________");
					System.out.println("Enter ID in which you have to make updates");
					int updt_id=Integer.parseInt(br.readLine());
					Student update_student=studentDao.getStudent(updt_id);
					
					System.out.println("Enter new details for the student:");
					System.out.println("Enter Name");
					String updt_Name=br.readLine();
					System.out.println("Enter Address");
					String updt_Address=br.readLine();
						
					Student s_updt=new Student();
					s_updt.setStudentName(updt_Name);
					s_updt.setStudenCity(updt_Address);
						
					studentDao.updateStudent(s_updt); 
					    
					
					System.out.println("Updated Successfully");
					  
					System.out.println("____________________________");
					 

					break;
				case 6:
					// exit
					flag = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid Input");
				System.out.println(e.getMessage());

			}

		}

		System.out.println("Thankyou");

	}
}
