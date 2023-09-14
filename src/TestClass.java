import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch() {
        // Open Google homepage
        driver.get("https://www.google.com");

        // Find the search box element
        WebElement searchBox = driver.findElement(By.name("q"));

        // Enter a search query
        searchBox.sendKeys("TestNG Selenium Example");

        // Submit the search query
        searchBox.submit();

        // Wait for a few seconds to see the results
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert that the search results page title contains the query
        String pageTitle = driver.getTitle();
        assert pageTitle.contains("TestNG Selenium Example");
    }

    @AfterTest
    public void teardown() {
        // Close the browser
        driver.quit();
    }
}
