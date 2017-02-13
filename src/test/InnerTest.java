package test;


class Out{
	public static class A{
		class B{
			private B(){
				System.out.println("B");
			}
			
			void bMethod(){
				System.out.println("it is B method");
			}
		}
		
		public B getB(){
			return new B();
		}
	}
	
	private void doMethod(){
		new A().new B().bMethod();
	}
	
	class Achild extends A{
		public void method(){
			new B();
		}
	}
	
}

class Achildd extends Out.A{
	@Override
	public B getB() {
		// TODO Auto-generated method stub
		return super.getB();
	}
}

	

public class InnerTest {
//	Out out = new Out();
//	public A getA(){
//		return out.new A(){
//			@Override
//			public B getB() {
//				// TODO Auto-generated method stub
//				return new B();
//			}
//		};
//	}
}
