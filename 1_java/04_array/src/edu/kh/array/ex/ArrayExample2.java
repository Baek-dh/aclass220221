package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayExample2 {
	
	// ���� ����  (shallow : ����)
	// -> �ּҸ� �����Ͽ� ���� �ٸ� �� ������
	//    �ϳ��� �迭(�Ǵ� ��ü)�� �����ϴ� ���¸� ����� ���� ���
	public void shallowCopy() {
		
		int[] arr = {1, 2, 3, 4, 5};
		
		// ���� ���� ����
		int[] copyArr = arr; // �ּҸ� ����
		
		System.out.println("�ּ� Ȯ��");
		System.out.println("arr : " + arr);
		System.out.println("copyArr : " + copyArr);
		
		
		// �迭 �� ����
		System.out.println("���� ��");
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		// ���� ������ �迭�� ���� �����غ�
		copyArr[2] = 999;
		
		System.out.println("���� ��");
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		
	}
	
	
	// ���� ����
	// -> ���� �ڷ����� ���ο� �迭�� ����
	//    ���� �迭�� �����͸� ��� �����ϴ� ���
	public void deepCopy() {
		
		int[] arr = {1,2,3,4,5}; // ����
		
		// 1. for���� �̿��� ���� ����
		int[] copyArr1 = new int[arr.length]; // 5ĭ ¥�� �迭 ����
		
		for(int i=0 ; i<arr.length ; i++) {
			copyArr1[i] = arr[i]; 
		}
		
		// 2. System.arraycopy(�����迭, ���� ���� ���� �ε���, 
		//					����迭, ����迭�� ���� ���� �ε���, �������);
		int[] copyArr2 = new int[arr.length];
		System.arraycopy(arr, 0, copyArr2, 0, arr.length);
		
		
		// 3. ������ �迭 ���� ���� = Arrays.copyOf(���� �迭, ������ ����);
		int[] copyArr3 = Arrays.copyOf(arr, arr.length);
		
		
		// �� ���� �� Ȯ��
		copyArr1[4] = 0;
		copyArr2[4] = 999;

		copyArr3[4] = 5000;
		
		// Arrays.toString(�迭��) : �����ϴ� �迭�� �ִ� ��� ���� �ϳ��� ���ڿ��� ����
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("copyArr1 : " + Arrays.toString(copyArr1));
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
		System.out.println("copyArr3 : " + Arrays.toString(copyArr3));
	}
	
	
	// �迭�� �̿��� �ߺ� ������ ���� + ����
	
	public void createLottoNumber() {
		// �ζ� ��ȣ ������
		
		// 1. 1 ~ 45 ���� �ߺ����� ���� ���� 6�� ����
		// 2. ������ ������ ������������ ����
		
		
		// 1) ���� 6���� ������ �迭 ���� �� �Ҵ�
		int[] lotto = new int[6];
		
		// 2) ������ �迭�� ó������ ������ ���� �����ϴ� for�� �ۼ�
		for(int i=0 ; i<lotto.length ; i++) {
			
			// 3) 1 ~ 45 ������ ���� ����
			int random = (int)(Math.random() * 45 + 1);
			//  0.0 <= x < 1.0
			//  0.0 <= x * 45 < 45.0
			//  1.0 <= x * 45 + 1 < 46.0
			//  1 <= (int)(x * 45 + 1) < 46
			
			// 4) ������ ������ ������� �迭 ��ҿ� ����
			lotto[i] = random;
			
			
			// 5) �ߺ� �˻縦 ���� for�� �ۼ�
			for(int x=0 ; x<i ; x++) {
				
				// 6) ���� ������ ������ ���� ����
				//    �� �� ��ҿ� �ִ��� �˻�
				if( random == lotto[x] ) {
					
					i--;
					// i�� 1�� ������ �� ���� ������ �ϳ� �����ȴ�
					// -> �ߺ� ���� �����Ƿ� ������ ���� �ϳ� �� �����ؾߵȴ�.
					// --> i�� �⺻������ 0~5���� 6ȸ �ݺ� ������
					//    i���� ���������� 1 ���ҽ��� 7ȸ �ݺ� �Ǵ� ����� ����.
					
					
					break;
					// ���ʿ��� �ߺ� �����͸� �߰��ϸ�
					// ���� ���� ���� �ʿ䰡 ����
					// -> ȿ�� ����� ���ؼ� �˻��ϴ� for���� ����
				}
				
			}
			
			
		} // for�� ��
		
		// 7) �������� ����
		// -> ����, ����, ����, �� ���
		// --> �ڹٰ� ���� ����� �̸� ���� �����ϰ� ����
		//     Arrays.sort(�迭��) : �迭 �� ������ ������������ ���ĵ�
		
		Arrays.sort(lotto);
		
		
		// ��� ���
		System.out.println( Arrays.toString(lotto) );
		
	}
	
	

}





