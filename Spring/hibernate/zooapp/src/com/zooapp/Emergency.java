package com.zooapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMERGENCY")
public class Emergency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMERGENCY_ID")
	private int emergencyId;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "EMERGENCY_CASE")
	private String cases;
	
	@Column(name = "PROGRESS_SO_FAR")
	private String progressSoFar;

	public Emergency(int emergencyId, String type, String cases, String progressSoFar) {
		super();
		this.emergencyId = emergencyId;
		this.type = type;
		this.cases = cases;
		this.progressSoFar = progressSoFar;
	}

	public Emergency() {
	}

	public int getEmergencyId() {
		return emergencyId;
	}

	public void setEmergencyId(int emergencyId) {
		this.emergencyId = emergencyId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCases() {
		return cases;
	}

	public void setCases(String cases) {
		this.cases = cases;
	}

	public String getProgressSoFar() {
		return progressSoFar;
	}

	public void setProgressSoFar(String progressSoFar) {
		this.progressSoFar = progressSoFar;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emergency [emergencyId=");
		builder.append(emergencyId);
		builder.append(", type=");
		builder.append(type);
		builder.append(", cases=");
		builder.append(cases);
		builder.append(", progressSoFar=");
		builder.append(progressSoFar);
		builder.append("]");
		return builder.toString();
	}
	
}
