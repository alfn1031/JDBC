package com.kh.species.model.dto;

public class SpeciesDto {
	private String speciesId;
	private String speciesName;
	private String speciesClass;
	public SpeciesDto() {
		super();
	}
	public SpeciesDto(String speciesName, String speciesClass) {
		super();
		this.speciesName = speciesName;
		this.speciesClass = speciesClass;
	}
	public SpeciesDto(String speciesId, String speciesName, String speciesClass) {
		super();
		this.speciesId = speciesId;
		this.speciesName = speciesName;
		this.speciesClass = speciesClass;
	}
	public String getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(String speciesId) {
		this.speciesId = speciesId;
	}
	public String getSpeciesName() {
		return speciesName;
	}
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	public String getSpeciesClass() {
		return speciesClass;
	}
	public void setSpeciesClass(String speciesClass) {
		this.speciesClass = speciesClass;
	}
	@Override
	public String toString() {
		return "SpeciesDto [speciesId=" + speciesId + ", speciesName=" + speciesName + ", speciesClass=" + speciesClass
				+ "]";
	}
	
	

}
