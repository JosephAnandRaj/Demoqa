package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpHandle {
    WebDriver driver;
    
	
	public void windowHandle()throws InterruptedException {
        driver.findElement(By.id("windowButton")).click();
        Thread.sleep(2000);
        
        Set<String> allwindows = driver.getWindowHandles();
        List<String> handle = new ArrayList<>(allwindows);
        
        String mainWindow = handle.get(0);
        String PopupWindow = handle.get(1);
        
        driver.switchTo().window(mainWindow);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        
        driver.switchTo().window(PopupWindow);
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
	}
	
	public void newTab() throws InterruptedException {
		driver.findElement(By.id("tabButton")).click();
        Thread.sleep(2000);

		Set<String> allWindows = driver.getWindowHandles();
		List<String> handle = new ArrayList<>(allWindows);
		
		String mainWindow = handle.get(0);
		String tabA = handle.get(1);
		
		driver.switchTo().window(mainWindow);
		System.out.println("Switched to Main Window: "+driver.getTitle());
        Thread.sleep(2000);

		driver.switchTo().window(tabA);
		System.out.println("Switched to Tab A: "+driver.findElement(By.id("sampleHeading")).getText());
        Thread.sleep(2000);

	}
	
	


    public static void main(String[] args) throws InterruptedException {
        
    	PopUpHandle p = new PopUpHandle();
   // 	p.windowHandle();
    	p.driver= Setups.browser("windowhandle");
    	p.newTab();
    	Setups.quitBrowser();


      


    
    }}