package test.operator.modle;

public class B_TestModle {
	
	private String studuntName;
	private String studuntAddress;
	private int studuntAge;
	private String studuntphoen;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void studuntInformation() {
		System.out.printf("\n학생 정보 조회\n\n이름 : %s\n주소 : %s\n나이 : %d\n전화번호 : %s\n"
				,studuntName,studuntAddress,studuntAge,studuntphoen );
	}
	
	
	
	public B_TestModle() {
	}
	public B_TestModle(String studuntName, String studuntAddress, int studuntAge, String studuntphoen) {
		this.studuntName = studuntName;
		this.studuntAddress = studuntAddress;
		this.studuntAge = studuntAge;
		this.studuntphoen = studuntphoen;
	}
	@Override
	public String toString() {
		return "B_TestModle [studuntName = " + studuntName + ", studuntAddress = " + studuntAddress + ", studuntAge = "
				+ studuntAge + ", studuntphoen = " + studuntphoen + "]";
	}
	public String getStuduntName() {
		return studuntName;
	}
	public void setStuduntName(String studuntName) {
		this.studuntName = studuntName;
	}
	public String getStuduntAddress() {
		return studuntAddress;
	}
	public void setStuduntAddress(String studuntAddress) {
		this.studuntAddress = studuntAddress;
	}
	public int getStuduntAge() {
		return studuntAge;
	}
	public void setStuduntAge(int studuntAge) {
		this.studuntAge = studuntAge;
	}
	public String getStuduntphoen() {
		return studuntphoen;
	}
	public void setStuduntphoen(String studuntphoen) {
		this.studuntphoen = studuntphoen;
	}
	
	
}
