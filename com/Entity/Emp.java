package com.Entity;

public class Emp {
	
	private int eid;
	private String ename;
	private int age;
	private String city;
	
	public Emp() {
		
	}

	public Emp(int eid, String ename, int age, String city) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.age = age;
		this.city = city;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", age=" + age + ", city=" + city + "]";
	}
	
	
	
}
