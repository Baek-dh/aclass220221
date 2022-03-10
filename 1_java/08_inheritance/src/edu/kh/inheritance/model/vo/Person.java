package edu.kh.inheritance.model.vo;

public class Person {

	// �ʵ�
	private String name;
	private int age;
	private String nationality; // ����
	
	// ������
	public Person() {} // �⺻ ������
	
	// �Ű����� ������
	public Person(String name, int age, String nationality) {
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}
	
	// �޼���
	// getter / setter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	// ����� Ư¡ : �ڵ� �߰� �� ������ ������
	// (���ο� �޼��带 Person�� �߰� �Ͽ��� ��  
	//  Student, Employee�� ��� �������� Ȯ��)
	public void breath() {
		System.out.println("����� �ڳ� ������ ���� ����.");
	}

	
	
	
	
	
	
	
}
