package edu.tdt.service;

import edu.tdt.entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author HAU
 */
@Remote
public interface SystemStudentManagementRemote {
    //FOR GUESTS
    void addNotification(String header, Date posting_date);
    List<Notification> getNotifications();
    List<Object[]> getCourses();
    void receiveRequest(Request request, String idAdmin);
    
    //FOR STUDENTS
    List<Object[]> getIDRooms();
    ArrayList<String> searchListStudentByClass(String roomID);
    String getNameCourse(String roomID);
    String getNameTeacher(String roomID);
    List<Object[]> searchScoreByIDStudent(String idStudent);
    boolean findStudentByID(String idStudent);
    Object[] findStudentName(String username);
    Object[] findStudent(String username);
    
    //FOR ADMINS
    Object[] findAdminName(String username);
    
    void insertStudent(Student student);
    List<Object[]> getAllStudents();
    List<Object[]> getAllStudents(String nameStudent);
    void updateStudent(Student student);
    
    List<Object[]> searchScoreByIDClass(String idClass);
    void updateScore(String idStudent, String idRoom, String result1, String result2, String result3, String test1, String test2);
    void insertScore(String idStudent, String idRoom, String result1, String result2, String result3, String test1, String test2);
    
    List<Object[]> getAllRequests(String idAdmin);
    void updateRequest(String status, String id);
    
    void insertTeacher(Teacher teacher);
    List<Object[]> getAllTeachers();
    void updateTeacher(Teacher teacher);
    
    void insertCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(String idCourse);
    void assignCourseForStudent(String idStudent, String idCourse);
    ArrayList<String> getListCoursesRegistered();
    ArrayList<String> getListCoursesRegistered(String idStudent);
    
    void insertRoom(Room room, String idCourse, String idTeacher);
    void updateRoom(Room room, String idCourse, String idTeacher);
    Object[] getRoomByID(String idRoom);
}
