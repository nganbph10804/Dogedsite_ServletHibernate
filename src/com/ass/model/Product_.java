package com.ass.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-15T17:31:58.110+0700")
@StaticMetamodel(Product.class)
public class Product_ {
	public static volatile SingularAttribute<Product, String> productId;
	public static volatile SingularAttribute<Product, String> img;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, Double> price;
	public static volatile ListAttribute<Product, Order> orders;
}
