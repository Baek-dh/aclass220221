package edu.kh.variable.ex1;

public class VariableExample2 {
	
	public static void main(String[] args) {
		
		/* �ڹ� �⺻ �ڷ��� 8����
		 * 
		 * ���� : boolean(1byte)
		 * ������ : byte(1byte), short(2byte), int(4byte), long(8byte)
		 * �Ǽ��� : float(4byte), double(8byte)
		 * ������ : char(2byte, �����ڵ�)
		 * 
		 * */
		
		
		// ���� ���� : �޸𸮿� ���� ������ ������ �Ҵ� �ϴ� ��.
		// ���� �� ����(����ֱ�) : ������ ���� ���� �ִ� ��
		
		
		// * ī��(��Ÿ) ǥ��� 
		//  ����Ǵ� �� �ܾ� �� �ļ� �ܾ��� ù ���ڸ� �빮�ڷ� ǥ��
		
		boolean booleanData; 
		// �޸𸮿� �� ��(t/f)�� ������ ������ 1byte �Ҵ��ϰ�
		// �Ҵ�� ������ booleanData��� �θ��ڴ�.
		
		booleanData = true; // booleanData ������ true ���� ���� �ֱ�
		System.out.println("booleanData : " + booleanData);
		
		
		byte byteNumber = 127;
		// �޸𸮿� ���� ���� ������ ������ 1byte �Ҵ��ϰ�
		// �Ҵ�� ������ byteNumber��� �θ��ڴ�.
		// ����� byteNumber ������ ó������ 127�� ���� ����.
		//  -->  �ʱ�ȭ : ó�� ������ ���� ���� 
		
		System.out.println("byteNumber : " + byteNumber);
		
		short shortNumber = 32767; // ���� ���� �� �ʱ�ȭ
		
		// ���� �ڷ��� �⺻��! (short, byte�� ���� �ڵ��� ����)
		int intNumber = 2147483647; // ���� ���� �� �ʱ�ȭ
	//  �ڷ���  ������ = ���ͷ�;	
		
		
		// ** ���ͷ� : ������ ���Եǰų� �ۼ� �Ǿ����� �� ��ü
		// + �ڷ����� ���� ���ͷ� ǥ����� �ٸ�.
		
		long longNumber = 10000000000L; // �Ǵ� �ҹ��� l 
		// The literal 10000000000 of type int is out of range 
		
		float floatNumber = 1.2345f; 
		// Type mismatch: cannot convert from double to float
		
		double doubleNumber = 3.141592;
		// double�� �Ǽ��� �߿��� �⺻��
		// (���ͷ� ǥ����� ���� �Ǽ��� double�� �ν�)
		
		
		// ������ ���ͷ� ǥ��� : '' (Ȭ����ǥ)
		// -> ���� �ϳ�
		char ch = 'A'; 
		char ch2 = 66; // B
		// ** char �ڷ����� ���ڰ� ���Ե� �� �ִ� ����
		// - ��ǻ�Ϳ��� ����ǥ�� �����ϰ� �ִµ�
		//   ���ڿ� ���� ������ ���� ����� ���εǾ��ְ� 
		//   'B' ���� �״�ΰ� ���ԵǸ� ������ ���� 66���� ��ȯ�Ǿ� ����
		//   -> �ݴ�� �����ϸ� ������ ���ʿ� 66�̶�� ���ڸ� �����ϴ� ���� ����.
		
		System.out.println("ch : " + ch);
		System.out.println("ch2 : " + ch2);
		
		
		// ���� ��� ��Ģ
		
		// 1. ��ҹ��� ����, �������� X
		int abcdefghijklmnopqrstuvwxyz;
		int abcdefghijklmnopqrstuvwxyZ; // Z �ٸ�
		
		// 2. ����� ��� X
		//double double; 
		
		// 3. ���� ���� X
		//char 1abc;
		
		// 4. Ư������ $, _ �� ��� ����( ������ ���� �ʴ´� )
		int $intNumber; // ������ ������ �����ڰ� ���� �ۼ����� ����
		int int_number; // �ڹٴ� ī��ǥ��� ���
						// _ �ۼ� ǥ����� DB���� ���
		
		// 5. ī�� ǥ���
		// -> ������ �ۼ� �� ���� �ܾ �̾ �ۼ��ϴ� ���
		//    ���� �ʰ� �ļ� �ܾ� ù ���ڸ� �빮�ڷ� �ۼ�.
		char helloWorldAppleBananaTomato;
		
		
		// 6. �������� �� ������ ���� ( ������ ������� ���� )
		int ����1��;
		double �Ǽ�2�� = 3.14;
		System.out.println(�Ǽ�2��);
		
		
		// -----------------------------------
		
		
		int number = 10;
		System.out.println("number : " + number); // 10
		
		number = 20;
		System.out.println("number : " + number); // 20
		
		/*  ���(�׻� ���� ��) : 
		 * - ���� �� ����
		 * - �ѹ� ���� ���ԵǸ� �ٸ� ���� ������ �� ����
		 * - �ڷ��� �տ� final Ű���带 �ۼ� (������ ���ԵǴ� ��)       
		 * 
		 * - ��� ��� ��Ģ : ��� �빮��, ���� �ܾ� �ۼ� �� "_" ���
		 * 
		 * - ����� ����ϴ� ���
		 *  1) ���ϸ� �ȵǴ� ������ ���� ������ ��
		 *  2) Ư���� ���� �ǹ̸� �ο��ϴ� ���
		 * */
		
		final double PI_VALUE = 3.14;
		//PI_VALUE = 2.32222; // ����! ���� �Ұ�
		
		
		final int LEFT_MOVE = -1;
		final int RIGHT_MOVE = 1;
		
		
		System.out.println(1 + 1.3);
		
		
		
		
		
		
		
		
	}
	
}
