package testNg;

import org.testng.annotations.Test;

public class DependentTest {
	@Test(dependsOnMethods={"OpenBrowser"})
	public void SignIn(){
		
	}
	
	@Test
	public void OpenBrowser(){
		
	}
	@Test(dependsOnMethods={"SignIn"})
	public void LogOut(){
		
	}

}
