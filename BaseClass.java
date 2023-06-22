package Base;

import ConstantPath.ConstantPaths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    private static Properties pro;// it is a class

    public static WebDriver driver;
    protected static WebDriverWait wait;//is a class
    @BeforeSuite
    public void propReading() throws IOException {
        try {
            File file = new File(ConstantPaths.PROP_PATH);
            FileInputStream fileInputStream = new FileInputStream(file);//it is a class of java.io.package to read data from files.
            pro = new Properties();
            pro.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Properties file not found");
        }
    }
        @BeforeClass
        public static void initializeBrowser()
        {
            switch (pro.getProperty("browserName").toUpperCase()) {
                case "CHROME":
                    driver = new ChromeDriver();
                    ChromeOptions options = new ChromeOptions();
                    break;
                case "FIREFOX":
                    driver = new FirefoxDriver();
                    break;
                case "SAFARI":
                    driver = new SafariDriver();
                default:
                    System.out.println("Illegal browser name");
                    break;
            }
            driver.manage().window().maximize();
            driver.get(pro.getProperty("urlName"));
            wait= new WebDriverWait(driver, Duration.ofSeconds(20));

            }

    }


