package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void TC_01() {
        // ID
        driver.findElement(By.id("firstname")).sendKeys("Automation");
        sleedInSecond(1);

        // Name
        driver.findElement(By.name(("lastname"))).sendKeys("FC");
        sleedInSecond(1);

        // Class
        driver.findElement(By.className("customer-name-middlename")).isDisplayed();
        driver.findElement(By.className("name-middlename")).isDisplayed();
        sleedInSecond(1);

        // Tagname
        int inputNumber = driver.findElements(By.tagName("input")).size();
        System.out.println(inputNumber);
        sleedInSecond(1);

        // LinkText
        driver.findElement(By.linkText(("SEARCH TERMS"))).click();
        sleedInSecond(1);

        // Partial LinkText
        driver.findElement((By.partialLinkText("ADVANCED"))).click();
        sleedInSecond(1);

        // CSS
        driver.findElement(By.cssSelector("input[id='name']")).sendKeys("iPhone");
        sleedInSecond(1);

        driver.findElement(By.cssSelector("input[name='name']")).clear();
        driver.findElement((By.cssSelector("input[name='name']"))).sendKeys("Samsung Note 20");
        sleedInSecond(1);

        driver.findElement(By.cssSelector("#name")).clear();
        driver.findElement((By.cssSelector("#name"))).sendKeys("iPhone 15");
        sleedInSecond(1);

        // Xpath
        driver.findElement(By.xpath("//input[@name='description']")).clear();
        driver.findElement((By.xpath("//input[@name='description']"))).sendKeys("VN");
        sleedInSecond(1);


        driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/input")).clear();
        driver.findElement((By.xpath("//label[text()='Description']/following-sibling::div/input"))).sendKeys("USA");
        sleedInSecond(1);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleedInSecond (long second){
        try{
            Thread.sleep(second * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
