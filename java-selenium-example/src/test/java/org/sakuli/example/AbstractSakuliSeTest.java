package org.sakuli.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sakuli.actions.environment.Environment;
import org.sakuli.actions.logging.Logger;
import org.sakuli.actions.screenbased.Region;
import org.sakuli.exceptions.SakuliException;
import org.sakuli.selenium.HighlightElement;
import org.sakuli.selenium.actions.testcase.SeTestCaseAction;
import org.sakuli.selenium.testng.SakuliSeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author tschneck
 *         Date: 1/23/17
 */
@Listeners(SakuliSeTest.class)
public abstract class AbstractSakuliSeTest {

    protected WebDriver driver;
    protected HighlightElement dsl;
    protected Region screen;
    protected Environment env;
    protected SeTestCaseAction tcAction;

    private static RemoteWebDriver getSeleniumDriver() {
        return new ChromeDriver();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = getSeleniumDriver();
        dsl = new HighlightElement((JavascriptExecutor) driver);
        env = new Environment();
        screen = new Region();
        tcAction = new SeTestCaseAction();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null)
            driver.close();
    }


    public void scroll(Supplier<Region> check, Supplier doScroll, int times) throws SakuliException {
        for (int i = 1; !Optional.ofNullable(check.get()).isPresent() && i <= times; i++) {
            Logger.logInfo("Scroll page (" + i + ")");
            doScroll.get();
        }
        Optional.ofNullable(check.get()).orElseThrow(() -> new SakuliException("Cannot find region by scrooling!")).highlight();
    }
}
