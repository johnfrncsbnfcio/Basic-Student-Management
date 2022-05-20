/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sms.student.controller;

/**
 *
 * @author Bilog
 */

import java.util.List;
import sms.student.model.StudentData;

public interface StudentInterface {

	public void saveStudent(StudentData student);
	public void updatestudent(StudentData student);
	public void deleteStudent(StudentData student);
	public StudentData getStudentId(int id);
	public List<StudentData> studentList();
	
	
}
