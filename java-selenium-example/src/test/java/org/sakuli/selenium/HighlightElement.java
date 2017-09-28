package org.sakuli.selenium; /**
 * @author tschneck
 * Date: 1/23/17
 */

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sakuli.actions.environment.Environment;

//import com.project.setup.WebDriverManager;

public class HighlightElement {

    private JavascriptExecutor javascriptExecutor;
    private Environment env;

    public HighlightElement(JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
        this.env = new Environment();
    }

    public void highlightElement(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 2px solid red;");
        env.sleepMs(500);
        javascriptExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
    }
}
