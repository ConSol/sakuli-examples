package org.sakuli.selenium; /**
 * @author tschneck
 * Date: 1/23/17
 */

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

//import com.project.setup.WebDriverManager;

public class HighlightElement {

    private JavascriptExecutor javascriptExecutor;

    public HighlightElement(JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
    }

    public void highlightElement(WebElement element) {
        for (int i = 0; i < 2; i++) {
            javascriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
            javascriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        }
    }
}
