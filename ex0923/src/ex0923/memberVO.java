package ex0923;

public class memberVO {
	//id, pw, nick, phone를 한번에 묶어주는 클래스 
	
	private String id;
	private String pw;
	private String nick;
	private String phone;
	
	
	
	public memberVO(String id, String pw, String nick, String phone) {		
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.phone = phone;
	}
	
	
	
	
	
	public memberVO(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
	}





	@Override
	public String toString() {
		return "memberVO [id=" + id + ", pw=" + pw + ", nick=" + nick + ", phone=" + phone + "]";
	}



	public memberVO() {//기본 생성자
		
	}
	
	



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}
