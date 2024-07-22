package com.entity;

import com.PackageTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Package")
public class PackageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name = "rate_type_id" , referencedColumnName = "id" , nullable = false)
	private RateTypeEntity rateType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PackageTypeEnum packageType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public RateTypeEntity getRateType() {
		return rateType;
	}

	public void setRateType(RateTypeEntity rateType) {
		this.rateType = rateType;
	}

	public PackageTypeEnum getPackageType() {
		return packageType;
	}

	public void setPackageType(PackageTypeEnum packageType) {
		this.packageType = packageType;
	}
}
