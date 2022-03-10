package edu.kh.inheritance.model.vo;

public class Student extends Person{
	// Student Ŭ������ Person Ŭ���� ������ �����Ѵ�
	// == Student Ŭ������ Person Ŭ���� ����(�ʵ�, �޼���)�� �߰��Ͽ� Ȯ���Ѵ�.

	// *** ��� ***
	// extends : Ȯ���ϴ�, �����ϴ�+
	
	// �ʵ�
	private int grade; // �г�
	private int classRoom; // ��
	
	// ������
	public Student() {}
	
	// �Ű����� ������
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
