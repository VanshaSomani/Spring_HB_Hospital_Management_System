package com.entity;

import org.hibernate.annotations.ManyToAny;

import com.RateListNameEnum;

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
@Table(name = "RateList")
public class RateListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = false)
	private RateListNameEnum name;
	
	@Column(nullable = false)
    private double amount;
	
	@ManyToOne
	@JoinColumn(name = "rate_type_id", referencedColumnName = "id", nullable = false)
	private RateTypeEntity rateType;
	
	@ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    private DepartmentEntity department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RateListNameEnum getName() {
		return name;
	}

	public void setName(RateListNameEnum name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public RateTypeEntity getRateType() {
		return rateType;
	}

	public void setRateType(RateTypeEntity rateType) {
		this.rateType = rateType;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
}
