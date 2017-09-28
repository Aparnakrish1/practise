package MMP;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;


public class MMPEditProfile {
WebDriver driver;
	public MMPEditProfile(WebDriver driver){
		this.driver = driver;
	}
	public boolean Editprofile(String Age) throws InterruptedException{
		driver.findElement(By.linkText("Profile")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ebtn")).click();
		//Thread.sleep(1000);
		driver.findElement(By.id("age")).clear();
		driver.findElement(By.id("age")).sendKeys(Age);
		driver.findElement(By.id("Sbtn")).click();
		
		Thread.sleep(1000);
		Alert alrt = driver.switchTo().alert();
		String message = alrt.getText();
		System.out.println(message);
		alrt.accept();
		//Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age"))).
		Thread.sleep(1000);
		String Ageupdated = driver.findElement(By.id("age")).getAttribute("value");
		System.out.println(Ageupdated);
		//int updatedage = Integer.parseInt(Agegiven);
		//Assert.assertEquals(Age, Agegiven);
		//boolean actual = driver.findElement(By.id("Ebtn")).isDisplayed();
		return Age.equals(Ageupdated);
	}
	public boolean Editprofileblank() throws InterruptedException{
		driver.findElement(By.linkText("Profile")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ebtn")).click();
		//Thread.sleep(1000);
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.id("Sbtn")).click();
		
		Thread.sleep(1000);
		String errordisplayed = driver.findElement(By.id("firsterr")).getText();
		System.out.println("Error" +errordisplayed);
		boolean error = driver.findElement(By.id("firsterr")).isDisplayed();
		return error;
		
	}
}
