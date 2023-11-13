package nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Nop_Commerce_MultiBrowser {
    //Multi-Browser
    static String browser = "Chrome";
    //static String browser = "Firefox";
    //static String browser = "Edge";
    static String baseUrl = "https://demo.nopcommerce.com/";
    //launch the browsers
    static WebDriver driver;

    public void multiBrowserTest() {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
    }

    public static void main(String[] args) {
        //object creation for method multiBrowserTest
        Nop_Commerce_MultiBrowser obj = new Nop_Commerce_MultiBrowser();
        //calling the method
        obj.multiBrowserTest();

        //open the URL into the browser
        driver.get(baseUrl);

        //maximise the browser
        driver.manage().window().maximize();

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Print the title of the page
        String title = driver.getTitle();
        //System.out.println(title);
        System.out.println("The title is: " + driver.getTitle());

        //print the current URL
        driver.getCurrentUrl();
        System.out.println("The current URL: " + driver.getCurrentUrl());

        //Print the page source
        driver.getPageSource();
        System.out.println("The page source is: " + driver.getPageSource());

        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";

        //Navigate to login URL
        driver.navigate().to(loginUrl);
        System.out.println("Navigate to current login URL: " + driver.getCurrentUrl());

        //Navigate back to the homepage
        driver.navigate().back();
        System.out.println("Navigate back to the homepage: " + driver.getCurrentUrl());

        //Navigate to the login page
        driver.navigate().forward();
        System.out.println("Navigate to the login page: " + driver.getCurrentUrl());

        //Print the current url.
        System.out.println("Print the current URL: " + driver.getCurrentUrl());

        //refresh the page
        driver.navigate().refresh();
        System.out.println("Refreshing the page: " + driver.getCurrentUrl());

        //Find email field elements and click on it
        //WebElement loginLink = driver.findElement(By.linkText("Log in"));
        //loginLink.click();


        //Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("abc123@gmail.com");

        //Enter the password to password field.
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("abc123");

        //Click on Login Button.
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        //Closing the browser automatically
        driver.quit();
    }
}

