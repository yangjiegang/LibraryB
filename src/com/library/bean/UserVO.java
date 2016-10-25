package com.library.bean;

import java.io.Serializable;

/*@Entity
@Table(name="userinfo")*/
public class UserVO implements Serializable {
	private static final long serialVersionUID = -5791379962273331713L;
/*	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="uID")*/
	private Integer uID;
//	@Column(name="userName")
	private String userName;
//	@Column(name="password")
	private String password;
//	@Column(name="gender")
	private Boolean gender;// {true:male,false:female}
//	@Column(name="level")
	private Integer level;//{2:reader,3:librarist}
	
	public String getUserName() {
		return userName;
	}
	public Integer getuID() {
		return uID;
	}
	public void setuID(Integer uID) {
		this.uID = uID;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
