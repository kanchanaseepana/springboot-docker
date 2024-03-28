package com.nagarro.dockersample.Entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "last_name", nullable = false)
	    private String lastName;

	    @Column(name = "email_address", nullable = false)
	    private String email;

//	    @CreationTimestamp
//	    @Temporal(TemporalType.TIMESTAMP)
//	    @Column(name = "created_at", nullable = false)
//	    private Date createdAt;

		public long getId() {
			return id;
		}

		public void setId(long id) {
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
//
//		public Date getCreatedAt() {
//			return createdAt;
//		}
//
//		public void setCreatedAt(Date createdAt) {
//			this.createdAt = createdAt;
//		}

		public User(long id, String firstName, String lastName, String email) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
//			this.createdAt = createdAt;
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ "]";
		}
	    
	    

}
