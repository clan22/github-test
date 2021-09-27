package 인터페이스예제;

public class GameDummy implements IGame {

	@Override
	public void makeRandom() {
		// TODO Auto-generated method stub
		// 난수 생성기능

	}

	@Override
	public String getQuizMsg() {
		// TODO Auto-generated method stub
		// 퀴즈 생성
		return "2+3=";
	}

	@Override
	public boolean checkAnswer(int answer) {
		// TODO Auto-generated method stub
		// 정답 체크
		return false;
	}

}
