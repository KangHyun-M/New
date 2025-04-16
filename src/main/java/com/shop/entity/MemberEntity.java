package com.shop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="member")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_nickname")
	private String username;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_pw")
	private String pw;
	
	@Column(name = "pw_chk")
	private String pw_chk;
	
	@Column(name = "temp_pw")
	private String temp_pw;
	
	@Column(name = "role")
	private String role;
	
	private LocalDateTime joinedDate;
}
