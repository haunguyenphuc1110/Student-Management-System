package edu.tdt.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, Date> birthday;
	public static volatile SingularAttribute<Student, String> firstname;
	public static volatile SingularAttribute<Student, String> address;
	public static volatile SingularAttribute<Student, Boolean> gender;
	public static volatile CollectionAttribute<Student, Course> courseCollection;
	public static volatile CollectionAttribute<Student, Point> pointCollection;
	public static volatile SingularAttribute<Student, Date> admission;
	public static volatile SingularAttribute<Student, String> lastname;
	public static volatile SingularAttribute<Student, String> phone;
	public static volatile SingularAttribute<Student, String> idStudent;
	public static volatile SingularAttribute<Student, String> email;
	public static volatile SingularAttribute<Student, String> status;
	public static volatile SingularAttribute<Student, User> username;

}

