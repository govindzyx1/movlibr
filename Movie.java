package com.resteasy.app;
public class Movie 
{
	private int year;
	private String title;
	public Movie(int year, String title) {
		this.year = year;
		this.title = title;
	}
	//setters & getters
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}

