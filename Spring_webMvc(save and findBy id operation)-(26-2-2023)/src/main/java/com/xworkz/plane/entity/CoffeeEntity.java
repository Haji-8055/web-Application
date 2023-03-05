package com.xworkz.plane.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="coffee_details")
@NamedQuery(name = "findByCompany",query = "select entity from CoffeeEntity entity where entity.company=:com")
public class CoffeeEntity {
	
	@Column(name = "id")
	@Id
	private int id;
	
	@Column(name = "c_company")
	private String company;
	
	@Column(name = "c_name")
	private String name;
	
	@Column(name = "a_cost")
	private Integer cost;
	
	@Column(name = "a_type")
	private String type;
	
	@Column(name = "a_location")
	private String outlet;


}
