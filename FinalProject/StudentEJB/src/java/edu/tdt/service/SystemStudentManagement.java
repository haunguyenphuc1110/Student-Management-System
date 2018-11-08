package edu.tdt.service;

import edu.tdt.entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HAU
 */
@Stateless
public class SystemStudentManagement implements SystemStudentManagementRemote {

    @PersistenceContext(unitName = "StudentEJBPU")
    private EntityManager entityManager;

    //--------------------------FOR GUEST-------------------------------
    @Override
    public void addNotification(String header, Date posting_date) {
        Notification notification = new Notification(header, posting_date);
        entityManager.persist(notification);
    }

    @Override
    public List<Notification> getNotifications() {
        return entityManager.createNamedQuery("Notification.findAll").getResultList();
    }

    @Override
    public void receiveRequest(Request request, String idAdmin) {
        String query = "INSERT INTO request(id, guestname, parentname, email, birthday, address, phone, course, information, datecreated, status, \"id_Admin\") "
                + "VALUES (:id , :guestname, :parentname, :email, :birthday, :address, :phone, :course, :info, :datecreated, :status, :idAdmin)";
        entityManager.createNativeQuery(query).setParameter("id", request.getId())
                .setParameter("guestname", request.getGuestname())
                .setParameter("parentname", request.getParentname())
                .setParameter("email", request.getEmail())
                .setParameter("birthday", request.getBirthday())
                .setParameter("address", request.getAddress())
                .setParameter("phone", request.getPhone())
                .setParameter("course", request.getCourse())
                .setParameter("info", request.getInformation())
                .setParameter("datecreated", request.getDatecreated())
                .setParameter("status", request.getStatus())
                .setParameter("idAdmin", idAdmin).executeUpdate();
    }

    @Override
    public List<Object[]> getCourses() {
        List<Object[]> courses = entityManager.createNativeQuery("SELECT * FROM course").getResultList();
        return courses;
    }

    //-------------------------------------FOR STUDENT----------------------------------------
    @Override
    public List<Object[]> getIDRooms() {
        List<Object[]> rooms = entityManager.createNativeQuery("SELECT * FROM room").getResultList();
        return rooms;
    }

    @Override
    public ArrayList<String> searchListStudentByClass(String roomID) {
        Room room = entityManager.find(Room.class, roomID);

        if (room != null) {
            ArrayList<String> arrStudent = new ArrayList<String>();
            Course course = room.getIdCourse();
            for (Student student : course.getStudentCollection()) {
                arrStudent.add(student.toString() + ";" + room.getStartDate().toString() + ";" + room.getSession());
            }
            return arrStudent;
        }
        return null;
    }

    @Override
    public String getNameCourse(String roomID) {
        Room room = entityManager.find(Room.class, roomID);
        Course course = room.getIdCourse();
        return "(" + course.getId() + ")" + course.getName();
    }

    @Override
    public String getNameTeacher(String roomID) {
        Room room = entityManager.find(Room.class, roomID);
        Teacher teacher = room.getIdTeacher();
        return teacher.getLastname() + " " + teacher.getFirstname();
    }

    @Override
    public List<Object[]> searchScoreByIDStudent(String idStudent) {
        String query = "SELECT a.id_room, d.name, a.id_student, b.lastname, b.firstname, a.result1, a.result2, a.result3, a.test1, a.test2 FROM point a, student b, room c, course d "
                + "WHERE a.id_student = :id and a.id_room = c.id and a.id_student = b.id_student and c.id_course = d.id;";
        List<Object[]> studentPoint = entityManager.createNativeQuery(query).setParameter("id", idStudent).getResultList();
        return studentPoint;
    }

    @Override
    public boolean findStudentByID(String idStudent) {
        Student student = entityManager.find(Student.class, idStudent);
        return student != null;
    }

    @Override
    public Object[] findStudentName(String username) {
        Object[] student_name = (Object[]) entityManager.createNativeQuery("SELECT b.firstname, b.lastname FROM" + "\"user\"" + "a, student b WHERE a.user_name = b.username and a.user_name = :id")
                .setParameter("id", username).getSingleResult();
        return student_name;
    }

    @Override
    public Object[] findStudent(String username) {
        Object[] student = (Object[]) entityManager.createNativeQuery("SELECT b.* FROM" + "\"user\"" + "a, student b WHERE a.user_name = b.username and a.user_name = :id")
                .setParameter("id", username).getSingleResult();
        return student;
    }

    //---------------------------------------------FOR ADMIN------------------------------------------------
    @Override
    public Object[] findAdminName(String username) {
        Object[] admin_name = (Object[]) entityManager.createNativeQuery("SELECT b.firstname, b.lastname FROM" + "\"user\"" + "a, admin b WHERE a.user_name = b.username and a.user_name = :id")
                .setParameter("id", username).getSingleResult();
        return admin_name;
    }

