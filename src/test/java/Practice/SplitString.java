package Practice;

public class SplitString {
	
	String text = "Joseph:Anand:Raj";
	String text2 = "Jose/Anand/Raj";
	int num = 12345;
	String Address = "Name: Joseph\nEmail: J@123";

	

	
	public void methodA() {
		String[] split = text.split(":");
		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println(split[2]);
 	}
	
	public void methodA1() {
		String [] split = text2.split("/");
		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println(split[2]);
	}
	
	public void methodB() {
		String[] split = text.split(":",2);
		System.out.println(split[0]);
		System.out.println(split[1]);
	}
	
	public void methodC() {
		String[] split = text.split(":",3);
		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println(split[2]);
	}
	
	public void splitLine1() {
		System.out.println(Address);
	}
	
	public void splitLine() {
		String split[] = Address.split("\n");
		System.out.println(split[0]);
		System.out.println(split[1]);

		}
	
	public void methodD() {
		String numStr = String.valueOf(num);
		String[] split = numStr.split("");
		
		for(String part: split) {
			System.out.println(part);
		}
	}
	


	public static void main(String[] args) {
		SplitString s = new SplitString();
			//	s.methodA();
		    //	s.methodA1();
			//	s.methodB();
			//	s.methodC();
			//	s.methodD();
			//	s.splitLine();
				s.splitLine1();



	}

}
