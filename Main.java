
mypackage whiletrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    WebDriver driver;
    JavascriptExecutor jse;

    public void invokeBrowser() {

        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\renata\\Documents\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            driver.get("http://www.mcstaging.net");
            searchMagazine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchMagazine() {
        driver.findElement(By.id("headerSearchBox")).sendKeys("New publication");
        driver.findElement(By.id("headerSearchButton")).click();
        jse = (JavascriptException)driver;
        jse.executeScript("scroll(0, 3000)");
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();

    }

    public static void main(String[] args) {
        Main myObj = new Main();
        myObj.invokeBrowser();
        myObj.searchMagazine();
    }
}
