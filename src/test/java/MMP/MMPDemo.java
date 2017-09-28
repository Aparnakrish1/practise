package MMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MMPDemo {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void Browser(){
		System.setProperty("Webdriver.firefox.driver", "geckodriver.exe");
	this.driver = new FirefoxDriver();
		
		this.driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		wait = new WebDriverWait(driver,30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Patient Login"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.button-alt"))).click();
	}
	@Parameters({"username","password"})
	@Test(description="Login_valid",priority=1,enabled=true)
	public void Login(String username, String password) throws InterruptedException{

		MMPLogin login = new MMPLogin(this.driver);
		String actual = login.Login(username,password);
		System.out.println(actual);
		String expected = username;
		Assert.assertEquals(actual, expected);
	}
	@Parameters({"Title"})
	@Test(description="Logout",priority=12,enabled=true)
	public void Logout(String Title) throws InterruptedException{
		MMPLogout logout = new MMPLogout(this.driver);
		String actual = logout.logout();
		System.out.println("Title "+actual);
		String expected = Title;//NAMTG
		Assert.assertEquals(actual, expected);
	}
	
	@Test(description="Invalid Login",priority=13,enabled=true)
	public void invalidLogin() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Patient Login"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.button-alt"))).click();
		MMPLoginInvalid login= new MMPLoginInvalid(this.driver);
		boolean actual = login.Login();
		System.out.println("Alert message "+actual);
		//String expected = "Wrong username and password.";
		Assert.assertTrue(actual);
	} 
	@Parameters({"LoginTitle"})
	@Test(description="blank Login",priority=14,enabled=true)
	public void blankLogin(String LoginTitle) throws InterruptedException{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Patient Login"))).click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.button-alt"))).click();
		MMPLoginInvalid login= new MMPLoginInvalid(this.driver);
		String actual  = login.blanklogin();
		String expected = LoginTitle;//Login
		Assert.assertEquals(actual, expected);
	} 
	
	@Parameters({"Age"})
	@Test(description="EditProfilePage",priority=2)
	public void EditProfile(String Age) throws InterruptedException{
		
		MMPEditProfile edit= new MMPEditProfile(this.driver);
		boolean actual = edit.Editprofile(Age);
		Assert.assertTrue(actual);
	} 
	
	@Test(description="Past Transaction",priority=3)
	public void PastTransaction() throws InterruptedException{
		MMPProfileViewHistory history= new MMPProfileViewHistory(driver);
		history.ViewHistory();
	boolean Transaction = 	history.PastTransaction();
		Assert.assertTrue(Transaction);
	}
	
	@Test(description = "View Past Appointment", priority=4)
	public void PastAppointment() throws InterruptedException{
		MMPProfileViewHistory appointment= new MMPProfileViewHistory(driver);
		appointment.ViewHistory();
		boolean verifyappointment = appointment.appointment();
		Assert.assertTrue(verifyappointment);
	}
	@Test(description = "Diagnosis", priority = 5)
	public void Diagnosis() throws InterruptedException{
		MMPProfileViewHistory Diagnosis= new MMPProfileViewHistory(driver);
		Diagnosis.ViewHistory();
		boolean verifyDiag = Diagnosis.Diagnosis();
		Assert.assertTrue(verifyDiag);
	}
	@Test(description="prescription", priority = 6)
	public void Prescription() throws InterruptedException{
		MMPProfileViewHistory Prescription = new MMPProfileViewHistory(driver);
		Prescription.ViewHistory();
		boolean verifyprescription = Prescription.Diagnosis();
		Assert.assertTrue(verifyprescription);
	}
	
	@Parameters({"symptoms"})
	@Test(description="searchsymptoms", priority = 7)
		public void SearchSymptoms(String symptoms) throws InterruptedException{
			MMPSearchSymptoms searchsym = new MMPSearchSymptoms(driver);
			
			boolean solution = searchsym.Symptoms(symptoms);
			Assert.assertTrue(solution);
	}
	@Parameters({"invalidsymptoms"})
	@Test(description="searchinvalidsymptoms", priority = 8)
		public void SearchInvalidSymptoms(String invalidsymptoms) throws InterruptedException{
			MMPSearchSymptoms searchsym = new MMPSearchSymptoms(driver);
			
			boolean solution = searchsym.Symptoms(invalidsymptoms);
			Assert.assertFalse(solution);
	}
	@Test(description="Fees", priority = 9)
	public void Fees() throws InterruptedException{
		MMPFees Fees = new MMPFees(driver);
		
		boolean solution = Fees.Fees();
		Assert.assertTrue(solution);
		}
	@Test(description="EditProfilePage_invalid",priority=10)
	public void invalidEditProfile() throws InterruptedException{
		
		MMPEditProfile edit= new MMPEditProfile(this.driver);
		boolean actual = edit.Editprofileblank();
		Assert.assertTrue(actual);
	} 
	
	@Test(description="ViewReports",priority=11)
	public void Reports() throws InterruptedException{
		
		MMPViewReports reports= new MMPViewReports(this.driver);
		boolean view = reports.Reports();
		Assert.assertTrue(view);
	}
}
