package kh.edu.updown.model.service;

import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {
	
	private Scanner sc = new Scanner(System.in);

	// ���ٿ� ���� ����
	// 1 ~ 100 ���� ���� �� �����ϰ� �� ���ڸ� �����ϰ� ��/�ٿ� ������ ����
	// ���� Ƚ���� ���� �α����� ȸ���� ���� �Ǵ� �ְ� ����� ��� ȸ���� highScore �ʵ� ���� ����
	public void startGame(Member loginMember) {
		
		System.out.println("[Game Start...]");
		
	}

	
	// �� ���� ��ȸ
	// �α����� ����� ���� �� ��й�ȣ�� ������ ������ ������ ȭ�鿡 ���
	public void selectMyInfo(Member loginMember) {
		
		System.out.println("[�� ���� ��ȸ]");
	}

	// ��ü ȸ�� ��ȸ
	// ��ü ȸ���� ���̵�, �̸�, �ְ������� �ⷰ
	public void selectAllMember(List<Member> members) {
		
		System.out.println("[��ü ȸ�� ��ȸ]");
		
		
	}

	// ��й�ȣ ����
	// ���� ��й�ȣ�� �Է� �޾� 
	// ���� ��쿡�� �� ��й�ȣ�� �Է� �޾� ��й�ȣ ����
	public void updatePassword(Member loginMember) {
		
		System.out.println("[��й�ȣ ����]");
		
		
	}

	
	
}
