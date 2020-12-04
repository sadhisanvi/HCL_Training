package com.zooapp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("EXTERNAL_VET")
public class ExternalVet extends VET{
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "VISITING_FEES")
	private double visitingFee;

	
	public ExternalVet(String name, String qualification) {
		super(name, qualification);
	}


	public ExternalVet(String name, String qualification, String country, double visitingFee) {
		super(name, qualification);
		this.country = country;
		this.visitingFee = visitingFee;
	}


	public ExternalVet() {
		super();
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public double getVisitingFee() {
		return visitingFee;
	}


	public void setVisitingFee(double visitingFee) {
		this.visitingFee = visitingFee;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExternalVet [country=");
		builder.append(country);
		builder.append(", visitingFee=");
		builder.append(visitingFee);
		builder.append("]");
		return builder.toString();
	}
	

}
