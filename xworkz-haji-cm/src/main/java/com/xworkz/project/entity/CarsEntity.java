package com.xworkz.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars_list")
@Setter
@Getter
@NamedQuery(name = "onSearchCar",query = "select entity from CarsEntity entity where entity.carCompany=:param or entity.carName=:param and entity.carsId=:id")
public class CarsEntity {

	@Id
	@Column(name = "c_id")
	private int carsId;

	@Column(name = "car_company")
	private String carCompany;

	@Column(name = "car_name")
	private String carName;

	@Column(name = "car_model")
	private String carModel;
	
	@Column(name = "c_owners")
	private int noOfOwners;
	
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name = "id",referencedColumnName = "id")
	private ProjectEntity projectEntity;

}
