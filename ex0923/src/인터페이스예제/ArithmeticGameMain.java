package �������̽�����;

import java.util.Scanner;

public class ArithmeticGameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PlusGame p1 = new PlusGame();
		
		int gameCheck = 0;
		int limit = 0;
		

		
		// ���� Ƚ�� üũ : 5ȸ
		//while���� ����ϴ� ���
		while (true) {
			if(limit>=3) {
				break;
				
			}
			// 1. ���� ����
			p1.makeRandom();
			if (gameCheck < 5) {
				
//				gameCheck++;
			} else {
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				break;
			}
			// 2. ���� ����
			System.out.println(p1.getQuizMsg());
			int answer = sc.nextInt();
			
			
			// ���� ��ȸ Ƚ�� üũ : 3ȸ
			
			
				
			// 3. �������� üũ
			
			if(p1.checkAnswer(answer)) {
				//����
				gameCheck++;
				
				
			}else {
				//����
				System.out.println("�߸��� ���. ���� �ٽ� �Է�");
				System.out.println(p1.getQuizMsg());
				answer = sc.nextInt();
				
				gameCheck--;
				limit++;
				
				
			}
			
			
			
			
		}
		

//		//for���� ����ϴ� ���
//	     int count = 0; // ������ ������ üũ�ϴ� ����!
//
//	      // 1. �� 5������ ����
//	      for (int i = 0; i < 5; i++) {
//	         // 2. ���� �����ϴ� ���
//	         p1.makeRandom();
//	         // 3. ���� ���
//	         // String quiz = p1.getQuizMsg();
//	         for (int j = 0; j < 3; j++) {
//	            System.out.print(p1.getQuizMsg());
//	            int answer = sc.nextInt();
//	            // 4. �� ������ ������ ����� �ִ� ��ȸ�� 3��
//	            if (p1.checkAnswer(answer)) {
//	               // ������ �����!
//	               count++;
//	               break;
//	            } else {
//	               // ������ ������ ���ߴ�!
//	               System.out.println("�����Դϴ�~");
//	            }
//	         }
//
//	      }
//
//	      // 5. ���� ���� Ƚ���� ���
//	      System.out.println("������ ������ " + count + "�� �Դϴ�~");

		
		
		
		
		
		
		
		
		
		
			
		

		// �޽��� ��� :

	}

}
