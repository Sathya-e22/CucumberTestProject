package BDD.BDDcucumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCar {

	public static void main(String[] args) {
		
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
			ChromeDriver driver = new ChromeDriver(); 
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("https://www.zoomcar.com/chennai/");
			driver.findElementByLinkText("Start your wonderful journey").click();
					
			driver.findElementByXPath("(//div[@class='items'])[3]").click();
			driver.findElementByXPath("//button[@class='proceed']").click();
			driver.findElementByXPath("//div[text()='Mon']").click();
			driver.findElementByXPath("//button[@class='proceed']").click();
			driver.findElementByXPath("//button[@class='proceed']").click();
			
			List<WebElement> Prices = driver.findElementsByClassName("price");
			List<Integer> Price = new ArrayList<Integer>();
			
			for (WebElement ListOfPrice : Prices) {
				String text = ListOfPrice.getText();
				String replace = text.replaceAll("\\D", "");
				Price.add(Integer.parseInt(replace));
				//System.out.println(ListOfPrice);
			}
			Integer min = Collections.min(Price);
			System.out.println("Low Price "+ min);
			
			//driver.close();
		}
}
