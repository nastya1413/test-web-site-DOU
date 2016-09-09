import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public ResultPage search(String searchWord) {
		driver.findElement(By.id("txtGlobalSearch")).sendKeys(searchWord);
		driver.findElement(By.id("txtGlobalSearch")).sendKeys(Keys.ENTER);
		return new ResultPage(driver);
	}

	public LoginView logingAs() 
	{
		driver.findElement(By.id("login-link")).click();		
		return new LoginView(driver);
	}

	public void goToJobTab() 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//a[@href='https://jobs.dou.ua/']")).click();	
	}
}
