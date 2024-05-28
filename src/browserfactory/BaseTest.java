package browserfactory;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * 1. Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup code inside the class ‘Base Test’.
 */

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        //launch the Chrome browser
        driver = new ChromeDriver();

        //open the URL into Browser
        driver.get(baseUrl);

        //Maximise the browser window
        driver.manage().window().maximize();

        //Give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

