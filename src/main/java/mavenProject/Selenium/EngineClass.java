package mavenProject.Selenium;

import java.lang.reflect.Method;

public class EngineClass {

	public static void ExecuteTestCase() {
		String strTestName = Globals.GetData.get("Column2");
		try{
			Class<?> cls = Class.forName("mavenProject.Selenium.TestCases");
			Object obj = cls.newInstance();
			Method method = cls.getDeclaredMethod(strTestName);
			method.invoke(obj);
		}
		catch(Exception E){
			
		}
	}

}
