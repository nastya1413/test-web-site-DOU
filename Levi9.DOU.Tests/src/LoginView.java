import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginView {

	private WebDriver driver;
	protected boolean isMessageDispled;
	
	public LoginView(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterData(String email, String password) 
	{
		if(!driver.findElement(By.id("agree-checkbox")).isSelected())
		{
			driver.findElement(By.id("agree-checkbox")).click();
		}
		
		driver.findElement(By.id("_loginByMail")).click();
		
		driver.findElement(By.cssSelector(".first.txtEmail")).sendKeys(email);
		driver.findElement(By.cssSelector(".txtPassword")).sendKeys(password);
		
		driver.findElement(By.cssSelector(".login.view .btnSubmit")).click();
		
		this.isMessageDispled = driver.findElement(By.id("wrong-password-message")).isDisplayed();
	}	
	
	public boolean isWrongPassword()
	{
		return this.isMessageDispled;
	}
}
