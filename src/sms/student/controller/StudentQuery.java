/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.student.controller;

/**
 *
 * @author Bilog
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sms.student.database.Database;

import sms.student.model.StudentData;
import sms.student.resources.Prompt;

public class StudentQuery implements StudentInterface {

    @Override
    public void saveStudent(StudentData student) {
        try {
            Connection con = Database.getConnection();
            String sql = "INSERT INTO student_table(firstname, middlename, lastname, "
                    + "birthday, gender, nationality, civil, "
                    + "address, contact, email, schedule, activityScore, individualScore, groupScore, attendance) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, student.getFirstname());
            pst.setString(2, student.getMiddlename());
            pst.setString(3, student.getLastname());
            pst.setString(4, student.getBirthday());
            pst.setString(5, student.getGender());
            pst.setString(6, student.getNationality());
            pst.setString(7, student.getCivil());
            pst.setString(8, student.getAddress());
            pst.setInt(9, student.getContact());
            pst.setString(10, student.getEmail());
            pst.setString(11, student.getSchedule());
            pst.setInt(12, student.getActivityScore());
            pst.setInt(13, student.getIndividualScore());
            pst.setInt(14, student.getGroupScore());
            pst.setString(15, student.getAttendanceInfo());
            pst.executeUpdate();
            Prompt.showMessage("OK", "Student Added Successfully.");
        } catch (Exception e) {
            Prompt.showMessage("ERROR", "Insertion Failed. Something went wrong. Contact your System Developer.");
        }
    }

    @Override
    public void updatestudent(StudentData student) {
        try {
            Connection con = Database.getConnection();
            String sql = "UPDATE student_table SET firstname = ?, middlename = ?, lastname = ?,"
                    + " birthday = ?, gender = ?, nationality = ?, civil = ?, address = ?, contact = ?,"
                    + " email = ?, schedule = ?, activityScore = ?, individualScore = ?, groupScore = ?,"
                    + " attendance = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, student.getFirstname());
            pst.setString(2, student.getMiddlename());
            pst.setString(3, student.getLastname());
            pst.setString(4, student.getBirthday());
            pst.setString(5, student.getGender());
            pst.setString(6, student.getNationality());
            pst.setString(7, student.getCivil());
            pst.setString(8, student.getAddress());
            pst.setInt(9, student.getContact());
            pst.setString(10, student.getEmail());
            pst.setString(11, student.getSchedule());
            pst.setInt(12, student.getActivityScore());
            pst.setInt(13, student.getIndividualScore());
            pst.setInt(14, student.getGroupScore());
            pst.setString(15, student.getAttendanceInfo());
            pst.setInt(16, student.getStudent_id());
            int count = pst.executeUpdate();
            if (count > 0) {
                Prompt.showMessage("OK", "Updated Successfully.");
            } else {
                Prompt.showMessage("ERROR", "Update Failed.");
            }

        } catch (Exception e) {
            Prompt.showMessage("ERROR", "Update failed. Something went wrong. Contact your System Developer.");
        }

    }

    @Override
    public void deleteStudent(StudentData student) {
        // TODO Auto-generated method stub

    }

    @Override
    public StudentData getStudentId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<StudentData> studentList() {
        List<StudentData> studentList = new ArrayList<StudentData>();
        try {
            Connection con = Database.getConnection();
            String sql = "select * from student_table";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                StudentData s = new StudentData();
                s.setStudent_id(rs.getInt("id"));
                s.setLastname(rs.getString("lastname"));
                s.setFirstname(rs.getString("firstname"));
                s.setMiddlename(rs.getString("middlename"));
                s.setAddress(rs.getString("address"));
                s.setCivil(rs.getString("civil"));
                s.setBirthday(rs.getString("birthday"));
                s.setNationality(rs.getString("nationality"));
                s.setContact(rs.getInt("contact"));
                s.setEmail(rs.getString("email"));
                s.setGender(rs.getString("gender"));
                s.setSchedule(rs.getString("schedule"));
                s.setActivityScore(Integer.parseInt(rs.getString("activityScore")));
                s.setIndividualScore(Integer.parseInt(rs.getString("individualScore")));
                s.setGroupScore(Integer.parseInt(rs.getString("groupScore")));
                s.setAttendanceInfo(rs.getString("attendance"));

                studentList.add(s);
            }
        } catch (Exception e) {
            Prompt.showMessage("ERROR", "Fetch failed. Something went wrong. Contact your System Developer.");
        }
        return studentList;

    }

}
