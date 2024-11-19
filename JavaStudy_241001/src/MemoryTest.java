
public class MemoryTest {
	
    public static void main(String[] args) {
    	
        // 런타임 객체를 통해 메모리 상태를 확인
        Runtime runtime = Runtime.getRuntime();

        // 기본 타입으로 메모리 사용량 측정
        long[] classic = new long[1000000];
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory(); // 메모리 사용 전
        
        for (int i = 0; i < classic.length; i++) {
        	classic[i] = i;
        }
        
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();  // 메모리 사용 후
        System.out.println("기본 타입(long) 메모리 사용량: " + (afterMemory - beforeMemory) + " bytes");

        // 가비지 컬렉션 수행
//        System.gc();
        

        // 박싱된 기본 타입으로 메모리 사용량 측정
        Long[] boxed = new Long[1000000];
        beforeMemory = runtime.totalMemory() - runtime.freeMemory(); // 메모리 사용 전
        
        for (int i = 0; i < boxed.length; i++) {
            boxed[i] = (long) i;
        }
        
        afterMemory = runtime.totalMemory() - runtime.freeMemory();  // 메모리 사용 후
        System.out.println("박싱된 기본 타입(Long) 메모리 사용량: " + (afterMemory - beforeMemory) + " bytes");
    }
}

