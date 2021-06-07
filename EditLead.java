package week5.day2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClass {

	@Test (dataProvider = "getData", dependsOnMethods = "week5.day2.CreateLead.CreateLeadTest")
	public void EditLeadTest (String phNO, String company) throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNO);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.name("submitButton")).click();
		
}

	@DataProvider (name = "getData" , indices = 3)
	public String [][] senData() throws IOException {
			LearnExcel re = new LearnExcel();
	       String[][] data = re.exceData("EditLead");
	       
      return data;
	}
}





