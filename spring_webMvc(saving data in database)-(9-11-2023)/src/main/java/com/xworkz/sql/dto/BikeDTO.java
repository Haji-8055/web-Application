package com.xworkz.sql.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bike_details")
public class BikeDTO {

	@Column(name = "id")
	@Id
	private int id;
	
	@Column(name = "bike_name")
	private String bikeName;
	
	@Column(name = "bike_owner")
	private String bikeOwner;
	
	@Column(name = "bike_brand")
	private String bikeBrand;
	
	@Column(name = "isFast")
	private Boolean isFast;
	
	@Column(name = "bike_cc")
	private Integer bikeCC;

}
