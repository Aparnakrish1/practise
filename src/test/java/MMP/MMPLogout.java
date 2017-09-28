package MMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMPLogout {
WebDriver driver;

	public MMPLogout(WebDriver driver){
		this.driver = driver;
	}
	public String logout() throws InterruptedException{
		//ul/li[9]/a/span
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[9]/a/span"))).click();
		Thread.sleep(3000);
		String actual = driver.getTitle();
		return actual;
	}
}
