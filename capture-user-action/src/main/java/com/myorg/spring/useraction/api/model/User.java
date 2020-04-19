package com.myorg.spring.useraction.api.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity()
@Table(name = "USER_ACTION")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;
	@Column(name = "FIRST_NAME", length = 25)
	private String firstName;
	@Column(name = "LAST_NAME", length = 25)
	private String lastName;
	@Column(name = "MOBILE", length = 10)
	private long mobile;
	@Column(name = "EMAIL", length = 45)
	private String email;
	@Column(name = "ADDRESS", length = 50)
	private String address;
	@Column(name = "USER_ACTION", length = 50)
	private String userAction;

	@CreationTimestamp
	@Column(name = "CREATE_DT")
	private Timestamp createDate;

	@UpdateTimestamp
	@Column(name = "UPDATE_DT")
	private Timestamp updateDate;

	public User(int id, String firstName, String lastName, long mobile,
			String email, String address, String userAction,
			Timestamp createDate, Timestamp updateDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.userAction = userAction;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public User() {
		super();
	}

}
