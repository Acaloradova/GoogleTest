import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeTest {

    public static  WebDriver DRIVER;

    @BeforeClass
    public void setUp(){
        DRIVER = new FirefoxDriver();
    }

    @org.testng.annotations.Test
    public void testSelenium(){

        DRIVER.get("http://google.com");
        WebElement searchField = DRIVER.findElement(By.id("lst-ib"));
        searchField.sendKeys("grid dynamics");
        searchField.sendKeys(Keys.ENTER);
        List<WebElement> links = DRIVER.findElements(By.xpath("//div[@id='res']//h3"));
        assertEquals(links.size(), 10);
        for (WebElement link : links) {
            assertTrue(link.getText().contains("Grid Dynamics"));
        }
    }

    @AfterClass
    public void tearDown(){
        DRIVER.close();
    }

}
