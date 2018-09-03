package com.itheima.bos.domain.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the T_FIXED_AREA database table.
 * 
 */
@Entity
@Table(name="T_FIXED_AREA")
@NamedQuery(name="FixedArea.findAll", query="SELECT f FROM FixedArea f")
public class FixedArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_FIXED_AREA_ID_GENERATOR", sequenceName="T_FIXED_AREA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_FIXED_AREA_ID_GENERATOR")
	private long id;

	@Column(name="FIXED_AREA_NAME")
	private String fixedAreaName;

	private String telephone;

	//bi-directional many-to-one association to Courier
	@ManyToOne
	@JoinColumn(name="FIXED_AREA_LEADER")
	private Courier courier;

	//bi-directional many-to-one association to SubArea
	@OneToMany(mappedBy="fixedArea")
	private Set<SubArea> subAreas;

	public FixedArea() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFixedAreaName() {
		return this.fixedAreaName;
	}

	public void setFixedAreaName(String fixedAreaName) {
		this.fixedAreaName = fixedAreaName;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Courier getCourier() {
		return this.courier;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
	}

	public Set<SubArea> getSubAreas() {
		return this.subAreas;
	}

	public void setSubAreas(Set<SubArea> subAreas) {
		this.subAreas = subAreas;
	}

	public SubArea addSubArea(SubArea subArea) {
		getSubAreas().add(subArea);
		subArea.setFixedArea(this);

		return subArea;
	}

	public SubArea removeSubArea(SubArea subArea) {
		getSubAreas().remove(subArea);
		subArea.setFixedArea(null);

		return subArea;
	}

}