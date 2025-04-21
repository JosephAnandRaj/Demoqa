package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setups {
	
	static WebDriver driver;
	
	public static WebDriver browser(String pageName) {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    
	    switch(pageName.toLowerCase()) {
	    	case "alert":
	    		driver.get("https://demoqa.com/alerts");
	    		break;
		    
	    	case "windowhandle":
	    		driver.get("https://demoqa.com/browser-windows");
	    		break;
	    		
	    	case "iframe":
	    		driver.get("https://demoqa.com/frames");
	    		break;
	    	
	    	default:
	    		System.out.println("Page name is Invalid!");
	    		break;
	    		
	    }
	    
	   return driver;

	    }
	

	public static void quitBrowser() {
        driver.quit();

	}
	



}
