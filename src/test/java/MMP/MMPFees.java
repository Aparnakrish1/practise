package MMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMPFees {
	
	WebDriver driver;
	
	public MMPFees(WebDriver driver){
		this.driver= driver;
	}

	 public boolean Fees(){
		 driver.findElement(By.linkText("Fees")).click();
		String fee =  driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/p[3]")).getText();
		System.out.println("Outstanding fee "+fee);
		 boolean fees = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/p[3]")).isDisplayed();
		 return fees;
	 }
}
