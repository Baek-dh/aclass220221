package kh.edu.updown.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class MainService {

	private Scanner sc = new Scanner(System.in);
	
	// ȸ�� ���Ե� ȸ���� ������ ������ ����Ʈ ����
	private List<Member> members = new ArrayList<Member>();
	
	// ���� �α����� ȸ���� ������ ������ ���� ����.
	private Member loginMember = null; // �α��� X == null,  �α��� O != null
	
	// LoginService ����
	// -> �α��� �� �̿��� �� �ִ� ��ɸ��� ��Ƶ� ��ü
	private LoginService loginService = new LoginService();
	
	
	
	// �޴� ��� �޼ҵ�
	// * �޴� ��� �޼ҵ带 �м��غ�����!
	public void displayMenu() {

		int sel = 0; // �޴� ���ÿ� ����
		
		do {
			try {
				
				System.out.println();
				System.out.println("=== UP/DOWN ���� ===");
				
				
				if(loginMember == null) { // �α����� �Ǿ����� ���� ���
				
					System.out.println("[���� �޴�]");
					System.out.println("1. ȸ������");
					System.out.println("2. �α���");
					System.out.println("0. ����");
					System.out.print("�޴� ���� >> ");
					
					sel = sc.nextInt();
					sc.nextLine(); // �Է� ���� ���๮�� ����
					System.out.println(); // �ٹٲ�
					
					switch(sel) {
					case 1 : signUp(); break;
					case 2 : login(); break;
					case 0 : System.out.println("[���α׷� ����]"); break;
					default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� �������ּ���.");
					}
					
				
				}else { // �α����� �Ǿ��ִ� ���
					
					System.out.println("[�α��� �޴�]");
					System.out.println("1. ��/�ٿ� ���� start");
					System.out.println("2. �� ���� ��ȸ");
					System.out.println("3. ��ü ȸ�� ��ȸ");
					System.out.println("4. ��й�ȣ ����");
					System.out.println("9. �α׾ƿ�");
					System.out.println("�޴� ���� >> ");
					
					sel = sc.nextInt();
					sc.nextLine();
					System.out.println();
					
					
					// ���õ� �޴� ��ȣ�� ���� LoginService���� �˸��� ����� ȣ��
					switch (sel) {
					case 1: loginService.startGame(loginMember); break;
					case 2: loginService.selectMyInfo(loginMember); break;
					case 3: loginService.selectAllMember(members); break;
					case 4: loginService.updatePassword(loginMember); break;
					
					case 9 : System.out.println("[�α׾ƿ� �Ǿ����ϴ�.]"); 
							 loginMember = null; // loginMember �ʵ忡 �ƹ��͵� �����ϰ� ���� ������ �ǹ��ϴ� null�� ����
							 break;
					
					default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� �������ּ���.");
					}
					
				}
				
			}catch (InputMismatchException e) {
				System.out.println("�Է� ������ �ùٸ��� �ʽ��ϴ�. �ٽ� �õ��� �ּ���.");
				sc.nextLine(); // ���ۿ� �����ִ� ���ڿ� ����
			}
		}while(sel != 0);
		
	}
	
	// [ȸ�� ����]
	// ���̵�, ��й�ȣ, �̸��� �Է� �ް�
	// Member��ü�� �����Ͽ� members ����Ʈ�� �߰�
	// ��, �̹� �ߺ��Ǵ� ���̵� �����ϴ� ��� ���� �Ұ�
	public void signUp() { 
		
		System.out.println("[ȸ�� ����]");
		
		
	} 
	
	
	// [�α���]
	// ���̵�, ��й�ȣ�� �Է� �޾� ��ġ�ϴ� ȸ���� members�� ���� ��� �α���
	// ������ "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�." ���
	public void login() {
		
		System.out.println("[�α���]");
		
		
		
	}
	
	
	
	
	
}
