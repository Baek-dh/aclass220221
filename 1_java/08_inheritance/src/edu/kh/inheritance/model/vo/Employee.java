package edu.kh.inheritance.model.vo;

public class Employee extends Person{
					// Person 상속 받음

	// 필드
	private String company;
	
	// 기본 생성자
	public Employee() {}

	// 매개변수 생성자
	public Employee(String name, int age, String nationality, String company) {
		
		this.company = company;
	}


	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	
}
