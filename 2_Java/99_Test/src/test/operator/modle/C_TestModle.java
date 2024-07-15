package test.operator.modle;

public class C_TestModle {
	private String name;
	private int score;
	public C_TestModle(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public C_TestModle() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "C_TestModle [name=" + name + ", score=" + score + "]";
	}
	

}
