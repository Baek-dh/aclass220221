package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;
//import edu.kh.oop.cls.model.vo.TestVO;
// The type edu.kh.oop.cls.model.vo.TestVO is not visible

public class ClsService extends Student{
						// �θ� Student�� ��� ����

	public void ex1() {
		
		// Ŭ���� ���� ������ Ȯ���ϱ�
		
		Student std = new Student();
		// public class�� Student�� import ����
		
		//TestVO test = new TestVO();
		// (default) class�� TestVO�� import �Ұ� (�ٸ� ��Ű��)
		
		System.out.println("�ٸ� ��Ű��");
		
		System.out.println(std.v1);
		// �ٸ� ��Ű�������� ���� ������ public�� ���� X
		
//		System.out.println(std.v2);
//		System.out.println(std.v3);
//		System.out.println(std.v4);
		
		// ��� ���迡�� ���� ���� ����
		System.out.println(v1);
		System.out.println(v2); // protected ���� ���� ����
		//System.out.println(v3);
		//System.out.println(v4);
		
	}
	
	
	public void ex2() {
		
		// static �ʵ� Ȯ�� ����
		
		// �л� ��ü 2�� ����
		Student std1 =  new Student();
		Student std2 =  new Student();
		
		// �л� ��ü�� name ����
		std1.setName("ȫ�浿");
		std2.setName("�迵��");
		
		// ���� ���
		System.out.println(std1.schoolName); // public �̱� ������ ���� ���� ����
		System.out.println(std1.getName());
		
		System.out.println(std2.schoolName); // public �̱� ������ ���� ���� ����
		System.out.println(std2.getName());
		
		// schoolName ����
		std1.schoolName = "KH����������";
		System.out.println("���� �� std1 : " + std1.schoolName); // KH����������
		System.out.println("std2 : " + std2.schoolName); // KH����б� (X) -> KH����������
		
		
		// std3 ����
		Student std3 = new Student();
		System.out.println("std3 : " + std3.schoolName);
		
		System.out.println(std3.getName());
		
		
		// schoolName�� ������� �ߴ� ���� -> ����� �ۼ����� �ʾƼ�
		
		// *** static�� ���� �ʵ�(����)�� Ŭ������.���������� �����. *** 
		Student.schoolName = "KH";
		System.out.println("Student.schoolName : " + Student.schoolName);
		
		
		/* static 
		 * 
		 * 1) ���� �޸� ���� (�Ǵ� ���� �޸� ����) �̶�� ��.
		 * 
		 *  why? ���α׷� ���� �� static�� ���� �ڵ���� ��� 
		 *  static ������ �����ǰ�, 
		 *  ���α׷��� ����� �� ���� ������� ����. (����)
		 *  �׸��� static ������ ������ ������ ��𼭵��� ������ �� �ִ�. (����)
		 * 
		 * 2) ��� ��� :  Ŭ������.������
		 * 
		 * */
		
		
		
	}
	
	
	
	
	
	
	
	
}




