package test;

public class ComplexOperation {
	
	public static class Params {
        private int param1;
        private String param2;
        private boolean param3;

        public Params setParam1(int param1) {
            this.param1 = param1;
            return this;
        }

        public Params setParam2(String param2) {
            this.param2 = param2;
            return this;
        }

        public Params setParam3(boolean param3) {
            this.param3 = param3;
            return this;
        }

        public void validate() {
            // 매개변수 유효성 검사
            if (param1 <= 0) {
                throw new IllegalArgumentException("param1 must be greater than 0");
            }
            if (param2 == null || param2.isEmpty()) {
                throw new IllegalArgumentException("param2 cannot be null or empty");
            }
        }
    }

    public void execute(Params params) {
        // 매개변수 유효성 검사
        params.validate();

        // 설정된 매개변수를 사용하여 작업 수행
        System.out.println("Executing operation with:");
        System.out.println("param1: " + params.param1);
        System.out.println("param2: " + params.param2);
        System.out.println("param3: " + params.param3);
    }

	public static void main(String[] args) {

		ComplexOperation operation = new ComplexOperation();

        Params params = new Params()
                .setParam1(10)
                .setParam2("example")
                .setParam3(true);

        operation.execute(params);
        
	}

}
