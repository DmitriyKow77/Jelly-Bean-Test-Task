package drivers.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Dropdown{
    public WebElement element;

    public Dropdown(WebElement element) {
        this.element = element;
    }

    public WebElement get_option_by_name(String search_text) throws IllegalArgumentException {
        return this.element.findElements(By.tagName("option"))
                .stream()
                .filter(i -> i.getText().contains(search_text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Element with text " + search_text + " not exists"));
    }
}
