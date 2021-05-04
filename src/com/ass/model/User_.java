package com.ass.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-15T17:45:13.519+0700")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> fullname;
	public static volatile SingularAttribute<User, Boolean> admin;
	public static volatile SingularAttribute<User, String> password;
	public static volatile ListAttribute<User, Order> orders;
}
