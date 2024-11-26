package org.example.ATest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.WebElement;
public class LoginPagetest {
	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulnxttrends.ccbp.tech/");
		WebElement image = driver.findElement(By.xpath("//div[@class=\"registration-img-container\"]/child::img"));
		if(image.isDisplayed()) {
			System.out.println("Image Displayed");
		}else {
			System.out.println("Image not Displayed");
		}
		WebElement username = driver.findElement(By.name("name"));
		username.sendKeys("rahul");
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("rahul@example.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("rahu@2021");
		WebElement gender = driver.findElement(By.id("male"));
		gender.click();
		WebElement country = driver.findElement(By.tagName("select"));
		Select select = new Select(country);
		select.selectByVisibleText("Russia");
		WebElement clickCheck = driver.findElement(By.id("terms"));
		if(clickCheck.isEnabled()) {
		clickCheck.click();
		}else {
			System.out.println("Check box is not Enabled");
		}
		WebElement printlntext = driver.findElement(By.xpath("//label[@for=\"terms\"]"));
		String expectedtext = printlntext.getText();
		System.out.println(expectedtext);
		Thread.sleep(3000);
		WebElement clickSubmit = driver.findElement(By.id("submitBtn"));
		clickSubmit.click();
		String ExpectedUrl = "https://rahulnxttrends.ccbp.tech/";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(ExpectedUrl));
		String ActualUrl = driver.getCurrentUrl();
		if(ActualUrl.equals(ExpectedUrl)) {
			System.out.println("Url navigated Successfully");
		}else {
			System.out.println("Url not navigated");
		}
		WebElement clicklog = driver.findElement(By.linkText("Log in"));
		clicklog.click();
		String expectedname = "USERNAME1";
		WebElement expectednamee = driver.findElement(By.className("input-label"));
		String actualname = expectednamee.getText();
		if(actualname.equals(expectedname)) {
			System.out.println("matched heading");
		}else {
			System.out.println("do not matched heading");
			System.out.println("expected "+expectedname);
			System.out.println("actualheading "+ actualname);
		}
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshot/img.png");
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot captured successfully");
		driver.quit();
	}
}
