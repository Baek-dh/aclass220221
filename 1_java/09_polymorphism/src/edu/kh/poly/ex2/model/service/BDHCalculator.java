package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;

public class BDHCalculator extends Animal implements Calculator{
						// Ŭ����, �������̽� ���� ��� ����
						// �������̽��� ���� ��� ����

	// extends : Ȯ���ϴ� , implements : �����ϴ�

	// (��)Ŭ���� - (��)Ŭ���� ��� �ÿ��� extends (�߻� Ŭ������ ����)
	
	// (��)�������̽� - (��)Ŭ���� ��� �� implements
	
	@Override
	public int plus(int num1, int num2) {
		return num1 + num2 + MAX_NUM;
	}

	@Override
	public int minus(int num1, int num2) {
		return num1 - num2 + MAX_NUM;
	}

	@Override
	public int multiple(int num1, int num2) {
		return num1 * num2 + MAX_NUM;
	}

	@Override
	public double divide(int num1, int num2) {
		return (double)num1 / num2 + MAX_NUM;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		
	}
}
