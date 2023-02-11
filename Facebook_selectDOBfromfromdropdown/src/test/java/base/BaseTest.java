package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static FileReader fr;

	@BeforeTest
	public void openbrowser() throws IOException{


		if(driver==null) {
			FileReader fr=new FileReader("F:\\eclipse\\2128407_selectDOBfromfromdropdown\\src\\test\\resources\\config.properties");
			prop.load(fr);
		}
		if(prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(prop.getProperty("url"));
		}
		else if(prop.getProperty("browserName").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(prop.getProperty("url"));
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}


}
