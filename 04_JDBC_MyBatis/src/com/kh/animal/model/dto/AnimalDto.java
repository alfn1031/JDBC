package com.kh.animal.model.dto;

import java.sql.Date;

public class AnimalDto {
	private String animalId;
	private String animalName;
	private String speciesId;
	private String zoneId;
	private String keeperId;
	private String gender;
	private double weightKg;
	private Date birthDate;
	private Date arrivalDate;
	public AnimalDto() {}
	public AnimalDto(String animalName, String speciesId, String zoneId, String keeperId, String gender,
			double weightKg) {
		this.animalName = animalName;
		this.speciesId = speciesId;
		this.zoneId = zoneId;
		this.keeperId = keeperId;
		this.gender = gender;
		this.weightKg = weightKg;
	}
	public String getAnimalId() {
		return animalId;
	}
	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(String speciesId) {
		this.speciesId = speciesId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getKeeperId() {
		return keeperId;
	}
	public void setKeeperId(String keeperId) {
		this.keeperId = keeperId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getWeightKg() {
		return weightKg;
	}
	public void setWeightKg(double weightKg) {
		this.weightKg = weightKg;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public AnimalDto(String animalId, String animalName, String speciesId, String zoneId, String keeperId,
			String gender, double weightKg, Date birthDate, Date arrivalDate) {
		super();
		this.animalId = animalId;
		this.animalName = animalName;
		this.speciesId = speciesId;
		this.zoneId = zoneId;
		this.keeperId = keeperId;
		this.gender = gender;
		this.weightKg = weightKg;
		this.birthDate = birthDate;
		this.arrivalDate = arrivalDate;
	}
	@Override
	public String toString() {
		return "AnimalDto [animalId=" + animalId + ", animalName=" + animalName + ", speciesId=" + speciesId
				+ ", zoneId=" + zoneId + ", keeperId=" + keeperId + ", gender=" + gender + ", weightKg=" + weightKg
				+ ", birthDate=" + birthDate + ", arrivalDate=" + arrivalDate + "]";
	}
	
}
