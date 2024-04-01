package EffectiveJava;

import java.util.Objects;

public class test {

	public static void main(String[] args) {

		Thread t = new Thread();
		t.equals(t);
		
		Objects.equals(args, t);
	}

}

