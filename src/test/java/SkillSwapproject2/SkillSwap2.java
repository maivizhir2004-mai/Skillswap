package SkillSwapproject2;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SkillSwap2 {

    WebDriver driver;
    WebDriverWait wait;

    

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://skillswap-six-psi.vercel.app/register");
    }

   

    @Test(priority = 1)
    public void RegisterPage() {

        driver.findElement(By.id("form-userName")).sendKeys("Mai");

        driver.findElement(By.id("form-userEmail")).sendKeys("mairtest2069@gmail.com");

        driver.findElement(By.id("form-userCity")).sendKeys("Chennai");

        driver.findElement(By.id("form-userPassword")).sendKeys("89460@Mai");

        driver.findElement(By.id("form-confirmPassword")).sendKeys("89460@Mai");

        driver.findElement(By.id("register-submit-button")).click();

        
        wait.until(ExpectedConditions.urlContains("/dashboard"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }


    @Test(priority = 2)
    public void Explore() {

        driver.get("https://skillswap-six-psi.vercel.app/dashboard");

        wait.until(ExpectedConditions.urlContains("/dashboard"));

        driver.findElement(By.cssSelector("a[href='/explore']")).click();

        wait.until(ExpectedConditions.urlContains("/explore"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/explore"));
    }

   

    @Test(priority = 3)
    public void SearchAndScroll() {

        driver.findElement(By.id("explore-search-input")).sendKeys("teating");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,800)");

        Assert.assertTrue(driver.getCurrentUrl().contains("/explore"));
    }

   

    @Test(priority = 4)
    public void SendRequest() {

        driver.findElement(By.id("explore-search-input")).clear();

        driver.findElement(By.id("explore-search-input")).sendKeys("Testing");

        driver.findElement(By.id("send-request-4AT224ASIvWRKdWJHdT0V8btd4c2")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/explore"));
    }

   

    @Test(priority = 5)
    public void FilterByCity() {

        driver.findElement(By.id("explore-city-filter-input")).sendKeys("Namakkal");

        driver.findElement(By.id("view-profile-RAmVWJ5rgZh0CjvZgzHDxXD0jvE2")).click();

        wait.until(ExpectedConditions.urlContains("/RAmVWJ5rgZh0CjvZgzHDxXD0jvE2"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains( "/RAmVWJ5rgZh0CjvZgzHDxXD0jvE2"));
    }

   

    @Test(priority = 6)
    public void HomePage() {

        driver.get("https://skillswap-six-psi.vercel.app/explore");

        wait.until(ExpectedConditions.urlContains("/explore"));

        driver.findElement(By.xpath("//span[text()='Home']")).click();

        wait.until(ExpectedConditions.urlContains("/home"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

   

    @Test(priority = 7)
    public void StartExploring() {

        driver.get("https://skillswap-six-psi.vercel.app/home");

        wait.until(ExpectedConditions.urlContains("/home"));

        driver.findElement(By.cssSelector("a[href='/explore']")).click();

        wait.until(ExpectedConditions.urlContains("/explore"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/explore"));
    }

  

    @Test(priority = 8)
    public void Profile() {

        driver.findElement(By.xpath("//span[text()='Profile']")).click();

        wait.until(ExpectedConditions.urlContains("/profile"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"));
    }

   

    @Test(priority = 9)
    public void EditProfile() {

        
        driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
        wait.until(ExpectedConditions.urlContains("/profile"));

        
        WebElement editProfile = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space()='Edit Profile']")));

        editProfile.click();

        
        WebElement teachSkills = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("teach-skills")));

        teachSkills.clear();
        teachSkills.sendKeys("Automation Testing");

        WebElement learnSkills = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("learn-skills")));

        learnSkills.clear();
        learnSkills.sendKeys("Java");

        WebElement submitButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("profile-submit-button")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",submitButton);

        js.executeScript("arguments[0].click();", submitButton);

        wait.until(ExpectedConditions.urlContains("/profile"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"));
    }
    @Test(priority = 10)
    public void Sessions() {

        driver.findElement(By.xpath("//span[text()='Sessions']")).click();

        wait.until(ExpectedConditions.urlContains("/sessions"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/sessions"));
    }

    

    @Test(priority = 11)
    public void Requests() {

        driver.findElement(By.xpath("//span[text()='Requests']")).click();

        wait.until(ExpectedConditions.urlContains("/requests"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/requests"));
    }

  

    @Test(priority = 12)
    public void Chat() {

        driver.findElement(By.xpath("//span[text()='Chat']")).click();

        wait.until(ExpectedConditions.urlContains("/chats"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/chats"));
    }

   

    @Test(priority = 13)
    public void ProfileLogAndLogout() {

    	driver.findElement(By.id("header-profile-menu-button")).click();

        driver.findElement(By.id("header-logout-button")).click();

        wait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    
    }

   

    @Test(priority = 14)
    public void LoginPage() {

        driver.findElement(By.id("userEmail")).sendKeys("Automation@gmail.com");

        driver.findElement(By.id("userPassword")).sendKeys("Auto@123");

        driver.findElement(By.id("login-submit-button")).click();

        wait.until(ExpectedConditions.urlContains("/dashboard"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }

  

    @Test(priority = 15)
    public void Acceptrequset() {

        driver.findElement(By.xpath("//span[normalize-space()='Requests']")).click();

        wait.until(ExpectedConditions.urlContains("/requests"));

        WebElement acceptButton = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[normalize-space()='Accept']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            acceptButton);

        wait.until(ExpectedConditions.visibilityOf(acceptButton));

        js.executeScript("arguments[0].click();", acceptButton);

        Assert.assertTrue(driver.getCurrentUrl().contains("/requests"));
    }
    @Test(priority = 16)
    public void Schedule() {

        WebElement scheduleButton = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[normalize-space()='Schedule Session']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            scheduleButton);

        wait.until(ExpectedConditions.visibilityOf(scheduleButton));

        js.executeScript("arguments[0].click();", scheduleButton);

        Assert.assertTrue(driver.getCurrentUrl().contains("/requests"));
    }
    @Test(priority = 17)
    public void Rejectrequset() {

    	 JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,200)");
        
       
        WebElement rejectButton = wait.until(
        	    ExpectedConditions.elementToBeClickable(
        	        By.xpath("//button[normalize-space()='Reject']")));

        	rejectButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/requests"));
    }
 
    @Test(priority = 18)
    public void UpcomingSessions() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        
        WebElement sessions = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[.//span[normalize-space()='Sessions']]")));

        sessions.click();

        
        wait.until(ExpectedConditions.urlContains("/sessions"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        
        WebElement startSession = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[starts-with(@id,'start-session-')]")));

        startSession.click();
    }
   

    @Test(priority = 19)
    public void Rating() {

        

        WebElement reviewButton = wait.until(
        	    ExpectedConditions.presenceOfElementLocated(
        	        By.xpath("//button[normalize-space()='Give Rating']")));

        	JavascriptExecutor js = (JavascriptExecutor) driver;

        	js.executeScript(
        	    "arguments[0].scrollIntoView({block:'center'});",
        	    reviewButton);

        	js.executeScript("arguments[0].click();", reviewButton);
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/sessions"));
    }

    @Test(priority = 20)
    public void SendChat() {

        driver.findElement(By.xpath("//span[text()='Chat']")).click();

        wait.until(ExpectedConditions.urlContains("/chats"));

        System.out.println("Current URL: " + driver.getCurrentUrl());
        driver.findElement(
                By.id("open-chat-DbEYBpTQrnbJUYSadmpz07AXh6p1_VSsz2WzGlrYKH2LXCX3GzA7VWBE2")).click();

        driver.findElement(
                By.xpath("//input[@placeholder='Type a message... (Enter to send)']")).sendKeys("Hello");

        driver.findElement(
                By.id("chat-send-button-Bdwcpe8cdhPB0Ype1GkMuP5Lo6y1_EmLcy0GQQgROJW7FBTIcSzmjazc2")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/chats"));
    }

    @Test(priority=25)  
    public void Notifications() { 
    	driver.findElement(By.id("header-notifications-link")).click(); 
        System.out.println("Current URL: " + driver.getCurrentUrl()); 
        Assert.assertTrue(driver.getCurrentUrl().contains("/notifications")); 
        driver.findElement(By.id("mark-all-notifications-read-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/notifications"));
        
    } 
    @Test(priority = 26)
    public void Logout() {

        driver.findElement(By.id("header-profile-menu-button")).click();

        driver.findElement(By.id("header-logout-button")).click();

        wait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @AfterTest
    public void tearDown() {
    	driver.close();
		
    }
}
    
