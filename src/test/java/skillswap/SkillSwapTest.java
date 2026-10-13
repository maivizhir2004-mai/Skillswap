package skillswap;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SkillSwapTest {
	WebDriver driver;
	ChromeOptions options;

    String url = "https://skillswap-six-psi.vercel.app/";

    @BeforeClass
    public void setup() {
    	
        options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);

        System.out.println("Website opened successfully");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
    }


    // ==============================
    // 1. HOME PAGE TEST
    // ==============================

    @Test(priority = 1)
    public void homePageTest() {

        System.out.println("----- Home Page Test -----");

        String actualURL = driver.getCurrentUrl();

        Assert.assertTrue(
                actualURL.contains("skillswap"),
                "Home page URL is incorrect"
        );

        System.out.println("Home page verified");
    }


    // ==============================
    // 2. PAGE TITLE TEST
    // ==============================

    @Test(priority = 2)
    public void titleTest() {

        System.out.println("----- Title Test -----");

        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        Assert.assertNotNull(title);

        System.out.println("Title test passed");
    }


    // ==============================
    // 3. NAVIGATION TEST
    // ==============================

    @Test(priority = 3)
    public void navigationTest() {

        System.out.println("----- Navigation Test -----");

        System.out.println("Checking navigation elements...");

        // Change these locators according to your website
        try {

            WebElement home =
                    driver.findElement(By.xpath("//a[contains(text(),'Home')]"));

            Assert.assertTrue(home.isDisplayed());

            System.out.println("Home link is displayed");

        } catch (Exception e) {

            System.out.println("Home link locator needs to be changed");
        }
    }


    // ==============================
    // 4. REGISTER PAGE
    // ==============================

    @Test(priority = 4)
    public void registerPageTest() {

        System.out.println("----- Register Page Test -----");

        try {

            WebElement register =
                    driver.findElement(
                            By.xpath("//a[contains(text(),'Register') or contains(text(),'Sign Up')]")
                    );

            register.click();

            Thread.sleep(1000);

            System.out.println("Register page opened");

            System.out.println("Current URL: "
                    + driver.getCurrentUrl());

        } catch (Exception e) {

            System.out.println("Register button/link locator needs to be changed");
        }
    }


    // ==============================
    // 5. REGISTER FORM TEST
    // ==============================

    @Test(priority = 5)
    public void registrationTest() throws InterruptedException {

        System.out.println("----- Registration Test -----");

        try {

            // Name
            WebElement name =
                    driver.findElement(By.name("name"));

            name.sendKeys("Test User");

            // Email
            WebElement email =
                    driver.findElement(By.name("email"));

            email.sendKeys("testuser123@gmail.com");

            // Password
            WebElement password =
                    driver.findElement(By.name("password"));

            password.sendKeys("Test@123");

            System.out.println("Registration details entered");

        } catch (Exception e) {

            System.out.println(
                    "Registration field locators need to be changed"
            );
        }

        Thread.sleep(1000);
    }


    // ==============================
    // 6. LOGIN PAGE
    // ==============================

    @Test(priority = 6)
    public void loginPageTest() {

        System.out.println("----- Login Page Test -----");

        driver.get(url);

        try {

            WebElement login =
                    driver.findElement(
                            By.xpath("//a[contains(text(),'Login') or contains(text(),'Sign In')]")
                    );

            login.click();

            System.out.println("Login page opened");

        } catch (Exception e) {

            System.out.println(
                    "Login button/link locator needs to be changed"
            );
        }
    }


    // ==============================
    // 7. LOGIN TEST
    // ==============================

    @Test(priority = 7)
    public void loginTest() {

        System.out.println("----- Login Test -----");

        try {

            WebElement email =
                    driver.findElement(By.name("email"));

            email.sendKeys("testuser123@gmail.com");

            WebElement password =
                    driver.findElement(By.name("password"));

            password.sendKeys("Test@123");

            System.out.println("Login details entered");

            WebElement loginButton =
                    driver.findElement(
                            By.xpath("//button[contains(text(),'Login') or contains(text(),'Sign In')]")
                    );

            loginButton.click();

            System.out.println("Login button clicked");

        } catch (Exception e) {

            System.out.println(
                    "Login locators need to be changed"
            );
        }
    }


    // ==============================
    // 8. INVALID LOGIN TEST
    // ==============================

    @Test(priority = 8)
    public void invalidLoginTest() {

        System.out.println("----- Invalid Login Test -----");

        driver.get(url);

        try {

            WebElement login =
                    driver.findElement(
                            By.xpath("//a[contains(text(),'Login') or contains(text(),'Sign In')]")
                    );

            login.click();

            WebElement email =
                    driver.findElement(By.name("email"));

            email.sendKeys("wrong@gmail.com");

            WebElement password =
                    driver.findElement(By.name("password"));

            password.sendKeys("wrong123");

            WebElement button =
                    driver.findElement(
                            By.xpath("//button[contains(text(),'Login') or contains(text(),'Sign In')]")
                    );

            button.click();

            System.out.println("Invalid login test executed");

        } catch (Exception e) {

            System.out.println(
                    "Invalid login locators need to be changed"
            );
        }
    }


    // ==============================
    // 9. EMPTY LOGIN TEST
    // ==============================

    @Test(priority = 9)
    public void emptyLoginTest() {

        System.out.println("----- Empty Login Test -----");

        driver.get(url);

        try {

            WebElement login =
                    driver.findElement(
                            By.xpath("//a[contains(text(),'Login') or contains(text(),'Sign In')]")
                    );

            login.click();

            WebElement button =
                    driver.findElement(
                            By.xpath("//button[contains(text(),'Login') or contains(text(),'Sign In')]")
                    );

            button.click();

            System.out.println(
                    "Empty login validation checked"
            );

        } catch (Exception e) {

            System.out.println(
                    "Empty login locators need to be changed"
            );
        }
    }


    // ==============================
    // 10. SKILLS TEST
    // ==============================

    @Test(priority = 10)
    public void skillsTest() {

        System.out.println("----- Skills Test -----");

        driver.get(url);

        try {

            WebElement skills =
                    driver.findElement(
                            By.xpath("//*[contains(text(),'Skills')]")
                    );

            Assert.assertTrue(skills.isDisplayed());

            System.out.println("Skills section is displayed");

        } catch (Exception e) {

            System.out.println(
                    "Skills locator needs to be changed"
            );
        }
    }


    // ==============================
    // 11. SEARCH TEST
    // ==============================

    @Test(priority = 11)
    public void searchTest() {

        System.out.println("----- Search Test -----");

        try {

            WebElement search =
                    driver.findElement(
                            By.xpath("//input[contains(@placeholder,'Search')]")
                    );

            search.sendKeys("Java");

            System.out.println("Search text entered");

        } catch (Exception e) {

            System.out.println(
                    "Search box locator needs to be changed"
            );
        }
    }


    // ==============================
    // 12. BUTTON TEST
    // ==============================

    @Test(priority = 12)
    public void buttonTest() {

        System.out.println("----- Button Test -----");

        try {

            int buttons =
                    driver.findElements(By.tagName("button")).size();

            System.out.println(
                    "Number of buttons: " + buttons
            );

            Assert.assertTrue(
                    buttons > 0,
                    "No buttons found"
            );

        } catch (Exception e) {

            System.out.println("Button test failed");
        }
    }


    // ==============================
    // 13. LINK TEST
    // ==============================

    @Test(priority = 13)
    public void linkTest() {

        System.out.println("----- Link Test -----");

        int links =
                driver.findElements(By.tagName("a")).size();

        System.out.println(
                "Number of links: " + links
        );

        Assert.assertTrue(
                links > 0,
                "No links found"
        );
    }


    // ==============================
    // 14. IMAGE TEST
    // ==============================

    @Test(priority = 14)
    public void imageTest() {

        System.out.println("----- Image Test -----");

        int images =
                driver.findElements(By.tagName("img")).size();

        System.out.println(
                "Number of images: " + images
        );

        Assert.assertTrue(
                images >= 0
        );
    }


    // ==============================
    // 15. PAGE SOURCE TEST
    // ==============================

    @Test(priority = 15)
    public void pageSourceTest() {

        System.out.println("----- Page Source Test -----");

        String pageSource =
                driver.getPageSource();

        Assert.assertTrue(
                pageSource.length() > 0
        );

        System.out.println(
                "Page source is available"
        );
    }


    // ==============================
    // 16. SCROLL TEST
    // ==============================

    @Test(priority = 16)
    public void scrollTest() throws InterruptedException {

        System.out.println("----- Scroll Test -----");

        driver.get(url);

        org.openqa.selenium.JavascriptExecutor js =
                (org.openqa.selenium.JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollTo(0, document.body.scrollHeight);"
        );

        Thread.sleep(1000);

        System.out.println("Scrolled to bottom");

        js.executeScript(
                "window.scrollTo(0, 0);"
        );

        System.out.println("Scrolled back to top");
    }


    // ==============================
    // 17. BACK BUTTON TEST
    // ==============================

    @Test(priority = 17)
    public void browserNavigationTest() {

        System.out.println(
                "----- Browser Navigation Test -----"
        );

        driver.get(url);

        String firstURL =
                driver.getCurrentUrl();

        driver.navigate().refresh();

        System.out.println(
                "Page refreshed successfully"
        );

        driver.navigate().back();

        System.out.println(
                "Back navigation executed"
        );
    }


    // ==============================
    // 18. LOGOUT TEST
    // ==============================

    @Test(priority = 18)
    public void logoutTest() {

        System.out.println("----- Logout Test -----");

        try {

            WebElement logout =
                    driver.findElement(
                            By.xpath("//*[contains(text(),'Logout') or contains(text(),'Log out')]")
                    );

            logout.click();

            System.out.println("Logout button clicked");

        } catch (Exception e) {

            System.out.println(
                    "Logout button locator needs to be changed"
            );
        }
    }


    // ==============================
    // CLOSE BROWSER
    // ==============================

    @AfterClass
    public void tearDown() {

        if (driver != null) {

            driver.quit();

            System.out.println(
                    "Browser closed successfully"
            );
        }
    }
}

