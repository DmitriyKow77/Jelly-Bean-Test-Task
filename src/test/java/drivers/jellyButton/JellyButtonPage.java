package drivers.jellyButton;

import drivers.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


public class JellyButtonPage extends BasePage {
    public JellyButtonPage(WebDriver driver) {
        super(driver);
    }

    public List<MenuButton> siteMenuButtons(){
       return this.waitForElemenstPresent(By.cssSelector("#main_menu .menu-item"))
               .stream()
               .filter(WebElement::isDisplayed)
               .map(MenuButton::new)
               .collect(Collectors.toList());
    }

    public List<WebElement> subMenuButtons() throws InterruptedException {
        String subButtonCss = ".sub-menu a";
        this.waitForOneOfElementsIsVisible(By.cssSelector(subButtonCss), 5);
        return super.waitForElemenstPresent(By.cssSelector(subButtonCss))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
    }

    public MenuButton getButtonByName(String pageName) {
        return siteMenuButtons()
                .stream()
                .filter(button -> button.getText().contains(pageName.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new WebDriverException("Element with text " + pageName + " not exists"));
    }


    public boolean waitForSubmenuInvisible() {
        return this.waitForElementInvisible(By.cssSelector(".sub-menu a"));
    }

    public WebElement mainSlider() {
        return this.getElement(By.className("home_main_slider_slide_content"));
    }
}