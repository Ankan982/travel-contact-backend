package com.travel.contact.model;

import java.util.List;

public class GetContactDetailResponse {

	private List<Contact> lstContactDetails;
	private String totalQueryCount;
	private String totalWebsiteQueryCount;
	private String otherQueryCount;

	public List<Contact> getLstContactDetails() {
		return lstContactDetails;
	}

	public void setLstContactDetails(List<Contact> lstContactDetails) {
		this.lstContactDetails = lstContactDetails;
	}

	public String getTotalQueryCount() {
		return totalQueryCount;
	}

	public void setTotalQueryCount(String totalQueryCount) {
		this.totalQueryCount = totalQueryCount;
	}

	public String getTotalWebsiteQueryCount() {
		return totalWebsiteQueryCount;
	}

	public void setTotalWebsiteQueryCount(String totalWebsiteQueryCount) {
		this.totalWebsiteQueryCount = totalWebsiteQueryCount;
	}

	public String getOtherQueryCount() {
		return otherQueryCount;
	}

	public void setOtherQueryCount(String otherQueryCount) {
		this.otherQueryCount = otherQueryCount;
	}

}
