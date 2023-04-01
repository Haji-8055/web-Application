package com.xworkz.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "projectUserDetails")
@NamedQuery(name = "fetchAll", query = "select entity from ProjectEntity entity")
public class ProjectEntity {
	@Id
	@Column(name = "p_signUpId")
	private int signUpId;

	@Column(name = "p_userId")
	private String userId;

	@Column(name = "p_email")
	private String email;

	@Column(name = "p_mobile")
	private Long mobile;

	@Column(name = "p_password")
	private String password;

	@Column(name = "p_createdBy")
	private String createdBy;

	@Column(name = "p_createdDate")
	private LocalDateTime createdDate = LocalDateTime.now();

	@Column(name = "p_updatedBy")
	private String updatedBy;

	@Column(name = "p_updatedDate")
	private LocalDateTime updatedDate;
}
