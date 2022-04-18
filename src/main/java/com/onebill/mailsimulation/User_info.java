package com.onebill.mailsimulation;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User_Info")
public class User_info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int user_id;
	@Column(name = "User_name", length = 255)
	private String user_name;
	@Column(name = "Email", length = 255, unique = true)
	private String email;
	@Column(name = "Password", length = 255)
	private String password;
//	@OneToMany(cascade = CascadeType.ALL)
	@OneToMany
	@Column(name = "Mail_info")
	private List<Mail_info> mail_info;

	
	
	
}
