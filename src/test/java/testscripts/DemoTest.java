package testscripts;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic("Demo Test")
public class DemoTest extends TestBase {

	@Test
	@Story("Story 1")
	@Description("Description of US 1")
	public void m1() {
		System.out.println("HI....1");
	}

	@Test
	@Story("Story 2")
	@Description("Description of US 2")
	public void m2() {
		System.out.println("HI....2");
	}

	@Test
	@Story("Story 3")
	@Description("Description of US 3")
	public void m3() {
		System.out.println("HI....3");
	}

}
