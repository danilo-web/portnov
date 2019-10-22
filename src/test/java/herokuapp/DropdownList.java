package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownList {
    WebDriver driver;

    @Test
    public void test001() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowserOpenPage();
        dropdownDefaultValueVerification();
        changeOptionInDropDownw();
        verifyCorrectOption();

        driver.quit();
    }


    private void verifyCorrectOption() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropdownAllElements = dropdown.getOptions();

        boolean actualDropdownOption = dropdownAllElements.get(1).isDisplayed();
        Assert.assertEquals(actualDropdownOption, true, "");

        System.out.println("\"" + dropdownAllElements.get(1).getText() + "\" selected in dropdown.");

    }

    private void changeOptionInDropDownw() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(1);

        List<WebElement> dropdownCountElements = dropdown.getOptions();
        boolean i = dropdownCountElements.get(1).isDisplayed();
        Assert.assertEquals(i, true);

    }

    private void dropdownDefaultValueVerification() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropdownAllElements = dropdown.getOptions();

        boolean actualDropdownOption = dropdownAllElements.get(0).isDisplayed();
        Assert.assertEquals(actualDropdownOption, true, "");
    }

    private void openBrowserOpenPage() {
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

}
