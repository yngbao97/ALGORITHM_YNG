package boj_16235_나무재태크;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class test {

	static Map<int[], List<Integer>> trees;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		trees = new HashMap<>();
		
		for (int i = 0; i < 5; i++) {
			int age = sc.nextInt();
			int[] loc = new int[] {1, 1};
			if (!trees.containsKey(loc)) {
				List<Integer> tree = new ArrayList<>();
				tree.add(age);
				trees.put(loc, tree);
			} else {
				trees.get(loc).add(age);
			}
		}
		
		int[] loc = new int[] {1, 1};
		System.out.println(trees.get(loc));
		System.out.println();

	}

}
