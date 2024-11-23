package com.mindtree.entities;

public class Student {
	private int id;
	private String name;
	private String Standard;
	private String sName;
	private String address;

	public Student() {

	}

	public Student(int id, String name, String standard, String sName, String address) {
		
		this.id = id;
		this.name = name;
		Standard = standard;
		this.sName = sName;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return Standard;
	}

	public void setStandard(String standard) {
		Standard = standard;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Standard=" + Standard + ", sName=" + sName + ", address="
				+ address + "]";
	}

}
