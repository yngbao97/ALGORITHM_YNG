package javaStudy;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> stringCollection = new ArrayList<>();
	    stringCollection.add("로타입 살아남을수 있을것인가?!");
	    rawTypeMethod(stringCollection); // 컴파일 에러 발생x
	    objectTypeMethod(stringCollection); //컴파일 에러 발생x
	}
	
	private static void rawTypeMethod(final List stringCollection) {
		stringCollection.add(123);
		System.out.println(stringCollection.get(1));
	}
	
	private static void objectTypeMethod(final List<?> stringCollection) {
//		stringCollection.add(123);
		System.out.println(stringCollection.get(0));
	}

}
