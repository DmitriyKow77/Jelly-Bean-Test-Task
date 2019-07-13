package info.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import drivers.jellyButton.JellyButtonPage;
import drivers.jellyButton.MenuButton;
import drivers.utils.DriverUtil;
import drivers.utils.ScreenShotUtil;
import org.openqa.selenium.*;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by dmitriy on 7/11/19.
 */
public class TestStepsJelly {
    private WebDriver driver;
    private JellyButtonPage jellyButtonPage;

    public TestStepsJelly() {
        driver = DriverUtil.get_driver();
    }

    @And("^I print current url$")
    public void iPrintCurrentUrl() throws Throwable {
        System.out.println("Current url is: " + driver.getCurrentUrl());
    }

    @And("^I save screenshot with name \"([^\"]*)\"$")
    public void iSaveScreenshotWithName(String screenshotName) throws Throwable {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        ScreenShotUtil.saveScreenshot(scrFile, screenshotName);
    }

    @When("^I Print out all of the upper menu elements names$")
    public void iPrintOutAllOfTheUpperMenuElementsNames() throws Throwable {
        jellyButtonPage = new JellyButtonPage(driver);
        ArrayList<String> buttonsText = new ArrayList<>();

        for (MenuButton button : jellyButtonPage.siteMenuButtons()){
            buttonsText.add(button.getText());

            if (button.hasSubmenu()) {
                button.click();
                for (WebElement subButton : jellyButtonPage.subMenuButtons()){
                    buttonsText.add(subButton.getText());
                }
            }

            jellyButtonPage.mainSlider().click();
            jellyButtonPage.waitForSubmenuInvisible();
        }

        System.out.println("Menu buttons text is: " + buttonsText.toString());
    }

    @When("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String pageName) throws Throwable {
        MenuButton selectedButton = jellyButtonPage.getButtonByName(pageName);

        selectedButton.click();
    }
}
