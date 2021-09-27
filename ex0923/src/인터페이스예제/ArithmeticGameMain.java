package 인터페이스예제;

import java.util.Scanner;

public class ArithmeticGameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PlusGame p1 = new PlusGame();
		
		int gameCheck = 0;
		int limit = 0;
		

		
		// 게임 횟수 체크 : 5회
		//while문을 사용하는 경우
		while (true) {
			if(limit>=3) {
				break;
				
			}
			// 1. 난수 생성
			p1.makeRandom();
			if (gameCheck < 5) {
				
//				gameCheck++;
			} else {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			// 2. 문제 생성
			System.out.println(p1.getQuizMsg());
			int answer = sc.nextInt();
			
			
			// 정답 기회 횟수 체크 : 3회
			
			
				
			// 3. 정답인지 체크
			
			if(p1.checkAnswer(answer)) {
				//정답
				gameCheck++;
				
				
			}else {
				//오답
				System.out.println("잘못된 결과. 값을 다시 입력");
				System.out.println(p1.getQuizMsg());
				answer = sc.nextInt();
				
				gameCheck--;
				limit++;
				
				
			}
			
			
			
			
		}
		

//		//for문을 사용하는 경우
//	     int count = 0; // 정답의 개수를 체크하는 역할!
//
//	      // 1. 총 5문제를 제시
//	      for (int i = 0; i < 5; i++) {
//	         // 2. 난수 생성하는 기능
//	         p1.makeRandom();
//	         // 3. 문제 출력
//	         // String quiz = p1.getQuizMsg();
//	         for (int j = 0; j < 3; j++) {
//	            System.out.print(p1.getQuizMsg());
//	            int answer = sc.nextInt();
//	            // 4. 한 문제당 정답을 맞출수 있는 기회는 3번
//	            if (p1.checkAnswer(answer)) {
//	               // 정답을 맞췄다!
//	               count++;
//	               break;
//	            } else {
//	               // 정답을 맞추지 못했다!
//	               System.out.println("오답입니다~");
//	            }
//	         }
//
//	      }
//
//	      // 5. 맞은 정답 횟수를 출력
//	      System.out.println("정답의 개수는 " + count + "개 입니다~");

		
		
		
		
		
		
		
		
		
		
			
		

		// 메시지 출력 :

	}

}
