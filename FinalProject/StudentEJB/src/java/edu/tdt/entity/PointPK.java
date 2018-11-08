/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HAU
 */
@Embeddable
public class PointPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_room", nullable = false, length = 2147483647)
    private String idRoom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_student", nullable = false, length = 2147483647)
    private String idStudent;

    public PointPK() {
    }

    public PointPK(String idRoom, String idStudent) {
        this.idRoom = idRoom;
        this.idStudent = idStudent;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoom != null ? idRoom.hashCode() : 0);
        hash += (idStudent != null ? idStudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PointPK)) {
            return false;
        }
        PointPK other = (PointPK) object;
        if ((this.idRoom == null && other.idRoom != null) || (this.idRoom != null && !this.idRoom.equals(other.idRoom))) {
            return false;
        }
        if ((this.idStudent == null && other.idStudent != null) || (this.idStudent != null && !this.idStudent.equals(other.idStudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tdt.entity.PointPK[ idRoom=" + idRoom + ", idStudent=" + idStudent + " ]";
    }
    
}
