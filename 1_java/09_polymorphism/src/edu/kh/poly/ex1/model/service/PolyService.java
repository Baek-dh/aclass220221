package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class PolyService {

	public void ex1() {
		// ������ Ȯ�� ����
		
		// Car ��ü ����
		Car car = new Car();
		// �θ�Ÿ�� �������� = �θ� ��ü
		
		// Tesla ��ü ����
		Tesla tesla = new Tesla();
		// �ڽ�Ÿ�� �������� = �ڽ� ��ü
		
		// ***** ������(��ĳ����) *****
		Car car2 = new Tesla(); // -> ���� �߻� ����
		// Tesla ��ü�� �����ϴ� ������ Ÿ���� Car �̱� ������
		// Tesla ��ü�� Car ��ü�� ��ȭ��.
		
		Car car3 = new Spark();
		// �θ�Ÿ�� �������� = �ڽ� ��ü
		
		
	}
	
}




