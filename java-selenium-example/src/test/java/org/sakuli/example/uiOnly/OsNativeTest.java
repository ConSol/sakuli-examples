package org.sakuli.example.uiOnly;

import org.junit.Assert;
import org.sakuli.actions.environment.Application;
import org.sakuli.actions.environment.Environment;
import org.sakuli.actions.screenbased.Region;
import org.sakuli.selenium.testng.SakuliSeTest;
import org.sakuli.selenium.testng.SakuliTestCase;
import org.sikuli.script.Key;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author tschneck
 *         Date: 4/27/17
 */
@Listeners(SakuliSeTest.class)
public class OsNativeTest {
    private Application gedit;
    private Region screen;
    private Environment env;

    @BeforeMethod
    public void setUp() throws Exception {
        gedit = new Application("gedit");
        screen = new Region();
        env = new Environment();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        if (gedit != null) {
            gedit.closeApp();
        }
    }

    @Test
    @SakuliTestCase(additionalImagePaths = "/common_pics")
    public void testNativeFileContentAccessesOverUI() throws Exception {
        gedit.open();

        // shows fluent API and how sub regions can be used
        final Region otherDocument = screen.find("gedit").highlight()
                .click()
                .below(200).highlight()
                .waitForImage("search", 20)
                .highlight()
                .click()
                .type("Hello Guys!")
                .grow(400, 500).highlight(3)
                .find("other_documents").highlight();
        ;
        otherDocument.click();
//        final String s = otherDocument.extractText();
//        Logger.logInfo("TEXT: " + s);
//        otherDocument.grow(0,600).takeScreenshot("/tmp/button_large");

        //open readme file
        screen.waitForImage("cancel_button.png", 5).highlight()
                .left(30).highlight().click()
                .type("Readme").type(Key.ENTER)
                .sleep(2);
        screen.find("gedit").highlight();

        //mark all and copy it to the clipboard
        env.type("a", Key.CTRL).type("c", Key.CTRL);
        final String clipboard = env.getClipboard();
        //assert the readme content
        System.out.println(clipboard);
        Assert.assertTrue(clipboard.contains("Sakuli Selenium"));
    }
}
