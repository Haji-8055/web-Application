package com.xworkz.project.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "projectUserDetails")
@NamedQuery(name = "fetchAll", query = "select entity from ProjectEntity entity")
@NamedQuery(name = "findByUserID", query = "select entity from ProjectEntity entity where entity.userId=:user")
@NamedQuery(name = "expireOTP", query = "update ProjectEntity entity set entity.otpExpired=:boolean where entity.otpRequestedTime<=:currentTime")
@NamedQuery(name = "findByEmailId", query = "select entity from ProjectEntity entity where entity.email=:email")

public class ProjectEntity {
	
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "p_userId")
	private String userId;

	@Column(name = "p_email")
	private String email;

	@Column(name = "p_mobile")
	private Long mobileNumber;

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

	@Column(name = "p_SignIn_count")
	private Integer SignInCount = 0;

	@Column(name = "reset_password")
	private Boolean resetPassword = false;

	@Column(name = "otp_requested_time")
	private LocalTime otpRequestedTime;

	@Column(name = "otp_expired")
	private Boolean otpExpired;
	
	
	@Column(name = "profile_pic_name")
	private String picName;
	
	@OneToMany(mappedBy = "projectEntity",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<CarsEntity> carsEntities;
	

}
