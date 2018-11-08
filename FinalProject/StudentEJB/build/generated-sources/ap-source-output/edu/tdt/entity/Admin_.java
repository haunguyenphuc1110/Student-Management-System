package edu.tdt.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Admin.class)
public abstract class Admin_ {

	public static volatile SingularAttribute<Admin, Date> birthday;
	public static volatile SingularAttribute<Admin, String> firstname;
	public static volatile CollectionAttribute<Admin, Request> requestCollection;
	public static volatile SingularAttribute<Admin, String> address;
	public static volatile SingularAttribute<Admin, Boolean> gender;
	public static volatile SingularAttribute<Admin, String> phone;
	public static volatile SingularAttribute<Admin, String> id;
	public static volatile SingularAttribute<Admin, String> email;
	public static volatile SingularAttribute<Admin, String> lastname;
	public static volatile SingularAttribute<Admin, String> status;
	public static volatile SingularAttribute<Admin, User> username;

}

