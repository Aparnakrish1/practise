package MMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMPViewReports {

	WebDriver driver;
	public MMPViewReports(WebDriver driver){
		this.driver=driver;
	}
	public boolean Reports() throws InterruptedException{
		driver.findElement(By.linkText("Profile")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("View Reports")).click(); // Clicking View history
		boolean reports = driver.findElement(By.xpath(".//div[1]/h3[@class='panel-title']")).isDisplayed();
		return reports;
	}
}
