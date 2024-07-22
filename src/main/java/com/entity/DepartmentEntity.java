package com.entity;

import java.util.List;

import com.DepartmentEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class DepartmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private DepartmentEnum name;
	
	@Column(nullable = false)
	private boolean active;
	
//	@OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "department_id")
//    private List<RateListEntity> rateList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DepartmentEnum getName() {
		return name;
	}

	public void setName(DepartmentEnum name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

//	public List<RateListEntity> getRateList() {
//		return rateList;
//	}
//
//	public void setRateList(List<RateListEntity> rateList) {
//		this.rateList = rateList;
//	}
}
