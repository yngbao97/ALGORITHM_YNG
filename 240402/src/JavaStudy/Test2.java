package JavaStudy;

public class Test2 {

	public static void main(String[] args) {
		
		
		Creature c = new Creature();
		c.method();
		
		String b = "헬로";
		System.out.println(b.hashCode());		// 1744880
		b = "안녕";
	    System.out.println(b.hashCode());		// 1611021
	    b += "하세요";
	    System.out.println(b.hashCode());		// 803356551
	    
	    System.out.println(b);
	}

}

class Creature {
    private int life = 50;
    Animal a = new Animal();
    
	
    // private class 로, 오로지 Creature 외부 클래스에서만 접근 가능한 내부 클래스로 설정
    private class Animal {
        public String name = "호랑이";

        int getOuter() {
            return life; // 외부 클래스의 private 멤버를 제약 없이 접근 가능
        }
    }

    public void method() {
        Animal animal = new Animal(); 

        // Getter 없이 내부 클래스의 private 멤버에 접근이 가능 하지만
        // 위의 예시코드는 public으로 지정하여 데이터 필드가 노출 되었을때도
        // 문제가 되지 않는것을 보여주기 위해 public으로 하였다.
        System.out.println(animal.name); // 호랑이

        // 내부 클래스에서 외부 클래스이 private 멤버를 출력
        System.out.println(animal.getOuter()); // 50
    }
}

