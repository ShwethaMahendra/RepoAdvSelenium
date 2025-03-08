package TestNG;

import org.testng.annotations.Test;

public class SampleTest {
	
	//priority goes to= 1.dependson-->2.invocation-->3.priority
	//JVM will convert @test annotation as main method
	//test automatically gives the output in Alphabetical order, to change that we use priority
	//executing same method with same set of data is called invocationcount
	@Test(priority = -1,invocationCount = 2)//invocationcount will execute the method given multiple times
	public void createProd() {
		
		System.out.println("Product Created");
	}
	
	@Test(dependsOnMethods = "createProd", priority = 0,invocationCount = 2)
	public void prodModified() {
		//to fail it manually
		System.out.println("Product Modified");
	}
	
	@Test(dependsOnMethods = "prodModified",priority = 1)
	public void prodDeleted() {
		System.out.println("Product Deleted");
	}
	
	//if we dont want to execute this method itself 
	@Test(enabled = false)
	public void reAdd() {
		System.out.println("this method will not get executed");
	}
	
	

}
