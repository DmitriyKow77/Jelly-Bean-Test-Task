package drivers.jellyButton;


import drivers.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MenuButton extends BaseElement {
    public MenuButton(WebElement element) {
        super(element);
    }

    public boolean hasSubmenu(){
        return this.element.getAttribute("class").contains("menu-item-has-children");
    }
}
