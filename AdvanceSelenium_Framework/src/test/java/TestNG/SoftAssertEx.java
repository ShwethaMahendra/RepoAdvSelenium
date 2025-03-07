package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	
	@Test
	public void m1() {
		System.out.println("Step1");
		System.out.println("Step2");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(false, true);
		
		System.out.println("Step3");
		System.out.println("Step4");
		//assertAll is mandatory for soft assert in order to apply soft assert or else all steps will get pass
		soft.assertAll();
		
		
	}

}
