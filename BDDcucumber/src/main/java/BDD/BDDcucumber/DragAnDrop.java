package BDD.BDDcucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAnDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		Actions builder = new Actions(driver);
		WebElement Source = driver.findElementByXPath("//*[@id= 'draggable']");
		WebElement Destination = driver.findElementByXPath("//*[@id= 'droppable']");
		
		builder.dragAndDrop(Source, Destination).perform();
		driver.close();
	}

}
