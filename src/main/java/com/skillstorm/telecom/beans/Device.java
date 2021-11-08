package com.skillstorm.telecom.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DEVICES")
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deviceId;
	
	@Column
	@NotBlank
	private String deviceNumber;
	
	@Column
	@NotNull
	private int planId;
	
	@Column
	@NotNull
	private int planNumber;
	
	@Column
	@NotNull
	private int planCost;

	public Device() {
		
	}


	public Device(int deviceId, @NotBlank String deviceNumber, @NotNull int planId, @NotNull int planNumber,
			@NotNull int planCost) {
		super();
		this.deviceId = deviceId;
		this.deviceNumber = deviceNumber;
		this.planId = planId;
		this.planNumber = planNumber;
		this.planCost = planCost;
	}



	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	
	

	public int getPlanId() {
		return planId;
	}



	public void setPlanId(int planId) {
		this.planId = planId;
	}


	public int getPlanNumber() {
		return planNumber;
	}

	public void setPlanNumber(int planNumber) {
		this.planNumber = planNumber;
	}

	public int getPlanCost() {
		return planCost;
	}

	public void setPlanCost(int planCost) {
		this.planCost = planCost;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deviceId;
		result = prime * result + ((deviceNumber == null) ? 0 : deviceNumber.hashCode());
		result = prime * result + planCost;
		result = prime * result + planId;
		result = prime * result + planNumber;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (deviceId != other.deviceId)
			return false;
		if (deviceNumber == null) {
			if (other.deviceNumber != null)
				return false;
		} else if (!deviceNumber.equals(other.deviceNumber))
			return false;
		if (planCost != other.planCost)
			return false;
		if (planId != other.planId)
			return false;
		if (planNumber != other.planNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceNumber=" + deviceNumber + ", planId=" + planId
				+ ", planNumber=" + planNumber + ", planCost=" + planCost + "]";
	}
	
}