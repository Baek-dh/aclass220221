package edu.kh.array2.practice;

public class Array2Practice {

	
//	4�� 4�� 2���� �迭�� �����Ͽ� 
//	0�� 0������ 2�� 2�������� 1~10������ ������ ���� �� ���� ��
//	�Ʒ��� ����ó�� ó���ϼ���.
	public void practice4() {
		
		int[][] arr = new int[4][4];
		
		// ��� ���� : ������ �ʴ� Ư�� ���� �̸��� �ٿ���
		final int ROW_LAST_INDEX = arr.length - 1; // �� ������ �ε���
		final int COL_LAST_INDEX = arr[0].length - 1; // �� ������ �ε���
		
		
		for(int row=0 ; row<arr.length ; row++) { // �� �ݺ�
							// ���� ����
			
			for(int col=0 ; col<arr[row].length ;col++) { // �� �ݺ�
						// row��° ���� ���� ����
				
				// ������ ��, ������ ���� �ƴ� ���
				if(row != ROW_LAST_INDEX && col != COL_LAST_INDEX) {
					
					int random = (int)(Math.random() * 10 + 1); // 1~10 ����
					arr[row][col] = random;
					
					// �� ���� ������ ���� ������ ����
					arr[row][COL_LAST_INDEX] += arr[row][col];
					
					// �� ���� ������ �࿡ ������ ����
					arr[ROW_LAST_INDEX][col] += arr[row][col];
					
					// ������ ��� ������ ������ ��, ������ ���� ����
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
					
				}
				
				System.out.printf("%4d", arr[row][col]);
				
				
			} // �� �ݺ� ��
		
			System.out.println(); // �ٹٲ�
			
		} // �� �ݺ� ��
			
	}
	
	
	
	/*�ǽ�����7
	1���� ���ڿ� �迭�� �л� �̸� �ʱ�ȭ�Ǿ� �ִ�.
	3�� 2�� ¥�� 2���� ���ڿ� �迭 2���� ���� ���� �� �Ҵ��Ͽ�
	�л� �̸��� 2���� �迭�� ������� �����ϰ� �Ʒ��� ���� ����Ͻÿ�.
	(ù ��° 2���� �迭�� ��� ����� ��� �� ��° 2���� �迭�� ���� ����)
	String[] students = {"���ǰ�", "������", "�����", "�����", "���̹�", "�ں���", 
	"�ۼ���", "������", "������", "��õ��", "��ǳǥ", "ȫ����"};
	[���� ȭ��]
	== 1�д� ==
	���ǰ� ������
	����� �����
	���̹� �ں���
	== 2�д� ==
	�ۼ��� ������
	������ ��õ��
	��ǳǥ ȫ����
	*/
	public void practice7() {
		String[] students = { "���ǰ�", "������", "�����", "�����", "���̹�", "�ں���", "�ۼ���", "������", "������", "��õ��", "��ǳǥ", "ȫ����" };
	
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		
		int index = 0; // students �迭���� 0 ���� 1�� �����ϸ� �л����� �����ϴ� �뵵�� ����
		
		System.out.println("== 1�д� ==");
		for(int row=0 ; row<arr1.length ; row++) {
			for(int col=0 ; col<arr1[row].length ; col++) {
				
				arr1[row][col] = students[index];
				// students�迭 index ��° �л��� arr1[row][col]�� ����
				
				index++; 
				
				System.out.print(arr1[row][col] + " ");
			}
			System.out.println();// �ٹٲ�
		}
		
		System.out.println("== 2�д� ==");
		for(int row=0 ; row<arr2.length ; row++) {
			for(int col=0 ; col<arr2[row].length ; col++) {
				
				arr2[row][col] = students[index];
				// students�迭 index ��° �л��� arr2[row][col]�� ����
				
				index++; 
				
				System.out.print(arr2[row][col] + " ");
			}
			System.out.println();// �ٹٲ�
		}
		
		
		
		
		
	}
	
	
	
	
	
}
