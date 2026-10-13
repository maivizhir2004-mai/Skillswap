package skillSwapProject;

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

public class SkillSwap {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://skillswap-six-psi.vercel.app/register");
    }

    @Test(priority = 1)
    public void RegisterPage() {

        driver.findElement(By.id("form-userName")).sendKeys("Mai");
        driver.findElement(By.id("form-userEmail"))
              .sendKeys("mairtest2087@gmail.com");
        driver.findElement(By.id("form-userCity")).sendKeys("Chennai");
        driver.findElement(By.id("form-userPassword"))
              .sendKeys("89460@Mai");
        driver.findElement(By.id("form-confirmPassword"))
              .sendKeys("89460@Mai");

        driver.findElement(By.id("register-submit-button")).click();

        wait.until(ExpectedConditions.urlContains("/dashboard"));

        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/dashboard");
    }

    @Test(priority = 2)
    public void Explore() {

        driver.get("https://skillswap-six-psi.vercel.app/dashboard");

        wait.until(ExpectedConditions.urlContains("/dashboard"));

        driver.findElement(By.cssSelector("a[href='/explore']")).click();

        wait.until(ExpectedConditions.urlContains("/explore"));

        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/explore");
    }

    @Test(priority = 3)
    public void SearchAndScroll() {

        driver.findElement(By.id("explore-search-input"))
              .sendKeys("teating");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,800)");

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/explore");
    }

    @Test(priority = 4)
    public void SendRequest() {

        driver.findElement(By.id("explore-search-input")).clear();

        driver.findElement(By.id("explore-search-input"))
              .sendKeys("Testing");

        driver.findElement(
                By.id("send-request-4AT224ASIvWRKdWJHdT0V8btd4c2"))
              .click();

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/explore");
    }

    @Test(priority = 5)
    public void FilterByCity() {

        driver.findElement(By.id("explore-city-filter-input"))
              .sendKeys("Namakkal");

        driver.findElement(
                By.id("view-profile-RAmVWJ5rgZh0CjvZgzHDxXD0jvE2"))
              .click();

        wait.until(ExpectedConditions.urlContains(
                "/RAmVWJ5rgZh0CjvZgzHDxXD0jvE2"));

        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertTrue(
                actualURL.contains("/RAmVWJ5rgZh0CjvZgzHDxXD0jvE2"));
    }

    @Test(priority = 6)
    public void HomePage() {

        driver.get("https://skillswap-six-psi.vercel.app/explore");

        wait.until(ExpectedConditions.urlContains("/explore"));

        driver.findElement(By.xpath("//span[text()='Home']")).click();

        wait.until(ExpectedConditions.urlContains("/home"));

        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/home");
    }

    @Test(priority = 7)
    public void StartExploring() {

        driver.get("https://skillswap-six-psi.vercel.app/home");

        wait.until(ExpectedConditions.urlContains("/home"));

        driver.findElement(By.cssSelector("a[href='/explore']")).click();

        wait.until(ExpectedConditions.urlContains("/explore"));

        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/explore");
    }

    @Test(priority = 8)
    public void Profile() {

        driver.findElement(By.xpath("//span[text()='Profile']")).click();

        wait.until(ExpectedConditions.urlContains("/profile"));

        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/profile");
    }

    @Test(priority = 9)
    public void EditProfile()  {


        driver.findElement(By.xpath("//span[text()='Profile']")).click();
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
        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertEquals(actualURL,"https://skillswap-six-psi.vercel.app/profile");
    }

    @Test(priority = 10)
    public void ProfileLogAndLogout() {

        driver.findElement(By.id("header-profile-menu-button")).click();

        driver.findElement(By.id("header-logout-button")).click();

        wait.until(ExpectedConditions.urlContains("/login"));

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/login");
    }

    @Test(priority = 11)
    public void LoginPage() {

        driver.findElement(By.id("userEmail")).sendKeys("RamyaRavi@gmail.com");

        driver.findElement(By.id("userPassword")).sendKeys("Ramya@Ravi");

        driver.findElement(By.id("login-submit-button")).click();

        wait.until(ExpectedConditions.urlContains("/dashboard"));

        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/dashboard");
    }

    @Test(priority = 12)
    public void Acceptrequset() {

        driver.findElement(By.xpath("//span[text()='Requests']")).click();

        wait.until(ExpectedConditions.urlContains("/requests"));

        WebElement acceptButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[starts-with(@id,'accept-request-')]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                acceptButton);

        wait.until(ExpectedConditions.visibilityOf(acceptButton));

        js.executeScript("arguments[0].click();", acceptButton);

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/requests");
    }

    @Test(priority = 13)
    public void Schedule() {

        WebElement scheduleButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[starts-with(@id,'schedule-request-')]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                scheduleButton);

        wait.until(ExpectedConditions.visibilityOf(scheduleButton));

        js.executeScript("arguments[0].click();", scheduleButton);

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/requests");
    }

    @Test(priority = 14)
    public void UpcomingSessions() {

        WebElement sessions = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Sessions']")));

        sessions.click();

        wait.until(ExpectedConditions.urlContains("/sessions"));

        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertEquals(actualURL,"https://skillswap-six-psi.vercel.app/sessions");

        WebElement startSession = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[starts-with(@id,'start-session-')]")));

        startSession.click();
    }

    @Test(priority = 15)
    public void Rating() {

        WebElement reviewButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("review-session-a7jibqsFMpeSmdO64plk")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                reviewButton);

        js.executeScript("arguments[0].click();", reviewButton);

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/sessions");
    }

    @Test(priority = 16)
    public void SendChat() {

        driver.findElement(By.xpath("//span[text()='Chat']")).click();

        wait.until(ExpectedConditions.urlContains("/chats"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.findElement(
                By.id("open-chat-TyjT7GEiSgZAwmOsYN8qpZHJl1l1_albLjjlRYDM1N2UGCbci748xTVA3")).click();

        driver.findElement(
                By.xpath("//input[@placeholder='Type a message... (Enter to send)']")).sendKeys("Hello");

        driver.findElement(
                By.id("chat-send-button-TyjT7GEiSgZAwmOsYN8qpZHJl1l1_albLjjlRYDM1N2UGCbci748xTVA3")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/chats"));
    }

    @Test(priority = 17)
    public void Notifications() {

        driver.findElement(By.id("header-notifications-link")).click();

        wait.until(ExpectedConditions.urlContains("/notifications"));

        String actualURL = driver.getCurrentUrl();

        System.out.println("Current URL: " + actualURL);

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/notifications");

        driver.findElement(
                By.id("mark-all-notifications-read-button")).click();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://skillswap-six-psi.vercel.app/notifications");
    }

    @Test(priority = 18)
    public void Logout() {

        driver.findElement(By.id("header-profile-menu-button")).click();

        driver.findElement(By.id("header-logout-button")).click();

        wait.until(ExpectedConditions.urlContains("/login"));

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(
                actualURL,
                "https://skillswap-six-psi.vercel.app/login");
    }

   @AfterTest
    public void tearDown() {
    	driver.close();
		
    }
}
    

   
	
	 

	
			
			
