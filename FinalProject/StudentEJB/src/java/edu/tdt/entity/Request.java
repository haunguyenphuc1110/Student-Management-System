/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HAU
 */
@Entity
@Table(name = "request", catalog = "StudentManagement", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r")
    , @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id")
    , @NamedQuery(name = "Request.findByGuestname", query = "SELECT r FROM Request r WHERE r.guestname = :guestname")
    , @NamedQuery(name = "Request.findByParentname", query = "SELECT r FROM Request r WHERE r.parentname = :parentname")
    , @NamedQuery(name = "Request.findByEmail", query = "SELECT r FROM Request r WHERE r.email = :email")
    , @NamedQuery(name = "Request.findByBirthday", query = "SELECT r FROM Request r WHERE r.birthday = :birthday")
    , @NamedQuery(name = "Request.findByAddress", query = "SELECT r FROM Request r WHERE r.address = :address")
    , @NamedQuery(name = "Request.findByPhone", query = "SELECT r FROM Request r WHERE r.phone = :phone")
    , @NamedQuery(name = "Request.findByCourse", query = "SELECT r FROM Request r WHERE r.course = :course")
    , @NamedQuery(name = "Request.findByInformation", query = "SELECT r FROM Request r WHERE r.information = :information")
    , @NamedQuery(name = "Request.findByDatecreated", query = "SELECT r FROM Request r WHERE r.datecreated = :datecreated")
    , @NamedQuery(name = "Request.findByStatus", query = "SELECT r FROM Request r WHERE r.status = :status")})
public class Request implements Serializable {

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
    @Column(name = "guestname", nullable = false, length = 2147483647)
    private String guestname;
    @Size(max = 2147483647)
    @Column(name = "parentname", length = 2147483647)
    private String parentname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email", nullable = false, length = 2147483647)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "address", nullable = false, length = 2147483647)
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "phone", nullable = false, length = 2147483647)
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "course", nullable = false, length = 2147483647)
    private String course;
    @Size(max = 2147483647)
    @Column(name = "information", length = 2147483647)
    private String information;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecreated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "status", nullable = false, length = 2147483647)
    private String status;
    @JoinColumn(name = "id_Admin", referencedColumnName = "id")
    @ManyToOne
    private Admin idAdmin;

    public Request() {
    }

    public Request(String id) {
        this.id = id;
    }

    public Request(String id, String guestname, String email, Date birthday, String address, String phone, String course, Date datecreated, String status) {
        this.id = id;
        this.guestname = guestname;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.course = course;
        this.datecreated = datecreated;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Admin getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Admin idAdmin) {
        this.idAdmin = idAdmin;
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
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.Request[ id=" + id + " ]";
    }
    
}
