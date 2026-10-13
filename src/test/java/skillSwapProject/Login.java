package skillSwapProject;

import org.openqa.selenium.By;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	WebDriverWait wait;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://skillswap-six-psi.vercel.app/login");
    }

    @Test(priority = 1)
    public void LoginPage() throws InterruptedException {

    	 Thread.sleep(3000);
         driver.findElement(By.id("userEmail"))
                 .sendKeys("maitest1987@gmail.com");

         driver.findElement(By.id("userPassword"))
                 .sendKeys("mai@123");

         driver.findElement(By.id("login-submit-button"))
                 .click();

         Thread.sleep(3000);

         System.out.println("Current URL: " + driver.getCurrentUrl());

         Assert.assertTrue(
                 driver.getCurrentUrl().contains("/dashboard")
                
         );
     }
    @Test(priority = 18)
    public void UpcomingSessions() {

        driver.findElement(By.xpath("//span[text()='Sessions']"))
                .click();

        wait.until(ExpectedConditions.urlContains("/sessions"));

        driver.findElement(
                By.id("start-session-0KWGDNSYgDwKdw1ymJwU"))
                .click();

        driver.findElement(
                By.id("complete-session-rpkQT7MH5Zz4tKC0Ku2g"))
                .click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/sessions"));
    }

    @Test(priority = 13)
    public void ProfileLogAndLogout() {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	WebElement profileMenu = wait.until(
    	        ExpectedConditions.elementToBeClickable(
    	                By.id("header-profile-menu-button")));

    	profileMenu.click();
       

        driver.findElement(By.id("header-logout-button")).click();

        wait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}