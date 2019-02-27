package demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Car();
		new LambdaTester();
	}

	public static class Car {
		private Car() {
			System.out.println("Hello World!");
		}
	}
	
	public static class LambdaTester {
		// These are supported by functional interface
//		(int a, int b) -> {  return a * b; }
//		() -> System.out.println("Hi");
//		String s -> { System.out.println(s); }
//		(a) -> a;
//		() -> return 100;
		
		Runnable r = () -> System.out.println("Hi");
		Runnable rrr = () -> {if (true);};
		MyOp mop = (a, b) -> a * b;
		
		{
			System.out.println("" + mop.mult(3, 4));
		}
	}
	
}

@FunctionalInterface //Optional
interface MyOp {
	public int mult(int a, int b);
}