package swea_5653_줄기세포배양;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class JavaStudy {

	public static void main(String[] args) {

		
		List<Integer> Nums = new ArrayList<>(List.of(2, 3, 4, 5));
		
		// map 메서드에 직접 람다식 구현부를 작성한 예시
		List<Integer> newNums1 = Nums.stream().map(t -> t*2).toList();
		
		// map 메서드 람다식 구현부에 UnaryOperator를 사용한 예시
		UnaryOperator<Integer> getDouble = t -> t*2;
		List<Integer> newNums2 = Nums.stream().map(t -> getDouble.apply(t)).toList();

		System.out.println(newNums1);  // [4, 6, 8, 10]
		System.out.println(newNums2);  // [4, 6, 8, 10]
	}

}
