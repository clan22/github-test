package �������̽�����;

import java.util.Random;

public class PlusGame implements IGame {

	Random ran;
	int num1;
	int num2;

	@Override
	public void makeRandom() {
		ran = new Random();
		num1 = ran.nextInt(9) + 1;
		num2 = ran.nextInt(9) + 1;

	}

	@Override
	public String getQuizMsg() {
		// 4 + 6 =
		String a = num1 + " + " + num2 + " = ";
		return a;
	}

	@Override
	public boolean checkAnswer(int answer) {
		if (num1 + num2 == answer) {
			return true;
		} else {
			return false;
		}
		
//		return num1 + num2 == answer; �񱳿����ڴ� ������� boolean�̱� ������ ����

	}


}
