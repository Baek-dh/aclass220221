package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService { // Ŭ����

	// �Ӽ�(�ʵ�)
	private Scanner sc = new Scanner(System.in);
	// System.in : �ڹٿ��� �⺻������ �����ص� �Է� ��ġ(Ű����)
	
	private Member memberInfo = null; // ������ ȸ���� ������ ������ ����
	private Member loginMember = null; // �α����� ȸ���� ������ ������ ����
	
	
	
	// ���(������, �޼���)
	public MemberService() { } // �⺻ ������
	
	
//	***�޼��� �ۼ���***
	
// 	[���� ������]  [�����]      ��ȯ��    �޼ҵ��([�Ű�����]) { }
//	public		    static     �⺻�ڷ���
//	protected       final      ������(�迭, Ŭ����)
//	(default)      abstract       void
//	private      static final
	
	
	// ** ��ȯ�� void **
	// - ��ȯ(return)�̶�? �޼��� ���� �� ȣ��η� ���ư��� ��
	// - ��ȯ �� : ���� ���鼭 ������ ��� ��
	// - ��ȯ �� : ��ȯ ���� �ڷ���
	//    -> void : �������� ��(��ȯ ��)�� ����
	
	public void displayMenu() { // �޴� ȭ�� ��� ���
		
		int menuNum = 0; // �޴� ���ÿ� ����
		
		do { // �� ���� ������ �ݺ�
			
			System.out.println("===== ȸ�� ���� ���� ���α׷� v1 =====");
			System.out.println("1. ȸ�� ����");
			System.out.println("2. �α���");
			System.out.println("3. ȸ�� ���� ��ȸ");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("0. ���α׷� ����");
			
			System.out.print("�޴� �Է� >> ");
			menuNum = sc.nextInt(); // �ʵ忡 �ۼ��� Scanner sc ���
			sc.nextLine(); // �Է� ���ۿ� ���� ���� ���� ����
			
			switch(menuNum) {
			case 1 :  System.out.println(  signUp()  );  break;
				// ���� Ŭ���� ���ο� �ִ� �ʵ�, �޼���� �̸��� �ҷ��� ȣ�� ����!!
				// signUp() �޼��带 ȣ���Ͽ� ���� �� ��ȯ ���� ���� ���.
			
			case 2 :  System.out.println( login() );  break;
			case 3 :  break;
			case 4 :  break;
			
			case 0 : System.out.println("���α׷��� �����մϴ�..."); break;
			
			default : System.out.println("�߸� �Է� �ϼ̽��ϴ�. �ٽ� �Է� ���ּ���.");
			}
			
			
		}while(menuNum != 0); // menuNum�� 0�̸� �ݺ� ����
	
	}
	
	
	// ȸ�� ���� ���
	public String signUp() { // his method must return a result of type String
		// (��ȯ��)
		// �ش� �޼ҵ尡 ������ ȣ���� ������ ���ư� ��
		// void : ��ȯ�� ���� ����
		// String : String �ڷ��� ���� ������ ���ư���.
		
		System.out.println("\n***** ȸ�� ���� *****");
		
		System.out.print("���̵� : ");
		String memberId = sc.next(); // user01
		
		System.out.print("��й�ȣ : ");
		String memberPw = sc.next();
		
		System.out.print("��й�ȣ Ȯ�� : ");
		String memberPw2 = sc.next();
		
		System.out.print("�̸� : ");
		String memberName = sc.next();
		
		System.out.print("���� : ");
		int memberAge = sc.nextInt();
		
		
		// ��й�ȣ, ��й�ȣ Ȯ���� ��ġ�ϸ� ȸ������
		// ��ġ���� ������ ȸ������ ����
		if( memberPw.equals(memberPw2) ) { // ��ġ�ϴ� ���
			
			// �Է� ���� ������ �̿��ؼ� Member��ü�� ������ ��
			// ������ ��ü�� �ּҸ� �ʵ忡 �ִ� memberInfo�� ����
			memberInfo = new Member(memberId, memberPw, memberName, memberAge);
			
			return "ȸ�� ���� ����!!";
			
			// return : ���� �޼ҵ带 �����ϰ� ȣ���� ������ ���ư�
			
			// return ��; : ȣ���� ������ ���ư� �� ���� ������ ��.
			
		}else { // ��ġ���� �ʴ� ���
			
			return "ȸ�� ���� ����!!(��й�ȣ ����ġ)";
			
		}
		
	}
	
	
	// �α��� �޼���(���)
	public String login() {
		
		System.out.println("\n***** �α��� *****");
		
		// ȸ�� ������ �ߴ��� ���� Ȯ��
		// == memberInfo�� ��ü�� �����ϰ� �ִ��� Ȯ��
		
		if(memberInfo == null) { // ȸ�� ������ ���� ���� ���
			// null : �ƹ��͵� �����ϰ� ���� ����
			return "ȸ�� ���Ժ��� ���� ���ּ���.";
		}
		
		
		System.out.print("���̵� �Է� : ");
		String memberId = sc.next();
		
		System.out.print("��й�ȣ �Է� : ");
		String memberPw = sc.next();
		
		// ȸ�� ���� ���� (memberInfo�� �����ϴ� Member ��ü)����
		// ����� ���̵�, ��й�ȣ��
		// �Էµ� ���̵�, ��й�ȣ�� ������ "�α��� ����"
		// �ƴϸ� "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�".
		
		// ���̵�, ��й�ȣ�� ��� ��ġ�� ���
		if(  memberId.equals(memberInfo.getMemberId())  && 
			 memberPw.equals( memberInfo.getMemberPw() ) ) {
			// �Է� ���� memberId��
			// memberInfo �ʵ忡�� ���� ���� Member��ü�� memberId�� ������ Ȯ��
			
			loginMember = memberInfo;
			// ȸ�� ���� ������ loginMember�� �����Ͽ� 
			// � ȸ���� �α��� �ߴ����� ������ �� �ְ� ��.
			
			return loginMember.getMemberName() + "�� ȯ���մϴ�.";
		
		} else {
			
			return "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
