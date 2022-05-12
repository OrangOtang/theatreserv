package com.tbs.theatre.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THEATRE")
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String name;
	private Integer addressId;
	@Column(name = "show1")
	private Integer show1;
	@Column(name = "show2")
	private Integer show2;
	@Column(name = "show3")
	private Integer show3;

	public Integer getShow1() {
		return show1;
	}

	public void setShow1(Integer show1) {
		this.show1 = show1;
	}

	public Integer getShow2() {
		return show2;
	}

	public void setShow2(Integer show2) {
		this.show2 = show2;
	}

	public Integer getShow3() {
		return show3;
	}

	public void setShow3(Integer show3) {
		this.show3 = show3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
}
