package testNg;

import org.testng.annotations.Test;

public class Grouping {

	@Test(groups = { "CAR Group" })
	public void car1() {

	}

	@Test(groups = { "CAR Group" })

	public void car2() {

	}

	@Test(groups = { "PLANE Group" })
	public void plane1() {

	}

	@Test(groups = { "PLANE Group" })
	public void plane2() {

	}
	@Test(groups ={"CAR Group" , "JET"})
	public void plane3() {

	}

}
