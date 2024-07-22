package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PackageItem")
public class PackageItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "package_id" , referencedColumnName = "id" , nullable = false)
	private PackageEntity packageEntity;
	
	@ManyToOne
	@JoinColumn(name = "item_id" , referencedColumnName = "id" , nullable = false)
	private ItemEntity itemEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PackageEntity getPackageEntity() {
		return packageEntity;
	}

	public void setPackageEntity(PackageEntity packageEntity) {
		this.packageEntity = packageEntity;
	}

	public ItemEntity getItemEntity() {
		return itemEntity;
	}

	public void setItemEntity(ItemEntity itemEntity) {
		this.itemEntity = itemEntity;
	}
	
 	
}
