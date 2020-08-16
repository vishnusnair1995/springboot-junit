package com.equifax.library.model;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="USER")
	public class User {
		
		@Id
		@GeneratedValue
		@Column(name = "USER_ID")
		private int userId;
		
		@Column(name = "USER_NAME")
		private String userName;
		
		@Column(name = "ROLE")
		private String userRole;
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserRole() {
			return userRole;
		}
		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}
		
}

