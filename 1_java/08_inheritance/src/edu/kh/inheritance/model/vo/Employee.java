package edu.kh.inheritance.model.vo;

public class Employee extends Person{
					// Person ��� ����

	// �ʵ�
	private String company;
	
	// �⺻ ������
	public Employee() {}

	// �Ű����� ������
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
