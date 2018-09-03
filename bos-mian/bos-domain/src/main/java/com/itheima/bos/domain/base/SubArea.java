package com.itheima.bos.domain.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the T_SUB_AREA database table.
 * 
 */
@Entity
@Table(name="T_SUB_AREA")
@NamedQuery(name="SubArea.findAll", query="SELECT s FROM SubArea s")
public class SubArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_SUB_AREA_ID_GENERATOR", sequenceName="T_SUB_AREA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_SUB_AREA_ID_GENERATOR")
	private long id;

	@Column(name="ASSIST_KEY_WORDS")
	private String assistKeyWords;

	@Column(name="END_NUM")
	private String endNum;

	@Column(name="KEY_WORDS")
	private String keyWords;

	@Column(name="START_NUM")
	private String startNum;

	//bi-directional many-to-one association to Area
	@ManyToOne
	private Area area;

	//bi-directional many-to-one association to FixedArea
	@ManyToOne
	@JoinColumn(name="FIXEDAREA")
	private FixedArea fixedArea;

	public SubArea() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssistKeyWords() {
		return this.assistKeyWords;
	}

	public void setAssistKeyWords(String assistKeyWords) {
		this.assistKeyWords = assistKeyWords;
	}

	public String getEndNum() {
		return this.endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}

	public String getKeyWords() {
		return this.keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getStartNum() {
		return this.startNum;
	}

	public void setStartNum(String startNum) {
		this.startNum = startNum;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public FixedArea getFixedArea() {
		return this.fixedArea;
	}

	public void setFixedArea(FixedArea fixedArea) {
		this.fixedArea = fixedArea;
	}

}