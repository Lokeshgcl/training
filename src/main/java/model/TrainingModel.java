package model;

import java.sql.Date;

public class TrainingModel {

	private int trainingID;
	private String trainingName;
	private Date startDate;
	private Date endDate;
	private String contactPersonId;
	private String businisessUnit;
	private String trainingMode;

	public TrainingModel() {
	}

	public TrainingModel(int trainingID, String trainingName, Date startDate, Date endDate, String trainingMode, 
			String businisessUnit, String contactPersonId) {
		this.trainingID = trainingID;
		this.trainingName = trainingName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainingMode = trainingMode;
		this.businisessUnit = businisessUnit;
		this.contactPersonId = contactPersonId;
	}
	
	public TrainingModel(String trainingName, Date startDate, Date endDate, String trainingMode, 
			String businisessUnit, String contactPersonId) {		
		this.trainingName = trainingName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainingMode = trainingMode;
		this.businisessUnit = businisessUnit;
		this.contactPersonId = contactPersonId;
	}

	public int getTrainingID() {
		return trainingID;
	}

	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getTrainingMode() {
		return trainingMode;
	}

	public void setTrainingMode(String trainingMode) {
		this.trainingMode = trainingMode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getContactPersonId() {
		return contactPersonId;
	}

	public void setContactPersonId(String contactPersonId) {
		this.contactPersonId = contactPersonId;
	}

	public String getBusinisessUnit() {
		return businisessUnit;
	}

	public void setBusinisessUnit(String businisessUnit) {
		this.businisessUnit = businisessUnit;
	}

}
