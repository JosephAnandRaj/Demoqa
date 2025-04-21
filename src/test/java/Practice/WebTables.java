package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTables {
	
	WebDriver driver;
	
		public void verifyTable() {
			WebElement table = driver.findElement(By.className("rt-table"));
			List<WebElement> allRows = table.findElements(By.xpath(".//div[@class='rt-tr-group']"));
			WebElement firstrow = allRows.get(0);
			List<WebElement> cells = firstrow.findElements(By.className("rt-td"));
				System.out.println(cells.get(0).getText());
			
			
			
	/*		for (WebElement row: allRows) {
				List<WebElement> cell = row.findElements(By.xpath(".//div[@class='rt-td']"));
				if(!cell.isEmpty()) {
					System.out.println(cell.get(0).getText());
				}
			}*/
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
