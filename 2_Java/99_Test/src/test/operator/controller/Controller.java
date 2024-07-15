package test.operator.controller;

import java.util.ArrayList;
import java.util.List;

import test.operator.modle.B_TestModle;

public class Controller {
	List<B_TestModle> list = new ArrayList<B_TestModle>();
	B_TestModle studunt = new B_TestModle();
	
	public void insertStudunt(String name, String addr, int age, String phoen) {
		studunt.setStuduntName(name);
		studunt.setStuduntAddress(addr);
		studunt.setStuduntAge(age);
		studunt.setStuduntphoen(phoen);
		list.add(studunt);
		System.out.println(list.get(0));
	}

}
