package test.operator.modle;

import java.util.ArrayList;
import java.util.List;

public class B_TestModle {
	
	private String studuntName;
	private String studuntAddress;
	private int studuntAge;
	private String studuntphoen;
	private List<C_TestModle> list = new ArrayList();
	
	
	
	public B_TestModle() {
	}

	public B_TestModle(String studuntName, String studuntAddress, int studuntAge, String studuntphoen,
			List<C_TestModle> list) {
		this.studuntName = studuntName;
		this.studuntAddress = studuntAddress;
		this.studuntAge = studuntAge;
		this.studuntphoen = studuntphoen;
		this.list = list;
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

	public List<C_TestModle> getList() {
		return list;
	}

	public void setList(List<C_TestModle> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "B_TestModle [studuntName=" + studuntName + ", studuntAddress=" + studuntAddress + ", studuntAge="
				+ studuntAge + ", studuntphoen=" + studuntphoen + ", list=" + list + "]";
	}
	
	
}
