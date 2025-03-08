package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	
	//Assertion 
		//2 types of Assertion----->HardAssert and SoftAssert
		//HardAssert:-
		//* HarsAssert is Static in nature
		//* In HardAssert when ever @Test/Assert is failed, it stops the execution in same line.
		//* If HardAssert is fail throws AssertError Exception
		//* HardAssert is used only for mandatory fields
	
	
	@Test
	public void m1() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals("A", "A");
		System.out.println("Step3");
		System.out.println("Step4");
	}

	@Test
	public void m2() {
		String exp = "Shwetha";
		String act = "shwetha";
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void m3() {
		int a = 10;
		int b = 10;
	Assert.assertEquals(b, a, "not equal");
	System.out.println("Both are equal");
	}
	
	@Test
	public void m4() {
		int a = 10;
		int b = 20;
		Assert.assertEquals(b, a, "not equal");
		System.out.println("Both are equal");
	}
	
	@Test
	public void m5() {
		int a= 10;
		int b=20;
		Assert.assertNotEquals(b, a, "Both are Equal");
		System.out.println("Both are not equal");
		
	}

	@Test
	public void m6() {
		int a=10;
		int b=10;
		Assert.assertNotEquals(b, a, "Both are equal");
		System.out.println("Not equal");
	}
	
	@Test
	public void m7() {
		String exp = "Qspider";
		String act = "Qspider";
		Assert.assertTrue(act.equalsIgnoreCase(exp), "AssertNotTrue");
		System.out.println("AssertIsTrue");
	}

	@Test
	public void m8() {
		String exp = "Qspider";
		String act = "Pspider";
		Assert.assertTrue(act.equalsIgnoreCase(exp), "AssertNotTrue");
		System.out.println("AssertIsTrue");
	}
	
	@Test
	public void m9() {
		String exp = "Qspider";
		String act = "Pspider";
		Assert.assertFalse(act.equalsIgnoreCase(exp), "Assert fail");
		System.out.println("Assert pass");
	}
	
	@Test
	public void m10() {
		String exp = "Qspider";
		String act = "Qspider";
		Assert.assertFalse(act.equalsIgnoreCase(exp), "Assert fail, they are equal");
		System.out.println("Assert pass, they are not equal");
	}
	
	@Test
	public void m11() {
		String s = null;
		Assert.assertNull(s, "Assert not null");
		System.out.println("Assert is null");
	}
	
	@Test
	public void m12() {
		String s="Shwetha";
		Assert.assertNull(s, "Asset string is not null");
		System.out.println("Assert string is null");
	}

	@Test
	public void m13() {
		String s= "Shwetha";
		Assert.assertNotNull(s, "Assert is null");
		System.out.println("Assert string is not null");
	}
	
	@Test
	public void m14() {
		String exp= "Qspider";
		String act="Qspider";
		Assert.assertSame(act, exp, act);
		System.out.println("Assert string is not null");
	}
	
	@Test
	public void m15() {
		String exp="Qspider";
		String act="Qspider";
		Assert.assertSame(act, exp, "Assert is not same");
		System.out.println("Asserts are same");
	}
	
	@Test
	public void m16() {
		String exp="Qspider";
		String act="Pspider";
		Assert.assertNotSame(act, exp, "Assert is same");
		System.out.println("Assert is not same");
	}
	
	@Test
	public void m17() {
		Assert.fail("I am failing the TestScript");
	}
}
