package javaStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		
		String[] array = {"Apple", "Banana", "Orange"};
		List<String> stream1 = Arrays.stream(array).collect(Collectors.toList());
		Stream<String> stream2 = Stream.of(array);
		
		Stream<String> stream3 = Stream.generate(() -> "Hello");
		Stream<Integer> stream4 = Stream.iterate(1, n -> n*2).limit(5);
	
		Queue<Integer> queue = new LinkedList<>();
		
		List<Integer>[] adj = new List[3];
		out: for (List<Integer> a : adj) {
			break out;
		}
	}

}
