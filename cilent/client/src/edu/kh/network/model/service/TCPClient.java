package edu.kh.network.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
	
	public void clientStart() {
		
//		1.������ IP�ּҿ� ������ ���� ��Ʈ��ȣ�� �Ű������� �Ͽ� Ŭ���̾�Ʈ�� ���� ��ü ����
		
		String serverIP = "127.0.0.1"; // loop back ip(�� ��ǻ�͸� ����Ű�� ip�ּ�)
		int port = 8500; // ���������� ��ٸ����ִ� ��Ʈ ��ȣ �ۼ�
		
		// * �ʿ��� ���� ���� *
		Socket clientSocket = null; // ������ ������ Ŭ���̾�Ʈ�� ������ ������ ����
		
		BufferedReader br = null; // ���� -> Ŭ���̾�Ʈ�� �о���� ������Ʈ��
		
		PrintWriter pw = null; // Ŭ���̾�Ʈ -> ������ ����ϴ� ���� ��Ʈ��
		
		
		try {
	//		2.�������� ����� ��Ʈ�� ���� -> ���� ������ �ʿ���
			System.out.println("[Client]");
			
			clientSocket = new Socket(serverIP, port);
					
	//		3.���� ��Ʈ���� ���� ���� ����
			// 2,3�� ���� ����
			br = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );
			pw = new PrintWriter(clientSocket.getOutputStream());
			
	//		4.��Ʈ���� ���� �а� ����
			
			// 4-1) ���� ���� ���� �� 
			//     ������ ����� "[���� ���� ����]" �޼��� �о����
			String message = br.readLine();
			System.out.println("������ ���� ���� �޼��� : " + message);
			
			
			// 4-2) Ŭ���̾�Ʈ -> ������ �޼��� ����
			Scanner sc = new Scanner(System.in);
			System.out.print("�Է� : ");
			String input = sc.nextLine();
			
			pw.println(input);
			pw.flush(); // �о�ֱ�
			
		}catch (Exception e) {
			// UnknownHostException, IOException �� ���� ó��
			e.printStackTrace();
		
		} finally {
	//		5.��� ����	
			try {
				if(pw != null) pw.close();
				if(br != null) br.close();
				if(clientSocket != null) clientSocket.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
