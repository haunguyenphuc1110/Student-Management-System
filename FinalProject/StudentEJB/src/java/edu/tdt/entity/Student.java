/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HAU
 */
@Entity
@Table(name = "student", catalog = "StudentManagement", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByIdStudent", query = "SELECT s FROM Student s WHERE s.idStudent = :idStudent")
    , @NamedQuery(name = "Student.findByFirstname", query = "SELECT s FROM Student s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "Student.findByBirthday", query = "SELECT s FROM Student s WHERE s.birthday = :birthday")
    , @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender")
    , @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email")
    , @NamedQuery(name = "Student.findByPhone", query = "SELECT s FROM Student s WHERE s.phone = :phone")
    , @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address")
    , @NamedQuery(name = "Student.findByAdmission", query = "SELECT s FROM Student s WHERE s.admission = :admission")
    , @NamedQuery(name = "Student.findByStatus", query = "SELECT s FROM Student s WHERE s.status = :status")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_student", nullable = false, length = 2147483647)
    private String idStudent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "firstname", nullable = false, length = 2147483647)
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "lastname", nullable = false, length = 2147483647)
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender", nullable = false)
    private boolean gender;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email", nullable = false, length = 2147483647)
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "phone", nullable = false, length = 2147483647)
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "address", nullable = false, length = 2147483647)
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admission", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date admission;
    @Size(max = 2147483647)
    @Column(name = "status", length = 2147483647)
    private String status;
    @ManyToMany(mappedBy = "studentCollection")
    private Collection<Course> courseCollection;
    @JoinColumn(name = "username", referencedColumnName = "user_name")
    @ManyToOne
    private User username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Point> pointCollection;

    public Student() {
    }

    public Student(String idStudent) {
        this.idStudent = idStudent;
    }

    public Student(String idStudent, String firstname, String lastname, Date birthday, boolean gender, String email, String phone, String address, Date admission) {
        this.idStudent = idStudent;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.admission = admission;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAdmission() {
        return admission;
    }

    public void setAdmission(Date admission) {
        this.admission = admission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    @XmlTransient
    public Collection<Point> getPointCollection() {
        return pointCollection;
    }

    public void setPointCollection(Collection<Point> pointCollection) {
        this.pointCollection = pointCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudent != null ? idStudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idStudent == null && other.idStudent != null) || (this.idStudent != null && !this.idStudent.equals(other.idStudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idStudent + ";" + lastname + ";" + firstname + ";" + birthday.toString() + ";" + gender;
    }
    
}
