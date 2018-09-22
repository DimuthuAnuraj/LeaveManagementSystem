package testpackage;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_01 {
	
  @Test
  public void addtest1() {
	  System.out.println("------------test method1-----------");
	  assertTrue(false);
  }
  
  @Test
  public void addtest2() {
	  System.out.println("------------test method2-----------");
	  assertTrue(true);
  }
  
  @Test
  public void addtest3() {
	  System.out.println("------------test method3-----------");
	  assertEquals(true, false);
  }
  
  
  @AfterMethod
  public void aftermethod() {
	  System.out.println("------------test aftermethod-----------");
  }
  
  @BeforeMethod
  public void beforemethod() {
	  System.out.println("------------test beforemethod-----------");
  }
	  
  @BeforeClass
  public void beforeclass() {
	  System.out.println("------------test beforeaclass-----------");
  }
  
  @AfterClass
  public void afterclass() {
	  System.out.println("------------test afteraclass-----------");
  }
  
  @BeforeTest
  public void BeforeTest() {
	  System.out.println("------------test BeforeTest-----------");
  }
  
  @AfterTest
  public void AfterTest() {
	  System.out.println("------------test AfterTest-----------");
  }
  
}
