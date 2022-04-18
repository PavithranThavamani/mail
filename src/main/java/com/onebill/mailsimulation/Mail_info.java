package com.onebill.mailsimulation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Mail_info")
public class Mail_info {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Id")
	private int id;
	@JoinColumn(name = "From_id", referencedColumnName = "Id")
	private int from_id;
	@JoinColumn(name = "To_id")
	private int to_id;
	@Column(name = "Subject", length = 255)
	private String subject;
	@Column(name = "Message", length = 255)
	private String message;
	@Column(name = "Staus", length = 255)
	private String status;
}
