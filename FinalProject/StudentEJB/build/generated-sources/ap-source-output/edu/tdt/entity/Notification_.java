package edu.tdt.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Notification.class)
public abstract class Notification_ {

	public static volatile SingularAttribute<Notification, String> headerText;
	public static volatile SingularAttribute<Notification, Long> id;
	public static volatile SingularAttribute<Notification, Date> postingDate;

}

