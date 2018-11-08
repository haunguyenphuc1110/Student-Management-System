package edu.tdt.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Room.class)
public abstract class Room_ {

	public static volatile SingularAttribute<Room, Course> idCourse;
	public static volatile SingularAttribute<Room, Integer> session;
	public static volatile SingularAttribute<Room, Teacher> idTeacher;
	public static volatile CollectionAttribute<Room, Point> pointCollection;
	public static volatile SingularAttribute<Room, String> id;
	public static volatile SingularAttribute<Room, Date> startDate;

}

