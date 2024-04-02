package EffectiveJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class test {

	public static void main(String[] args) {

		Thread t = new Thread();
		t.equals(t);
		
		Objects.equals(args, t);
		
		String str1 = "육예진";
		String str2 = "육예진";
		String str3 = new String("육예진");
		
		str1.equals(str2);
		
		Integer dd = 34;
		Integer ss = 33;
		dd.equals(ss);
		
		List<String> list1 = new ArrayList<>();
		list1.add(str2);
		
		List<Integer> list2 = new ArrayList<>();
		
		list1.contains(list2);
		int[] arr = new int[3];
		
		Map<String, String> upper = new HashMap<>();
		upper.put("a", "A");
		upper.equals(upper);
		list1.equals(list2);
		
		System.out.println(list1.contains(str3));
	}

}

class Rectangle extends Shape{
	int length = 3;
	int width = 5;
}

class Circle extends Shape{
	int radius = 3;
}

abstract class Shape {
}
