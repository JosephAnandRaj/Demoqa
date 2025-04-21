package Practice;

import org.junit.Assert;

public class Booleans {
	
	public boolean method() {
		String car = "benz";
		String bike = "Pulsar";
		return car.contains("benz") && bike.contains("Pulsar");
	}

	public void test() {
		Assert.assertTrue("Bike and car not available", method());
		System.out.println("Test Passed Successfully");
	}
	
	
	public static void main(String[] args) {
		Booleans b = new Booleans();
		b.test();
	}

}