    @Override
    public void insertStudent(Student student) {
        String query = "INSERT INTO student(id_student, firstname, lastname, birthday, gender, email, phone, address, admission, username, status) "
                + "VALUES (:id , :firstname, :lastname, :birthday, :gender, :email, :phone, :address, :admission, :username, :status)";
        entityManager.createNativeQuery(query).setParameter("id", student.getIdStudent())
                .setParameter("firstname", student.getFirstname())
                .setParameter("lastname", student.getLastname())
                .setParameter("birthday", student.getBirthday())
                .setParameter("gender", student.getGender())
                .setParameter("email", student.getEmail())
                .setParameter("phone", student.getPhone())
                .setParameter("address", student.getAddress())
                .setParameter("admission", student.getAdmission())
                .setParameter("username", student.getIdStudent())
                .setParameter("status", student.getStatus()).executeUpdate();
    }

    @Override
    public List<Object[]> getAllStudents() {
        List<Object[]> students = entityManager.createNativeQuery("SELECT * FROM student").getResultList();
        return students;
    }
    
    @Override
    public List<Object[]> getAllStudents(String nameStudent) {
        List<Object[]> students = entityManager.createNativeQuery("SELECT * FROM student WHERE firstname = :nameStudent").setParameter("nameStudent", nameStudent).getResultList();
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String query = "UPDATE student "
                + "SET firstname= :firstname, lastname= :lastname, birthday= :birthday, gender= :gender, email= :email, phone= :phone, address= :address, admission= :admission, status = :status "
                + "WHERE id_student= :id";
        entityManager.createNativeQuery(query).setParameter("id", student.getIdStudent())
                .setParameter("firstname", student.getFirstname())
                .setParameter("lastname", student.getLastname())
                .setParameter("birthday", student.getBirthday())
                .setParameter("gender", student.getGender())
                .setParameter("email", student.getEmail())
                .setParameter("phone", student.getPhone())
                .setParameter("address", student.getAddress())
                .setParameter("admission", student.getAdmission())
                .setParameter("status", student.getStatus()).executeUpdate();
    }

    @Override
    public List<Object[]> searchScoreByIDClass(String idClass) {
        String query = "SELECT a.id_student, b.lastname, b.firstname, b.birthday, b.gender, a.result1, a.result2, a.result3, a.test1, a.test2 "
                + "FROM point a, student b, room c, course d "
                + "WHERE a.id_room = :id and a.id_room = c.id and a.id_student = b.id_student and c.id_course = d.id;";
        List<Object[]> studentPoint = entityManager.createNativeQuery(query).setParameter("id", idClass).getResultList();
        return studentPoint;
    }

    @Override
    public void updateScore(String idStudent, String idRoom, String result1, String result2, String result3, String test1, String test2) {
        String query = "UPDATE point "
                + "SET result1= :result1, result2= :result2, result3= :result3, test1 = :test1, test2= :test2 "
                + "WHERE id_student= :idStudent and id_room= :idRoom";
        entityManager.createNativeQuery(query).setParameter("idStudent", idStudent)
                .setParameter("idRoom", idRoom)
                .setParameter("result1", Integer.parseInt(result1))
                .setParameter("result2", Integer.parseInt(result2))
                .setParameter("result3", Integer.parseInt(result3))
                .setParameter("test1", Integer.parseInt(test1))
                .setParameter("test2", Integer.parseInt(test2)).executeUpdate();
    }

    @Override
    public void insertScore(String idStudent, String idRoom, String result1, String result2, String result3, String test1, String test2) {
        String query = "INSERT INTO point(id_room, id_student, result1, result2, result3, test1, test2) "
                + "VALUES(:idRoom, :idStudent, :result1, :result2, :result3, :test1, :test2)";
        entityManager.createNativeQuery(query).setParameter("idStudent", idStudent)
                .setParameter("idRoom", idRoom)
                .setParameter("result1", Integer.parseInt(result1))
                .setParameter("result2", Integer.parseInt(result2))
                .setParameter("result3", Integer.parseInt(result3))
                .setParameter("test1", Integer.parseInt(test1))
                .setParameter("test2", Integer.parseInt(test2)).executeUpdate();
    }

    @Override
    public List<Object[]> getAllRequests(String idAdmin) {
        List<Object[]> requests = entityManager.createNativeQuery("SELECT * FROM request WHERE \"id_Admin\"= :id").setParameter("id", idAdmin).getResultList();
        return requests;
    }

    @Override
    public void updateRequest(String status, String id) {
        entityManager.createNativeQuery("UPDATE request SET status= :st WHERE id= :id").setParameter("st", status).setParameter("id", id).executeUpdate();
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        String query = "INSERT INTO teacher(id, firstname, lastname, birthday, gender, email, phone, address, status) "
                + "VALUES (:id , :firstname, :lastname, :birthday, :gender, :email, :phone, :address, :status)";
        entityManager.createNativeQuery(query).setParameter("id", teacher.getId())
                .setParameter("firstname", teacher.getFirstname())
                .setParameter("lastname", teacher.getLastname())
                .setParameter("birthday", teacher.getBirthday())
                .setParameter("gender", teacher.getGender())
                .setParameter("email", teacher.getEmail())
                .setParameter("phone", teacher.getPhone())
                .setParameter("address", teacher.getAddress())
                .setParameter("status", teacher.getStatus()).executeUpdate();
    }

