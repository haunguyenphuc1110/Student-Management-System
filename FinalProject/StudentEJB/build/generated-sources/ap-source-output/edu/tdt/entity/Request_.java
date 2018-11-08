package edu.tdt.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Request.class)
public abstract class Request_ {

	public static volatile SingularAttribute<Request, Date> birthday;
	public static volatile SingularAttribute<Request, Admin> idAdmin;
	public static volatile SingularAttribute<Request, String> parentname;
	public static volatile SingularAttribute<Request, String> address;
	public static volatile SingularAttribute<Request, String> phone;
	public static volatile SingularAttribute<Request, String> guestname;
	public static volatile SingularAttribute<Request, String> course;
	public static volatile SingularAttribute<Request, String> information;
	public static volatile SingularAttribute<Request, String> id;
	public static volatile SingularAttribute<Request, Date> datecreated;
	public static volatile SingularAttribute<Request, String> email;
	public static volatile SingularAttribute<Request, String> status;

}

