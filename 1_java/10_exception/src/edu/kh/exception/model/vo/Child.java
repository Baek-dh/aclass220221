package edu.kh.exception.model.vo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Child extends Parent{

	@Override
	public void method() throws FileNotFoundException {
								// FileNotFoundException
		// �������̵� ��
		// ���ܴ� ���ų� �� ���� ����
		// * ���� ���� == ��ü���� ����
		
		// FileNotFoundException ��
		// IOException�� �ڽ� �����̹Ƿ� �������̵� ����!
		
		// Exception(��� ������ �θ�)��
		// IOException�� �θ� �����̹Ƿ� �������̵� �Ұ�....
		
		
		System.out.println("�������̵��� �ڽ� �޼���");
	}
	
}
