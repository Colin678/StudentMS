package com.colin.entity;

import java.io.Serializable;

public class Achievement implements Serializable{
	private String id;
	private String name;
	private double chinese;
	private double math;
	private double english;
	private double sum;
	private double avg;
	
	public Achievement() {
	}

	public Achievement(String id, String name, double chinese, double math, double english, double sum, double avg) {
		this.id = id;
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.sum = sum;
		this.avg = avg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getChinese() {
		return chinese;
	}

	public void setChinese(double chinese) {
		this.chinese = chinese;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
}
