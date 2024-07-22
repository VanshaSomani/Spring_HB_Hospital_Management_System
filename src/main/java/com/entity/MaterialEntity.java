package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entity")
public class MaterialEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "material_name" ,referencedColumnName = "id" , nullable = false)
	private PackageEntity materialName;
	
	@ManyToOne
	@JoinColumn(name = "description" ,referencedColumnName = "id" , nullable = false)
	private RateTypeEntity description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PackageEntity getMaterialName() {
		return materialName;
	}

	public void setMaterialName(PackageEntity materialName) {
		this.materialName = materialName;
	}

	public RateTypeEntity getDescription() {
		return description;
	}

	public void setDescription(RateTypeEntity description) {
		this.description = description;
	}
}
