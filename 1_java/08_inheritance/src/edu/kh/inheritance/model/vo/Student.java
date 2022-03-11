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
	public Student() {
		
		// Student() ��ü ���� ��
		// ���ο� ��� ���� Person ��ü�� �����ϱ� ����
		// Person ������ ȣ�� �ڵ尡 �ʿ��ϴ�!
		
		// super : ����  <-> sub : ����
		// super == Person
		
		super(); // super() ������
		// �θ��� �����ڸ� ȣ���ϴ� �ڵ�
		// �ݵ�� �ڽ� ������ �ֻ�ܿ� �ۼ��Ǿ�� �Ѵ�!!!
		
		// * super() ������ ������
		//  �ڽ� ��ü�� ���ο� �θ� ��ü�� �����ȴ�!
		
		// * super() ������ ���ۼ� ��
		//  �����Ϸ��� ������ �ܰ迡�� �ڵ����� �߰�����
		
	}
	
	

	// �Ű����� ������
	public Student(String name, int age, String nationality,
				   int grade, int classRoom) {
		
		// ���� ���� �� �� name, age, nationality
		// �θ� �ʵ忡 �����ϱ�
		
		// this.name = name; // (X)
		// ��� ���� �θ��� �ʵ�(name)�� 
		// �ڽ��� �ʵ�ó�� ����Ϸ� ������ ���� �߻�
		
		// ��? �θ��� �ʵ忡 private ���� �����ڰ� �־
		// �ƹ��� ���� ���� �ڽ��̶� �ٸ� ��ü�̱� ������ ���� ������ �Ұ�
		// -> ���� ���� ����� ���
		
		//setName(name);
		//setAge(age);
		//setNationality(nationality);
		// �θ��� setter�� �̿��ϸ� ������ ��ȿ����....
		
		super(name, age, nationality); // �θ� �Ű����� ������ ȣ��

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
	
	
	// toString() �������̵�
	@Override
	public String toString() {
		
		// super ���� ����
		return  super.toString() + " / " + grade  + " / " + classRoom;
	}
	
	
	
	
	
	
}
