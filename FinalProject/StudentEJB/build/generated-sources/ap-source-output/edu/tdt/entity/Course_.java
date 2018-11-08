package edu.tdt.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile SingularAttribute<Course, String> duration;
	public static volatile SingularAttribute<Course, Integer> fee;
	public static volatile SingularAttribute<Course, String> name;
	public static volatile CollectionAttribute<Course, Room> roomCollection;
	public static volatile CollectionAttribute<Course, Student> studentCollection;
	public static volatile SingularAttribute<Course, String> id;
	public static volatile SingularAttribute<Course, String> type;

}

