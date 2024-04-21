package javaStudy;

public class Numbers {
	
	static final int ONE = 1;
	static final int TWO = 2;
	static final int THREE = 3;
	private int x = 10;

	private Numbers() {};
	
	private static class InnerClass_Private {
		void test() {
			Numbers n = new Numbers();
			System.out.println(n.x);
		}
	}

}
