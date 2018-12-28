package mavenProject.Selenium;

import org.testng.annotations.Test;

public class TestCases {
	
	TestCaseExecution TE = new TestCaseExecution();
	
	
	@Test
	public void Application_Navigation(){
		TE.App_Navigation();
	}
	
	@Test
	public void Strudent_Enrollment(){
		TE.Enroll_Process();
	}
	
	
	
/*	@Test
	public void Column2Value1(){
		TE.Column2Value1();
	}
	
	@Test
	public void Column2Value2(){
		TE.Column2Value2();
	}
	
	*/
}
