/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HAU
 */
@Entity
@Table(name = "course", catalog = "StudentManagement", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id")
    , @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name")
    , @NamedQuery(name = "Course.findByDuration", query = "SELECT c FROM Course c WHERE c.duration = :duration")
    , @NamedQuery(name = "Course.findByFee", query = "SELECT c FROM Course c WHERE c.fee = :fee")
    , @NamedQuery(name = "Course.findByType", query = "SELECT c FROM Course c WHERE c.type = :type")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id", nullable = false, length = 2147483647)
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name", nullable = false, length = 2147483647)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "duration", nullable = false, length = 2147483647)
    private String duration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fee", nullable = false)
    private int fee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "type", nullable = false, length = 2147483647)
    private String type;
    @JoinTable(name = "student_course", joinColumns = {
        @JoinColumn(name = "id_course", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_student", referencedColumnName = "id_student", nullable = false)})
    @ManyToMany
    private Collection<Student> studentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCourse")
    private Collection<Room> roomCollection;

    public Course() {
    }

    public Course(String id) {
        this.id = id;
    }

    public Course(String id, String name, String duration, int fee, String type) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + ";" + name + ";" + type;
    }
    
}
