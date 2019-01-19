package videoRecording.video;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runningthevideo {
	
	
	
	
	
	@Test
	public void testvideo() throws Exception, Exception {
		
		
		VideoUtlity.videostart();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://grappus.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		VideoUtlity.videostops();
		driver.close();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
