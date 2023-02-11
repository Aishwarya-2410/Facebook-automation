package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import base.BaseTest;


@Test
public class screenshot extends BaseTest  {

	
		public static int i=0;
		
		/*
		 * Capturing the Screenshot of the Webpage after dropping the target at its destination
		 */
		public static void screenShot() throws IOException 
		{
			//Taking Screenshot
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourceFile=ts.getScreenshotAs(OutputType.FILE);
			File destinationFile=new File(".//Screenshot//screen.png");
			FileUtils.copyFile(sourceFile, destinationFile);				
		}
	}

