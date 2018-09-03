package com.itheima.bos.domain.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the T_AREA database table.
 * 
 */
@Entity
@Table(name="T_AREA")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_AREA_ID_GENERATOR", sequenceName="T_AREA_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_AREA_ID_GENERATOR")
	private long id;

	private String areacode;

	private String city;

	private String citycode;

	private String district;

	private String postcode;

	private String province;

	private String shortcode;

	//bi-directional many-to-one association to SubArea
	@OneToMany(mappedBy="area")
	private Set<SubArea> subAreas;

	public Area() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public Set<SubArea> getSubAreas() {
		return this.subAreas;
	}

	public void setSubAreas(Set<SubArea> subAreas) {
		this.subAreas = subAreas;
	}

	public SubArea addSubArea(SubArea subArea) {
		getSubAreas().add(subArea);
		subArea.setArea(this);

		return subArea;
	}

	public SubArea removeSubArea(SubArea subArea) {
		getSubAreas().remove(subArea);
		subArea.setArea(null);

		return subArea;
	}

}