    @Override
    public List<Object[]> getAllTeachers() {
        List<Object[]> teachers = entityManager.createNativeQuery("SELECT * FROM teacher").getResultList();
        return teachers;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        String query = "UPDATE teacher "
                + "SET firstname= :firstname, lastname= :lastname, birthday= :birthday, gender= :gender, email= :email, phone= :phone, address= :address, status = :status "
                + "WHERE id= :id";
        entityManager.createNativeQuery(query).setParameter("id", teacher.getId())
                .setParameter("firstname", teacher.getFirstname())
                .setParameter("lastname", teacher.getLastname())
                .setParameter("birthday", teacher.getBirthday())
                .setParameter("gender", teacher.getGender())
                .setParameter("email", teacher.getEmail())
                .setParameter("phone", teacher.getPhone())
                .setParameter("address", teacher.getAddress())
                .setParameter("status", teacher.getStatus()).executeUpdate();
    }

    @Override
    public void insertCourse(Course course) {
        String query = "INSERT INTO course(id, name, duration, fee, type) "
                + "VALUES (:id , :name, :duration, :fee, :type)";
        entityManager.createNativeQuery(query).setParameter("id", course.getId())
                .setParameter("name", course.getName())
                .setParameter("duration", course.getDuration())
                .setParameter("fee", course.getFee())
                .setParameter("type", course.getType()).executeUpdate();
    }

    @Override
    public void updateCourse(Course course) {
        String query = "UPDATE course "
                + "SET name= :name, duration= :duration, fee= :fee, type= :type "
                + "WHERE id= :id";
        entityManager.createNativeQuery(query).setParameter("id", course.getId())
                .setParameter("name", course.getName())
                .setParameter("duration", course.getDuration())
                .setParameter("fee", course.getFee())
                .setParameter("type", course.getType()).executeUpdate();
    }

    @Override
    public void deleteCourse(String idCourse) {
        entityManager.createNativeQuery("DELETE FROM course WHERE id= :id").setParameter("id", idCourse).executeUpdate();
    }

    @Override
    public void assignCourseForStudent(String idStudent, String idCourse) {
        Student student = entityManager.find(Student.class, idStudent);
        Course course = entityManager.find(Course.class, idCourse);

        student.getCourseCollection().add(course);
        course.getStudentCollection().add(student);
    }

    @Override
    public ArrayList<String> getListCoursesRegistered() {
        List<Object[]> students = getAllStudents();
        ArrayList<String> listCourses = new ArrayList<String>();
        Student student;
        for (int i = 0; i < students.size(); i++) {
            student = entityManager.find(Student.class, students.get(i)[0].toString());
            for (Course course : student.getCourseCollection()) {
                listCourses.add(student.toString() + ";" + course.toString());
            }
        }
        return listCourses;
    }

    @Override
    public ArrayList<String> getListCoursesRegistered(String idStudent) {
        ArrayList<String> listCourses = new ArrayList<String>();
        Student student = entityManager.find(Student.class, idStudent);
        for (Course course : student.getCourseCollection()) {
            listCourses.add(course.getId() + ";" + course.getName() + ";" + course.getDuration() + ";" + course.getFee() + ";" + course.getType());
        }
        return listCourses;
    }

    @Override
    public void insertRoom(Room room, String idCourse, String idTeacher) {
        String query = "INSERT INTO room(id, id_course, id_teacher, start_date, session) "
                + "VALUES (:id , :id_course, :id_teacher, :start_date, :session)";
        entityManager.createNativeQuery(query).setParameter("id", room.getId())
                .setParameter("id_course", idCourse)
                .setParameter("id_teacher", idTeacher)
                .setParameter("start_date", room.getStartDate())
                .setParameter("session", room.getSession()).executeUpdate();
    }

    @Override
    public void updateRoom(Room room, String idCourse, String idTeacher) {
        String query = "UPDATE room "
                + "SET id_course= :id_course, id_teacher= :id_teacher, start_date= :start_date, session= :session "
                + "WHERE id= :id";
        entityManager.createNativeQuery(query).setParameter("id", room.getId())
                .setParameter("id_course", idCourse)
                .setParameter("id_teacher", idTeacher)
                .setParameter("start_date", room.getStartDate())
                .setParameter("session", room.getSession()).executeUpdate();
    }

    @Override
    public Object[] getRoomByID(String idRoom) {
        String query = "SELECT * "
                + "FROM room "
                + "WHERE id = :idRoom";
        Object[] infoRoom = (Object[]) entityManager.createNativeQuery(query).setParameter("idRoom", idRoom).getSingleResult();
        return infoRoom;
    }


}
