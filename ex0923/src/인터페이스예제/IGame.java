package 인터페이스예제;

public interface IGame {
	
	//작업 설계도 
	//랜덤한 수를 생성
	public void makeRandom();
	
	// 퀴즈를 생성하는 기능
	public String getQuizMsg();
	
	//정답을 체크하는 기능
	public boolean checkAnswer(int answer);

	
	
	
	
	
	
	

}
