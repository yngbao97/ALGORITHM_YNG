package swea_5653_줄기세포배양;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("홍길동");
		list1.add("임꺾정");

		Object obj = list1;

		ArrayList<Double> list2 = (ArrayList<Double>) obj;
		list2.add(1.0);
		list2.add(2.0);

		System.out.println(list2); // [홍길동, 임꺾정, 1.0, 2.0]

		for(double n : list2) {
		    System.out.println(n);
		}
		
		Set s = new TreeSet<Integer>();
        Set<String> ss = s;              // unchecked warning
        s.add(new Integer(42));          // another unchecked warning
        Iterator<String> iter = ss.iterator();

        while (iter.hasNext())
        {
            String str = iter.next();    // ClassCastException thrown
            System.out.println(str);
        }

	}

}
