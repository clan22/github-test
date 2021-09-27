package ex0923;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class memberSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ����ý���(ȸ������, �α���, ȸ����������, ȸ����Ϻ���)
		memberDAO dao = new memberDAO();
		
		
		
		
		
		
		
		
		
		System.out.println("����ý��� ���α׷��� �����մϴ�.");
		
		while (true) {
			System.out.print("1. ȸ������ 2. �α��� 3. ȸ���������� 4. ȸ����Ϻ��� 5. ȸ��Ż�� 6. ���� >>>");			
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("--ȸ������--");
				System.out.print("ID �Է� : ");
				String id = sc.next();
				System.out.print("PW �Է� : ");
				String pw = sc.next();
				System.out.print("NICK �Է� : ");
				String nick = sc.next();
				System.out.print("PHONE �Է� : ");
				String phone = sc.next();
				
				//JDBC���Ҹ� �ϴ� Ŭ������ ����� --> DAO
				//   -> �������� �� �ڵ带 �����ϰ� �ϱ� ����
				
				memberVO vo = new memberVO(id, pw, nick, phone);
				
				int cnt = dao.join(vo);//cnt�� ȸ�� ���� ���� ���θ� Ȯ���ϱ� ���ؼ�
				                       // cnt=1�� ���� , cnt=0�� ����
				if(cnt>0) {
					System.out.println("ȸ������ ����!!");
				}else {
					System.out.println("ȸ������ ����!!");
				}
				

			} else if (choice == 2) {
				System.out.println("--�α���--");
				System.out.print("ID �Է� : ");
				String id = sc.next();
				System.out.print("PW �Է� : ");
				String pw = sc.next();
				
				memberVO vo = new memberVO(id, pw);//�����ε��� �̿��� �ߺ����Ƿ� 2��¥���� memberVO�� �������
				memberVO info = dao.login(vo);
				
				if(info != null) {
					System.out.println(info.getNick() + "�α��� ����!!");
					System.out.println(info.getNick() + "ȯ���մϴ�.");
					
				}else {
					System.out.println("�α��� ����..");
					
				}
				
				
			} else if (choice == 3) {
				//id�� ��ġ�ϴ� �� ã�Ƽ� pw, nick, phone�� �Է��� ������ ����
				System.out.println("--ȸ����������--");
				System.out.print("ID �Է� : ");
				String id = sc.next();
				System.out.print("PW �Է� : ");
				String pw = sc.next();
				System.out.print("NICK �Է� : ");
				String nick = sc.next();
				System.out.print("PHONE �Է� : ");
				String phone = sc.next();
				
				memberVO vo = new memberVO(id, pw, nick, phone);
				int cnt = dao.update(vo);
				
				if(cnt>0) {
					System.out.println("ȸ���������� ����!!");
				}else {
					System.out.println("ȸ���������� ����..");
				}

			} else if (choice == 4) {
				System.out.println("--ȸ����Ϻ���--");
				ArrayList<memberVO> list = dao.selectAll();//���� �迭
				for (int i=0; i< list.size(); i++) {
					System.out.println(list.get(i));
					// ��ü �� ��ü�� ����� �� tostring�޼ҵ� ���Ǵ� ��
					// tostring�޼ҵ带 ���������� ������ object�� ������ �ִ� 
					//tostring�޼ҵ尡 ����(�ּҰ��� ��µǰ� ����)

					// tostring�� �������ϰ� �Ǹ� MemberVo�ȿ� �ִ�
					// tostring �޼ҵ尡 ����(�� ���迡 ���� ���)
					
					
				
				}
			} else if(choice == 5){
				//ȸ��Ż�� ���(�޼ҵ�� : delete)
				//���̵�� ��й�ȣ�� �Է� �޾Ƽ�
				//�ش��ϴ� ���̵�� ��й�ȣ�� ��ġ�ϴ� ����� ���� �����ͺ��̽����� ����
				
				System.out.println("--ȸ������--");
				System.out.print("ID �Է� : ");
				String id = sc.next();
				System.out.print("PW �Է� : ");
				String pw = sc.next();

				memberVO vo = new memberVO(id, pw);

				int cnt = dao.delete(vo);
				if (cnt > 0) {
					System.out.println("ȸ��Ż�� ����!!");
				} else {
					System.out.println("ȸ��Ż�� ����!!");
				}
				
				
			}else {
			
				System.out.println("����.");
				sc.close(); //Scanner�� �ݾ��ִ� ���
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
