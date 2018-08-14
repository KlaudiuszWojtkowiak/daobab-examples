package io.daobab.example.pizza.dao.entity;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.daobab.example.pizza.dao.entity.relation.RelatedToCustomer;
import io.daobab.example.pizza.dao.entity.relation.RelatedToName;


@Entity
@Table(name="CUSTOMER",schema="")
@Cacheable(false)
public class Customer implements RelatedToName,RelatedToCustomer{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID",  unique = true, nullable = false)
	private Integer customerId;
	
	@Column(name="NAME")
	private String name;
	

	@Column(name="ADRESS")
	private String adress;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="INSERT_DATE")
	private Date insertDate;

	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	


}
