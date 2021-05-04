package com.ass.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-15T17:46:34.969+0700")
@StaticMetamodel(Order.class)
public class Order_ {
	public static volatile SingularAttribute<Order, Integer> favortiesId;
	public static volatile SingularAttribute<Order, Date> date;
	public static volatile SingularAttribute<Order, User> user;
	public static volatile SingularAttribute<Order, Product> product;
}
