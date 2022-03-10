package edu.kh.inheritance.model.vo;

public class Student extends Person{
	// Student 클래스에 Person 클래스 내용을 연장한다
	// == Student 클래스에 Person 클래스 내용(필드, 메서드)을 추가하여 확장한다.

	// *** 상속 ***
	// extends : 확장하다, 연장하다+
	
	// 필드
	private int grade; // 학년
	private int classRoom; // 반
	
	// 생성자
	public Student() {}
	
	// 매개변수 생성자
	public Student(String name, int age, String nationality,
				   int grade, int classRoom) {
		
		this.grade = grade;
		this.classRoom = classRoom;
	}


	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	
	
	
	
}
