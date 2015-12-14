package com.borrowhut.ws.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUCT_FEATURE database table.
 * 
 */
@Entity
@Table(name="PRODUCT_FEATURE")
@NamedQuery(name="ProductFeature.findAll", query="SELECT p FROM ProductFeature p")
@IdClass(ProductFeaturePK.class)
public class ProductFeature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ftrName;

	@Id
	private int prdId;

	@Id
	private String catName;

	

	//bi-directional many-to-one association to ListedProductFeature
	@OneToMany(mappedBy="productFeature")
	private List<ListedProductFeature> listedProductFeatures;

	public ProductFeature() {
	}

	/*public ProductFeaturePK getId() {
		return this.id;
	}

	public void setId(ProductFeaturePK id) {
		this.id = id;
	}*/

	public List<ListedProductFeature> getListedProductFeatures() {
		return this.listedProductFeatures;
	}

	public void setListedProductFeatures(List<ListedProductFeature> listedProductFeatures) {
		this.listedProductFeatures = listedProductFeatures;
	}

	public ListedProductFeature addListedProductFeature(ListedProductFeature listedProductFeature) {
		getListedProductFeatures().add(listedProductFeature);
		listedProductFeature.setProductFeature(this);

		return listedProductFeature;
	}

	public ListedProductFeature removeListedProductFeature(ListedProductFeature listedProductFeature) {
		getListedProductFeatures().remove(listedProductFeature);
		listedProductFeature.setProductFeature(null);

		return listedProductFeature;
	}

}