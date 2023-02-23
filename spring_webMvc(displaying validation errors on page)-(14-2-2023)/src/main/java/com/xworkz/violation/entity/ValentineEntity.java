package com.xworkz.violation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "valentine")
@Data
public class ValentineEntity {

	@Column(name = "id")
	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "v_name")
	private String valentineName;

	@Column(name = "m_place")
	private String meetingPlace;

	@Column(name = "v_gift")
	private String gift;
}
