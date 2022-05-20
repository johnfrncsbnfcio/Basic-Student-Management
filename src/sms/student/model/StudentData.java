/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.student.model;

/**
 *
 * @author Bilog
 */

public class StudentData {

    private int student_id;
    private String firstname;
    private String middlename;
    private String lastname;

    private String address;
    private int contact;
    private String nationality;
    private String civil;

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCivil() {
        return civil;
    }

    public void setCivil(String civil) {
        this.civil = civil;
    }
    private String email;

    private String birthday;
    private String gender;

    private String schedule;

    private int activityScore;
    private int individualScore;
    private int groupScore;
    private String attendanceInfo;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getActivityScore() {
        return activityScore;
    }

    public void setActivityScore(int activityScore) {
        this.activityScore = activityScore;
    }

    public int getIndividualScore() {
        return individualScore;
    }

    public void setIndividualScore(int individualScore) {
        this.individualScore = individualScore;
    }

    public int getGroupScore() {
        return groupScore;
    }

    public void setGroupScore(int groupScore) {
        this.groupScore = groupScore;
    }

    public String getAttendanceInfo() {
        return attendanceInfo;
    }

    public void setAttendanceInfo(String attendanceInfo) {
        this.attendanceInfo = attendanceInfo;
    }

}
