package javaStudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		List<String> c = new ArrayList<>(List.of("1", "2", "3", "4", "5"));
		List<String> c2 = new ArrayList<>(List.of("1", "2", "3", "4", "5"));
			
		for (Iterator<String> i = c.iterator(); i.hasNext(); ) {
			System.out.println(i.next());
		}
		
		Iterator<String> i = c.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		Iterator<String> i2 = c2.iterator();
		while (i.hasNext()) {
			System.out.println(i2.next());
		}
	}
}
