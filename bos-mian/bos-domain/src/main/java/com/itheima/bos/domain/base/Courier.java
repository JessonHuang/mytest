package com.itheima.bos.domain.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the T_COURIER database table.
 * 
 */
@Entity
@Table(name="T_COURIER")
@NamedQuery(name="Courier.findAll", query="SELECT c FROM Courier c")
public class Courier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_COURIER_ID_GENERATOR", sequenceName="T_COURIER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_COURIER_ID_GENERATOR")
	private long id;

	@Column(name="CHECK_PWD")
	private String checkPwd;

	private String company;

	@Column(name="COURIER_NUM")
	private String courierNum;

	private String name;

	private String pda;

	private String telephone;

	//bi-directional many-to-one association to Standard
	@ManyToOne
	@JoinColumn(name="STANDARD")
	private Standard standard;

	//bi-directional many-to-one association to FixedArea
	@OneToMany(mappedBy="courier")
	private Set<FixedArea> fixedAreas;

	public Courier() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCheckPwd() {
		return this.checkPwd;
	}

	public void setCheckPwd(String checkPwd) {
		this.checkPwd = checkPwd;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCourierNum() {
		return this.courierNum;
	}

	public void setCourierNum(String courierNum) {
		this.courierNum = courierNum;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPda() {
		return this.pda;
	}

	public void setPda(String pda) {
		this.pda = pda;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Standard getStandard() {
		return this.standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Set<FixedArea> getFixedAreas() {
		return this.fixedAreas;
	}

	public void setFixedAreas(Set<FixedArea> fixedAreas) {
		this.fixedAreas = fixedAreas;
	}

	public FixedArea addFixedArea(FixedArea fixedArea) {
		getFixedAreas().add(fixedArea);
		fixedArea.setCourier(this);

		return fixedArea;
	}

	public FixedArea removeFixedArea(FixedArea fixedArea) {
		getFixedAreas().remove(fixedArea);
		fixedArea.setCourier(null);

		return fixedArea;
	}

}