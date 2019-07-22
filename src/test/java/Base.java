import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by delonj on 21/04/2017.
 */
public class Base {

    static Logger logger = LoggerFactory.getLogger(Base.class.getSimpleName());

    private WebDriver driver;

//    WebDriver driver = new SafariDriver();

    @Test
    public void testGoogleSearch() throws InterruptedException {
        logger.isInfoEnabled();
        // Optional, if not specified, WebDriver will search your path for chromedriver.
//        System.setProperty("webdriver.safari.driver", "/Applications/Safari.app/Contents/MacOS/Safari");
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.google.com/");

        Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Ветер");
        searchBox.submit();

        Thread.sleep(5000);  // Let the user actually see something!
    }
    @AfterClass
    public void tearDown() {
        driver.quit();


    }



}
