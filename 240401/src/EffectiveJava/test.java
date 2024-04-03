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
		String str2 = new String("육예진");
		
		List<String> list1 = new ArrayList<>();
		list1.add(str1);
		
		System.out.println(list1.contains(str2));
		
		Map<String, String> upper = new HashMap<>();
		upper.put("a", "A");
		upper.equals(upper);
		upper.containsKey(upper);
		
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
