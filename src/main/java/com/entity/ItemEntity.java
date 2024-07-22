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
@Table(name = "Item")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String MaterialGroupName;
	
	@ManyToOne
	@JoinColumn(name = "material_id", referencedColumnName = "id", nullable = false)
	private MaterialEntity materialName;
	
	@Column(nullable = false)
    private String itemCode;

    @Column(nullable = false)
    private String itemName;   

    @Column(nullable = true)
    private String alternateName;

    @Column(nullable = true)
    private String shortName;

    @Column(nullable = false)
    private double gstRate;

    @Column(nullable = false)
    private String HsnCode;

    @Column(nullable = false)
    private double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterialGroupName() {
		return MaterialGroupName;
	}

	public void setMaterialGroupName(String materialGroupName) {
		MaterialGroupName = materialGroupName;
	}

	public MaterialEntity getMaterialName() {
		return materialName;
	}

	public void setMaterialName(MaterialEntity materialName) {
		this.materialName = materialName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getAlternateName() {
		return alternateName;
	}

	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public double getGstRate() {
		return gstRate;
	}

	public void setGstRate(double gstRate) {
		this.gstRate = gstRate;
	}

	public String getHsnCode() {
		return HsnCode;
	}

	public void setHsnCode(String hsnCode) {
		HsnCode = hsnCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    
}
