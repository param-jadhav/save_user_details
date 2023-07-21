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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserAction() {
		return userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}
