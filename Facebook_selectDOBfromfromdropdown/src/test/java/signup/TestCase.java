package signup;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

@Test
public class TestCase extends BaseTest{
	
	public void createaccount() {
		
        //create new account
		WebElement newaccount = driver.findElement(By.linkText("Create New Account"));
		newaccount.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		//Enter firstname and surname
		driver.findElement(By.name("firstname")).sendKeys("ABCD");
		driver.findElement(By.name("lastname")).sendKeys("XYZ");

		//Enter mobile Number
		driver.findElement(By.name("reg_email__")).sendKeys("987654321");
		System.out.println("Please enter a valid mobile number or email address");

        
		//Not entering password
		System.out.println("Enter a combination of at least six numbers,letters and punctuation marks(such as ! and &)");
	}


	public void dropdown() {
		//select birthday from day dropdown
		WebElement date = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select birthDate = new Select(date);
		birthDate.selectByVisibleText("24");

		//select month from month dropmenu
		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select birthMonth = new Select(month);
		birthMonth.selectByIndex(9);

		// select year from year dropdown
		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select birthYear = new Select(year);
		birthYear.selectByValue("2000");
	}

	
	public void selectgender() {
		//select gender
		WebElement gender =  driver.findElement(By.xpath("//input[@value='1']"));
		gender.click();
    	//click on sign up
		driver.findElement(By.name("websubmit")).click();
		
		//wait statement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static void main(String[] args) throws InterruptedException,IOException{
		TestCase FB = new TestCase();
		FB.openbrowser();
		FB.createaccount();
		FB.dropdown();
		FB.selectgender();
		FB.closeBrowser();
		
	}

}
