package BDD.BDDcucumber;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App 
{
    public static void main( String[] args )
    {
    	
    	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
				

    			
    		}
    }

