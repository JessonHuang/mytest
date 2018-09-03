package com.itheima.bos.domain.base;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.repository.NoRepositoryBean;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the T_STANDARD database table.
 * 
 */
@Entity
@Table(name="T_STANDARD")
@NamedQuery(name="Standard.findAll", query="SELECT s FROM Standard s")
public class Standard implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_STANDARD_ID_GENERATOR", sequenceName="T_STANDARD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_STANDARD_ID_GENERATOR")
	private Long id;

	@Column(name="MAX_LENGTH")
	private BigDecimal maxLength;

	@Column(name="MAX_WEIGHT")
	private BigDecimal maxWeight;

	@Column(name="MIN_LENGTH")
	private BigDecimal minLength;

	@Column(name="MIN_WEIGHT")
	private BigDecimal minWeight;

	private String name;

	//bi-directional many-to-one association to Courier
	@OneToMany(mappedBy="standard")
	@JSONField(serialize=false)
	private Set<Courier> couriers;

	public Standard() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMaxLength() {
		return this.maxLength;
	}

	public void setMaxLength(BigDecimal maxLength) {
		this.maxLength = maxLength;
	}

	public BigDecimal getMaxWeight() {
		return this.maxWeight;
	}

	public void setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight = maxWeight;
	}

	public BigDecimal getMinLength() {
		return this.minLength;
	}

	public void setMinLength(BigDecimal minLength) {
		this.minLength = minLength;
	}

	public BigDecimal getMinWeight() {
		return this.minWeight;
	}

	public void setMinWeight(BigDecimal minWeight) {
		this.minWeight = minWeight;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Courier> getCouriers() {
		return this.couriers;
	}

	public void setCouriers(Set<Courier> couriers) {
		this.couriers = couriers;
	}

	public Courier addCourier(Courier courier) {
		getCouriers().add(courier);
		courier.setStandard(this);

		return courier;
	}

	public Courier removeCourier(Courier courier) {
		getCouriers().remove(courier);
		courier.setStandard(null);

		return courier;
	}

}