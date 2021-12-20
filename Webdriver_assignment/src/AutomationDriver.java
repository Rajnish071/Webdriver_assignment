import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\desktop_folder\\documents\\qualitest\\selenium\\crome_driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(6000);
		exerciseOne(driver);
		Thread.sleep(1000);
		exerciseTwo(driver);
		Thread.sleep(1000);
		exerciseThree(driver);
		Thread.sleep(1000);
		exerciseFour(driver);
		Thread.sleep(1000);
		exerciseFourPointOne(driver);
		Thread.sleep(1000);
		exerciseFourPointTwo(driver);
		Thread.sleep(1000);
		exerciseFive(driver);
		Thread.sleep(1000);
		exerciseSix(driver);
		Thread.sleep(1000);
		exerciseSeven(driver);
		Thread.sleep(1000);
		exerciseEight(driver);
		Thread.sleep(1000);
		exerciseNine(driver);

	}
	public static void exerciseOne(WebDriver driver)
	{
		driver.findElement(By.cssSelector("input[value='radio1']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[value='radio1']")).isSelected());
		driver.findElement(By.cssSelector("input[value='radio2']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[value='radio2']")).isSelected());
		driver.findElement(By.cssSelector("input[value='radio3']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[value='radio3']")).isSelected());
	}
	public static void exerciseTwo(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("autocomplete")).sendKeys("United State");
		Thread.sleep(3000);
		List <WebElement> countries = driver.findElements(By.xpath("//ul/li[@class='ui-menu-item']"));

		for( WebElement country: countries){
			if(country.getText().equalsIgnoreCase("United States Minor Outlying Islands")){
				country.click();
				break;
			}
		}
		if(driver.findElement(By.id("autocomplete")).getAttribute("value").equalsIgnoreCase("United States Minor Outlying Islands")){
			System.out.println("United States Minor Outlying Islands is selected");
		}
	}
	public static void exerciseThree(WebDriver driver)
	{ 	WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}
	public static void exerciseFour(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("checkBoxOption1")).click();
		if(driver.findElement(By.id("checkBoxOption1")).isSelected())
		{
			System.out.println("Option 1st is checked off");
		}
		Thread.sleep(1000);
		driver.findElement(By.id("checkBoxOption1")).click();
		if(driver.findElement(By.id("checkBoxOption1")).isEnabled())
		{
			System.out.println("Option 1st is unchecked");
		}
		Thread.sleep(500);
		driver.findElement(By.id("checkBoxOption2")).click();
		if(driver.findElement(By.id("checkBoxOption2")).isSelected())
		{
			System.out.println("Option 2nd is checked off");
		}
		Thread.sleep(1000);
		driver.findElement(By.id("checkBoxOption2")).click();
		if(driver.findElement(By.id("checkBoxOption2")).isEnabled())
		{
			System.out.println("Option 2nd is unchecked");
		}
		Thread.sleep(500);
		driver.findElement(By.id("checkBoxOption3")).click();
		if(driver.findElement(By.id("checkBoxOption3")).isSelected())
		{
			System.out.println("Option 3rd is checked off");
		}
		Thread.sleep(1000);
		driver.findElement(By.id("checkBoxOption3")).click();
		if(driver.findElement(By.id("checkBoxOption3")).isEnabled())
		{
			System.out.println("Option 3rd is unchecked");
		}
	}
	public static void exerciseFourPointOne(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.id("checkBoxOption3")).click();
		if(driver.findElement(By.id("checkBoxOption1")).isSelected() && driver.findElement(By.id("checkBoxOption2")).isSelected() && driver.findElement(By.id("checkBoxOption3")).isSelected() )
		{
			System.out.println("All Option is checked off");
		}
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	public static void exerciseFourPointTwo(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.id("checkBoxOption3")).click();
		if(driver.findElement(By.id("checkBoxOption1")).isSelected() && driver.findElement(By.id("checkBoxOption2")).isSelected() && driver.findElement(By.id("checkBoxOption3")).isSelected() )
		{
			System.out.println("All Option is checked off");
		}
		Thread.sleep(500);
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.id("checkBoxOption3")).click();
		if(driver.findElement(By.id("checkBoxOption1")).isEnabled() && driver.findElement(By.id("checkBoxOption2")).isEnabled() && driver.findElement(By.id("checkBoxOption3")).isEnabled() )
		{
			System.out.println("All Option is unchecked");
		}
	}
	public static void exerciseFive(WebDriver driver) throws InterruptedException
	{

		
		driver.findElement(By.id("openwindow")).click();
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> window = Windows.iterator();
		String ParentWindow = window.next();
		String ChildWindow = window.next();  
		driver.switchTo().window(ChildWindow);
		String ChildTitle=driver.getTitle();
		if(ChildTitle.equals("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy"))
			System.out.println("child window is opened");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.close();
		driver.switchTo().window(ParentWindow);
		String ParentTitle = driver.getTitle();
		if(ParentTitle.equals("Practice Page")) 
			System.out.println("parrent window is reopened");
		
	}
	public static void exerciseSix(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("opentab")).click();
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> window = Windows.iterator();
		String ParentWindow = window.next();
		String ChildWindow = window.next();  
		driver.switchTo().window(ChildWindow);
		String ChildTitle=driver.getTitle();
//		if(ChildTitle.equals("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy"))
		System.out.println(ChildTitle);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.close();
		driver.switchTo().window(ParentWindow);
		String ParentTitle = driver.getTitle();
		System.out.println(ParentTitle);

	}
	public static void exerciseSeven(WebDriver driver) throws InterruptedException
	{
		String name = "Rajnish";
		driver.findElement(By.id("name")).sendKeys(name);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.id("alertbtn")).click();
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
		if(driver.switchTo().alert().getText().contains(name))
			System.out.println("dailogue display your name : "+name);
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
	}
	public static void exerciseEight(WebDriver driver) throws InterruptedException
	{
		int count=0;
		driver.manage().window().maximize();
		Thread.sleep(4000);
		JavascriptExecutor jsdriver = (JavascriptExecutor)driver;
		jsdriver.executeScript("window.scrollBy(0,600)");
		Thread.sleep(4000);
	    List <WebElement> contents = driver.findElements(By.xpath("//body/div[3]/div[1]/fieldset[1]/table[1]/tbody/tr"));
	    int siz= contents.size();
		for( WebElement content: contents)
		{
			if(content.isDisplayed())
			{
				count++;
				if(siz != count)
					continue;
				else
					System.out.println("Row of table is not blank");
			}
			else
			{
				System.out.println("Row of table is blank");
				break;
			}
		}
	}
	public static void exerciseNine(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor jsdriver = (JavascriptExecutor)driver;
		jsdriver.executeScript("window.scrollBy(0,300)");
		Thread.sleep(4000);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
		Thread.sleep(4000);
		a.moveToElement(driver.findElement(By.cssSelector("div.block.large-row-spacer:nth-child(6) div.left-align fieldset:nth-child(1) div.mouse-hover:nth-child(2) div.mouse-hover-content > a:nth-child(1)"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div.block.large-row-spacer:nth-child(6) div.left-align fieldset:nth-child(1) div.mouse-hover:nth-child(2) div.mouse-hover-content > a:nth-child(1)")).click();
	}
}

