package com.poly.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class User {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "Password")
	private String passWord;

	@Column(name = "Fullname")
	private String fullName;

	@Column(name = "Email")
	private String email;

	@Column(name = "Admin")
	private Boolean admin;
}
