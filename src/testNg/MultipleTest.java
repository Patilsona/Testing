package testNg;

import org.testng.annotations.Test;

public class MultipleTest {
  @Test(enabled = false)
  public void First() {
	  System.out.println("Test case first--------");
  }
  @Test(priority = 0)
  public void Second(){
	  System.out.println("Test case two--------");
  }
  @Test
  public void Third() {
	  System.out.println("Tets case three---------");
	  
  }
  @Test
  public void Four() {
	  System.out.println("Test case four---------");
  }
}
