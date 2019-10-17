import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AirBnB {
    WebDriver driver;

    @Test
    public void testFirst() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowser();
        navigateToMainPage();

        driver.findElement(By.id("Koan-magic-carpet-koan-search-bar__input")).click();
        driver.findElement(By.id("Koan-magic-carpet-koan-search-bar__input")).clear();
        driver.findElement(By.id("Koan-magic-carpet-koan-search-bar__input")).sendKeys("nyc");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in'])[1]/following::div[8]")).click();
        driver.findElement(By.id("lp-guestpicker")).click();
        driver.findElement(By.cssSelector("span._1y1icpxd > svg")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='GUESTS'])[1]/following::div[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='GUESTS'])[1]/following::span[2]")).click();


        //findWhereString();
        //typeWhere();
        //clickAnywhere();
        //openDropDownGuests();
        //selectInDropDownGuest();
        //submitSearch();
    }

    private void submitSearch() {
        String search = "//*[@id=\"FMP-target\"]/div/div[1]/div/div/div/div/div/div[2]/div/form/div[4]/div/button";
        driver.findElement(By.xpath(search)).click();
    }
    private void selectInDropDownGuest() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        String adults = "#FMP-target > div > div._ogalm0 > div > div > div > div > div > div:nth-child(2) > div > form > div:nth-child(3) > div > " +
                "div._e296pg > div > div > div._1im57cu > div:nth-child(2) > div._3zlfom > button:nth-child(3)";
        driver.findElement(By.cssSelector(adults)).click();
    }
    private void openDropDownGuests() {
        String guest = "lp-guestpicker";
        driver.findElement(By.id(guest)).click();
    }
    private void clickAnywhere() {
        String header = "#FMP-target > div > div._ogalm0 > div > div > div > div > div > div._ubzwse > h1";
        driver.findElement(By.cssSelector(header));
    }
    private void typeWhere() {
        String firstElement = "#Koan-magic-carpet-koan-search-bar__input";
        WebElement webElement = driver.findElement(By.cssSelector(firstElement));
        webElement.sendKeys("NYC");
    }
    private void findWhereString() {
        driver.findElement(By.cssSelector("#Koan-magic-carpet-koan-search-bar__input"));
    }
    private void navigateToMainPage() {
        String url = "https:/www.airbnb.com";
        driver.get(url);
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
/*     driver.get("https://www.airbnb.com/");
    driver.findElement(By.id("Koan-magic-carpet-koan-search-bar__input")).click();
    driver.findElement(By.id("Koan-magic-carpet-koan-search-bar__input")).clear();
    driver.findElement(By.id("Koan-magic-carpet-koan-search-bar__input")).sendKeys("nyc");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in'])[1]/following::div[8]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='GUESTS'])[1]/following::div[2]")).click();
    driver.findElement(By.cssSelector("span._1y1icpxd > svg")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='GUESTS'])[1]/following::div[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='GUESTS'])[1]/following::span[2]")).click();
  }

 */