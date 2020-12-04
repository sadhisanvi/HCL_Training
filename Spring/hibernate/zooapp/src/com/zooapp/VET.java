package com.zooapp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@DiscriminatorColumn(name = "VET_TYPE")
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class VET implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VET_ID")
	private int vetId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "QUALIFICATION")
	private String qualification;

	public VET(String name, String qualification) {
		super();
		this.name = name;
		this.qualification = qualification;
	}

	public VET() {
		super();
	}

	public int getVetId() {
		return vetId;
	}

	public void setVetId(int vetId) {
		this.vetId = vetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VET [vetId=");
		builder.append(vetId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", qualification=");
		builder.append(qualification);
		builder.append("]");
		return builder.toString();
	}
	
}