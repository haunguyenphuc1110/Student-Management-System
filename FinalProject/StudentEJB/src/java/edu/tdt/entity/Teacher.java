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
@Table(name = "teacher", catalog = "StudentManagement", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findById", query = "SELECT t FROM Teacher t WHERE t.id = :id")
    , @NamedQuery(name = "Teacher.findByFirstname", query = "SELECT t FROM Teacher t WHERE t.firstname = :firstname")
    , @NamedQuery(name = "Teacher.findByLastname", query = "SELECT t FROM Teacher t WHERE t.lastname = :lastname")
    , @NamedQuery(name = "Teacher.findByBirthday", query = "SELECT t FROM Teacher t WHERE t.birthday = :birthday")
    , @NamedQuery(name = "Teacher.findByGender", query = "SELECT t FROM Teacher t WHERE t.gender = :gender")
    , @NamedQuery(name = "Teacher.findByPhone", query = "SELECT t FROM Teacher t WHERE t.phone = :phone")
    , @NamedQuery(name = "Teacher.findByEmail", query = "SELECT t FROM Teacher t WHERE t.email = :email")
    , @NamedQuery(name = "Teacher.findByAddress", query = "SELECT t FROM Teacher t WHERE t.address = :address")
    , @NamedQuery(name = "Teacher.findByStatus", query = "SELECT t FROM Teacher t WHERE t.status = :status")})
public class Teacher implements Serializable {

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
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "phone", nullable = false, length = 2147483647)
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email", nullable = false, length = 2147483647)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "address", nullable = false, length = 2147483647)
    private String address;
    @Size(max = 2147483647)
    @Column(name = "status", length = 2147483647)
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeacher")
    private Collection<Room> roomCollection;

    public Teacher() {
    }

    public Teacher(String id) {
        this.id = id;
    }

    public Teacher(String id, String firstname, String lastname, Date birthday, boolean gender, String phone, String email, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Teacher[ id=" + id + " ]";
    }
    
}
