import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class JobPage {

	private WebDriver driver;
	
	public JobPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectCategory(String category) 
	{	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		new Select(driver.findElement(By.name("category"))).selectByVisibleText(category);
	}

	public void enterDescription(String description) 
	{
		driver.findElement(By.className("job")).sendKeys(description);	
	}

	public void findJob() 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input.btn-search")).click();	
	}

	public int getLinksCount() 
	{
		try {
			   Thread.sleep(1000);
			} catch (InterruptedException e) {
			   e.printStackTrace();
			}
		return driver.findElements(By.cssSelector("#vacancyListId li")).size();		
	}

	public String getvacanciesHeadTotal() {
		try {
			   Thread.sleep(3000);
			} catch (InterruptedException e) {
			   e.printStackTrace();
			}
		return driver.findElement(By.cssSelector(".b-inner-page-header h1")).getText();
	}
	
	
	
}
