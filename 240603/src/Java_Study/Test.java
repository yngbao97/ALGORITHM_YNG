package Java_Study;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {

		Person p1 = new Person("육예진", 970418);
		Person p2 = new Person("육예진", 970418);
		
		Set<Person> set = new HashSet<>();
		set.add(p1);
		set.add(p2);
		
		System.out.println(set);
	}
}
