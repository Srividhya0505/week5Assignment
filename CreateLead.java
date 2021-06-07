package week5.day2;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {

	@Test (dataProvider = "getData", invocationCount=3)
	public  void CreateLeadTest(String company, String fName, String LName, String phNO) {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNO);
		driver.findElement(By.name("submitButton")).click();
		
}

	@DataProvider (name = "getData", indices = {0, 3, 5})
	public String [][] senData() throws IOException {
			LearnExcel re = new LearnExcel();
	       String[][] data = re.exceData("TestData");
	       
      return data;
      
	}	
	
	

}






