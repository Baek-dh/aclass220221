package edu.kh.inheritance.model.service;

import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class InheritanceService {

	public void ex1() {
		// 상속 확인
		// - Person을 상속 받은 Student가 Person의 필드, 메소드를 사용할 수 있는가?
		
		Person p = new Person();
		
		//p.name = "홍길동"; // private 때문에 직접 접근 불가
		
		p.setName("홍길동");
		p.setAge(25);
		p.setNationality("대한민국");
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
		
		
		System.out.println("----------------------------");
		
		// Student 객체 생성
		Student std = new Student();
		
		// Student만의 고유한 메서드
		std.setGrade(3); 
		std.setClassRoom(5);
		
		// Person 클래스로 부터 상속 받은 메서드
		std.setName("고길동");
		std.setAge(19);
		std.setNationality("대한민국");
		
		
		System.out.println("-----------------------------");
		Employee emp = new Employee();
		
		// Employee만의 고유 메서드
		emp.setCompany("KH정보교육원");
		
		// Person 클래스로 부터 상속 받은 메서드
		emp.setName("백동현");
		emp.setAge(33);
		emp.setNationality("대한민국");
		
		
		System.out.println("-----------------------");
		
		// 추가된 breath() 메서드 확인하기
		p.breath();
		std.breath();
		emp.breath();
		
	}
}






