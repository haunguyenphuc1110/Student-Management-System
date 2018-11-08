/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HAU
 */
@Entity
@Table(name = "point", catalog = "StudentManagement", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Point.findAll", query = "SELECT p FROM Point p")
    , @NamedQuery(name = "Point.findByIdRoom", query = "SELECT p FROM Point p WHERE p.pointPK.idRoom = :idRoom")
    , @NamedQuery(name = "Point.findByIdStudent", query = "SELECT p FROM Point p WHERE p.pointPK.idStudent = :idStudent")
    , @NamedQuery(name = "Point.findByResult1", query = "SELECT p FROM Point p WHERE p.result1 = :result1")
    , @NamedQuery(name = "Point.findByResult2", query = "SELECT p FROM Point p WHERE p.result2 = :result2")
    , @NamedQuery(name = "Point.findByResult3", query = "SELECT p FROM Point p WHERE p.result3 = :result3")
    , @NamedQuery(name = "Point.findByTest1", query = "SELECT p FROM Point p WHERE p.test1 = :test1")
    , @NamedQuery(name = "Point.findByTest2", query = "SELECT p FROM Point p WHERE p.test2 = :test2")})
public class Point implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PointPK pointPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "result1", nullable = false)
    private int result1;
    @Column(name = "result2")
    private Integer result2;
    @Column(name = "result3")
    private Integer result3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "test1", nullable = false)
    private int test1;
    @Column(name = "test2")
    private Integer test2;
    @JoinColumn(name = "id_room", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Room room;
    @JoinColumn(name = "id_student", referencedColumnName = "id_student", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Point() {
    }

    public Point(PointPK pointPK) {
        this.pointPK = pointPK;
    }

    public Point(PointPK pointPK, int result1, int test1) {
        this.pointPK = pointPK;
        this.result1 = result1;
        this.test1 = test1;
    }

    public Point(String idRoom, String idStudent) {
        this.pointPK = new PointPK(idRoom, idStudent);
    }

    public PointPK getPointPK() {
        return pointPK;
    }

    public void setPointPK(PointPK pointPK) {
        this.pointPK = pointPK;
    }

    public int getResult1() {
        return result1;
    }

    public void setResult1(int result1) {
        this.result1 = result1;
    }

    public Integer getResult2() {
        return result2;
    }

    public void setResult2(Integer result2) {
        this.result2 = result2;
    }

    public Integer getResult3() {
        return result3;
    }

    public void setResult3(Integer result3) {
        this.result3 = result3;
    }

    public int getTest1() {
        return test1;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pointPK != null ? pointPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Point)) {
            return false;
        }
        Point other = (Point) object;
        if ((this.pointPK == null && other.pointPK != null) || (this.pointPK != null && !this.pointPK.equals(other.pointPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Point[ pointPK=" + pointPK + " ]";
    }
    
}
