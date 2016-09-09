import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;

public class DOU_TestPage {

	private WebDriver driver;
	
	@Before
	public void setUp()
	{
		File file = new File("C:/Selenium/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		
		driver = new FirefoxDriver();
//		driver = new MarionetteDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dou.ua");
	}
	
	/// <summary>
	/// One of the most heavily used features of the website is its keyword search,
	/// so we wanted to make absolutely certain that our  
	/// search box didn’t make search harder for users to find and use.
	/// Severity: Minor
	/// Priority: Medium
	/// </summary>
	@Test
	public void testSearchField()
	{		
		HomePage home= new HomePage(driver);
		ResultPage result = home.search("QA Fest");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertTrue(result.getFirstLink().contains("2015"));		
	}
	
	/// <summary>
	/// It is important to make sure that the "login" process is carried out correctly. 
	/// But more important to verify that the software is able to gracefully handle an abnormal situation.
	/// Severity: Major
	/// Priority: High
	/// </summary>
	@Test
	public void testLoginDialog()
	{
		HomePage home= new HomePage(driver);
		home.logingAs();
		
		LoginView view = new LoginView(driver);
		view.enterData("test", "test");
		
		assertTrue("Checking message 'Wrong password'.", view.isMessageDispled);
	}
	
	/// <summary>
	/// It is important to make sure that the vacancies header contains the equal number to amount of positions.
	/// Severity: Trivial
	/// Priority: Medium
	/// </summary>
	@Test
	public void testLookForJob()
	{
		HomePage home = new HomePage(driver);
		home.goToJobTab();
		
		JobPage job = new JobPage(driver);
//		job.selectCategory("QA");
		job.enterDescription("QA Levi9");
		job.findJob();
		
		String vacanciesHeadTotal = job.getvacanciesHeadTotal();
		assertTrue(vacanciesHeadTotal.contains(Integer.toString(job.getLinksCount())));
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
