package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrame {
		WebDriver driver;
		
		public void switchFrames() {
			
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			System.out.println(frames.gets);

			// 👉 Switch to first frame
			driver.switchTo().frame("frame1");
			String text1 = driver.findElement(By.id("sampleHeading")).getText();
			System.out.println("Frame1 text: "+text1);
			
	        // 🔙 Switch back to main page before switching to next frame
			driver.switchTo().defaultContent();
			
	        // 👉 Switch to second frame
			driver.switchTo().frame("frame1");
			String text2 = driver.findElement(By.id("sampleHeading")).getText();
			System.out.println("Frame2 text: "+text2);	
			
			
		}
	

	public static void main(String[] args) {
		IFrame i = new IFrame();
		i.driver = Setups.browser("iframe");
		i.switchFrames();
		Setups.quitBrowser();
		
	}

}
