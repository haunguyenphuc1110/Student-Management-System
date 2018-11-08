package edu.tdt.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Teacher.class)
public abstract class Teacher_ {

	public static volatile SingularAttribute<Teacher, Date> birthday;
	public static volatile SingularAttribute<Teacher, String> firstname;
	public static volatile SingularAttribute<Teacher, String> address;
	public static volatile SingularAttribute<Teacher, Boolean> gender;
	public static volatile SingularAttribute<Teacher, String> phone;
	public static volatile CollectionAttribute<Teacher, Room> roomCollection;
	public static volatile SingularAttribute<Teacher, String> id;
	public static volatile SingularAttribute<Teacher, String> email;
	public static volatile SingularAttribute<Teacher, String> lastname;
	public static volatile SingularAttribute<Teacher, String> status;

}

