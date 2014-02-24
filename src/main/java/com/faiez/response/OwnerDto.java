package com.faiez.response;

import java.util.List;

/**
 * Created by faiez.elleuch on 24/02/14.
 */
public class OwnerDto {

	int 	iTotalRecords;

	int 	iTotalDisplayRecords;

	String 	sEcho;

	String sColumns;

	List<OwnerLigne> aaData;


	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	public List<OwnerLigne> getAaData() {
		return aaData;
	}

	public void setAaData(List<OwnerLigne> aaData) {
		this.aaData = aaData;
	}

}
