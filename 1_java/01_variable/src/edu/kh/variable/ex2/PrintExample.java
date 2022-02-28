package edu.kh.variable.ex2;

public class PrintExample {
	public static void main(String[] args) {
		
		// System.out.println() : �� �� ��� (��� �� �ٹٲ� ����)
		// System.out.print()   : �ܼ� ��� (����� �ٹٲ� X)
		
		System.out.println("�׽�Ʈ1");
		System.out.println("�׽�Ʈ2");
		
		System.out.print("�׽�Ʈ3");
		System.out.println();	// ���� ���� println (�ٹٲ�)
		System.out.print("�׽�Ʈ4");
		
		// System.out.printf() : ��µ� ���ڿ� ������ �������� �����ϴ� ��±���
		
		System.out.println();
		
		int iNum1 = 10;
		int iNum2 = 5;
		
		// 10 + 5 = 15
		System.out.println( iNum1 + " + " + iNum2 + " = " + (iNum1 + iNum2) );
		
		//System.out.printf("����", ���Ͽ� �� ��); 
		System.out.printf("%d + %d = %d\n", iNum1, iNum2, iNum1 + iNum2);
		
		
		// 10 + 10 * 5 / 2 = 35
		System.out.println(iNum1 + " + " + iNum1 + " * " + iNum2 + " / 2 = " + (iNum1 + iNum1 * iNum2 / 2));
		System.out.printf("%d + %d * %d / 2 = %d\n", iNum1, iNum1, iNum2, iNum1 + iNum1 * iNum2 / 2);
		
		
		// ���� ����
		int iNum3 = 3;
		System.out.printf("%d\n", iNum3);
		System.out.printf("%5d\n", iNum3); // 5ĭ ���� Ȯ�� �� ������ ����
		System.out.printf("%-5d\n", iNum3); // 5ĭ ���� Ȯ�� �� ���� ����
		
		// �Ҽ��� �ڸ� ���� (�ݿø�ó��)
		System.out.printf("%f\n", 10 / 4.0);
		System.out.printf("%.2f\n", 10 / 4.0);
		System.out.printf("%.0f\n", 10 / 4.0);
		
		// ����, ���ڿ�, boolean
		boolean isTrue = false;
		char ch = '��';
		String str = "����Ŀ�";  // String�� ������(�⺻�ڷ����� �� ������)
		
		// '' : char ���ͷ� ǥ���
		// "" : String ���ͷ� ǥ���
		
		System.out.printf("%b / %c / %s\n", isTrue, ch, str );
		
		// escape ���� : �Ϲ� ���ڰ� �ƴ� Ư�� ���� ǥ��
		System.out.println("\\o/"); // �齽���� ��� ���
		
		System.out.println("a\tb\tc\td"); // tab ���
		
		System.out.println("��\n\n\n\n��"); // ����(�ٹٲ�) ����
		
		System.out.println( " \" " ); // �ֵ���ǥ �ܼ� ���� ���
		
		System.out.println( " \' " ); // Ȭ����ǥ �ܼ� ���� ���
		
		System.out.println("\u0041"); // �����ڵ�(16����)��ȣ�� ���
		
	}
}
