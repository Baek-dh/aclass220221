package edu.kh.inheritance.model.service;

import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class InheritanceService {

	public void ex1() {
		// ��� Ȯ��
		// - Person�� ��� ���� Student�� Person�� �ʵ�, �޼ҵ带 ����� �� �ִ°�?
		
		Person p = new Person();
		
		//p.name = "ȫ�浿"; // private ������ ���� ���� �Ұ�
		
		p.setName("ȫ�浿");
		p.setAge(25);
		p.setNationality("���ѹα�");
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
		
		
		System.out.println("----------------------------");
		
		// Student ��ü ����
		Student std = new Student();
		
		// Student���� ������ �޼���
		std.setGrade(3); 
		std.setClassRoom(5);
		
		// Person Ŭ������ ���� ��� ���� �޼���
		std.setName("��浿");
		std.setAge(19);
		std.setNationality("���ѹα�");
		
		
		System.out.println("-----------------------------");
		Employee emp = new Employee();
		
		// Employee���� ���� �޼���
		emp.setCompany("KH����������");
		
		// Person Ŭ������ ���� ��� ���� �޼���
		emp.setName("�鵿��");
		emp.setAge(33);
		emp.setNationality("���ѹα�");
		
		
		System.out.println("-----------------------");
		
		// �߰��� breath() �޼��� Ȯ���ϱ�
		p.breath();
		std.breath();
		emp.breath();
		
	}
}






