import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ResultPage {

	private WebDriver driver;
	
	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstLink() {
		return driver.findElement(By.cssSelector("div[class='gsc-results gsc-webResult'] > div[class='gsc-webResult gsc-result'] div[class='gs-title gsc-table-cell-thumbnail gsc-thumbnail-left'] > a")).getText();		
	}
}
