package ex0923;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class memberSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 멤버시스템(회원가입, 로그인, 회원정보수정, 회원목록보기)
		memberDAO dao = new memberDAO();
		
		
		
		
		
		
		
		
		
		System.out.println("멤버시스템 프로그램을 시작합니다.");
		
		while (true) {
			System.out.print("1. 회원가입 2. 로그인 3. 회원정보수정 4. 회원목록보기 5. 회원탈퇴 6. 종료 >>>");			
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("--회원가입--");
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();
				System.out.print("NICK 입력 : ");
				String nick = sc.next();
				System.out.print("PHONE 입력 : ");
				String phone = sc.next();
				
				//JDBC역할만 하는 클레스를 만든다 --> DAO
				//   -> 유지보수 및 코드를 간결하게 하기 위해
				
				memberVO vo = new memberVO(id, pw, nick, phone);
				
				int cnt = dao.join(vo);//cnt는 회원 가입 성공 여부를 확인하기 위해서
				                       // cnt=1은 성공 , cnt=0은 실패
				if(cnt>0) {
					System.out.println("회원가입 성공!!");
				}else {
					System.out.println("회원가입 실패!!");
				}
				

			} else if (choice == 2) {
				System.out.println("--로그인--");
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();
				
				memberVO vo = new memberVO(id, pw);//오보로딩을 이용한 중복정의로 2개짜리를 memberVO에 만들어줌
				memberVO info = dao.login(vo);
				
				if(info != null) {
					System.out.println(info.getNick() + "로그인 성공!!");
					System.out.println(info.getNick() + "환영합니다.");
					
				}else {
					System.out.println("로그인 실패..");
					
				}
				
				
			} else if (choice == 3) {
				//id와 일치하는 걸 찾아서 pw, nick, phone을 입력한 것으로 수정
				System.out.println("--회원정보수정--");
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();
				System.out.print("NICK 입력 : ");
				String nick = sc.next();
				System.out.print("PHONE 입력 : ");
				String phone = sc.next();
				
				memberVO vo = new memberVO(id, pw, nick, phone);
				int cnt = dao.update(vo);
				
				if(cnt>0) {
					System.out.println("회원정보수정 성공!!");
				}else {
					System.out.println("회원정보수정 실패..");
				}

			} else if (choice == 4) {
				System.out.println("--회원목록보기--");
				ArrayList<memberVO> list = dao.selectAll();//가변 배열
				for (int i=0; i< list.size(); i++) {
					System.out.println(list.get(i));
					// 객체 그 자체를 출력할 때 tostring메소드 사용되는 중
					// tostring메소드를 재정의하지 않으면 object가 가지고 있는 
					//tostring메소드가 사용됨(주소값이 출력되게 설계)

					// tostring을 재정의하게 되면 MemberVo안에 있는
					// tostring 메소드가 사용됨(내 설계에 따라 출력)
					
					
				
				}
			} else if(choice == 5){
				//회원탈퇴 기능(메소드명 : delete)
				//아이디와 비밀번호를 입력 받아서
				//해당하는 아이디와 비밀번호가 일치하는 사용자 정보 데이터베이스에서 삭제
				
				System.out.println("--회원가입--");
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();

				memberVO vo = new memberVO(id, pw);

				int cnt = dao.delete(vo);
				if (cnt > 0) {
					System.out.println("회원탈퇴 성공!!");
				} else {
					System.out.println("회원탈퇴 실패!!");
				}
				
				
			}else {
			
				System.out.println("수정.");
				sc.close(); //Scanner를 닫아주는 기능
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
