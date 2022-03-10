package edu.kh.inheritance.model.vo;

public class Person {

	// 필드
	private String name;
	private int age;
	private String nationality; // 국적
	
	// 생성자
	public Person() {} // 기본 생성자
	
	// 매개변수 생성자
	public Person(String name, int age, String nationality) {
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}
	
	// 메서드
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
	
	
	// 상속의 특징 : 코드 추가 및 수정에 용이함
	// (새로운 메서드를 Person에 추가 하였을 때  
	//  Student, Employee가 사용 가능한지 확인)
	public void breath() {
		System.out.println("사람은 코나 입으로 숨을 쉰다.");
	}

	
	
	
	
	
	
	
}
