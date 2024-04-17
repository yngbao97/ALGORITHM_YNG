package javaStudy;

public enum Nums {
	// 상수명(값)
	ONE(1),
	TWO(2),
	THREE(3);
	
	// 열거한 상수값의 정의(ONE이면 1, TWO이면 2..이렇게 할당됨)
	final private int num;

	// 인스턴스 생성시 값 할당
	private Nums(int num) {
		this.num = num;
	}
	
	// 값 반환
	public int getNum() {
		return num;
	}
}
