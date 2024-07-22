package com.entity;



import java.util.List;

import com.RateTypeEnum;

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
@Table(name = "RateType")
public class RateTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RateTypeEnum type;
	
//	@OneToMany
//	@JoinColumn(name = "rate_type_id")
//	private List<RateListEntity> rateList;
	
//	@OneToMany
//	@JoinColumn(name = "rate_type_id")
//    private List<PackageEntity> packages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RateTypeEnum getType() {
		return type;
	}
	
	public void setType(RateTypeEnum type) {
		this.type = type;
	}

//	public List<RateListEntity> getRateList() {
//		return rateList;
//	}
//
//	public void setRateList(List<RateListEntity> rateList) {
//		this.rateList = rateList;
//	} 
}
