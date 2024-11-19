
public class Test {

	public static void main(String[] args) {
		
		// long 타입으로 시간 측정
        long startTime = System.currentTimeMillis();  // 시작 시간
        long sumLong = 0L;
        Runtime runtime = Runtime.getRuntime();
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory(); // 메모리 사용 전
        
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sumLong += i;
        }
        
        long endTime = System.currentTimeMillis();    // 끝난 시간
        System.out.println("long 타입 소요 시간: " + (endTime - startTime) + "ms");		// long 타입 소요 시간: 1194ms
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();  // 메모리 사용 후
        System.out.println("기본 타입(long) 메모리 사용량: " + (afterMemory - beforeMemory) + " bytes");

        
        // Long 타입으로 시간 측정
        startTime = System.currentTimeMillis();       // 시작 시간
        Long sumLongObject = 0L;
        Long[] boxed = new Long[1000000];
        beforeMemory = runtime.totalMemory() - runtime.freeMemory(); // 메모리 사용 전
        
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sumLongObject += i;
        }
        
        endTime = System.currentTimeMillis();         // 끝난 시간
        System.out.println("Long 타입 소요 시간: " + (endTime - startTime) + "ms");		// Long 타입 소요 시간: 3386ms
        afterMemory = runtime.totalMemory() - runtime.freeMemory();  // 메모리 사용 후
        System.out.println("박싱된 기본 타입(Long) 메모리 사용량: " + (afterMemory - beforeMemory) + " bytes");

	}

}
