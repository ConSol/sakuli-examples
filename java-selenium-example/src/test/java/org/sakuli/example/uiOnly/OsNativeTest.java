package org.sakuli.example.uiOnly;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.sakuli.actions.environment.Application;
import org.sakuli.actions.environment.Environment;
import org.sakuli.actions.logging.Logger;
import org.sakuli.actions.screenbased.Region;
import org.sakuli.selenium.actions.testcase.SeTestCaseAction;
import org.sakuli.selenium.testng.SakuliSeTest;
import org.sakuli.selenium.testng.SakuliTestCase;
import org.sakuli.utils.ResourceHelper;
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
    private SeTestCaseAction tc;

    @BeforeMethod
    public void setUp() throws Exception {
        gedit = new Application("gedit");
        screen = new Region();
        env = new Environment();
        tc = new SeTestCaseAction();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        if (gedit != null) {
            gedit.closeApp();
        }
    }

    private void checkEnvironment() throws Exception {
        if (StringUtils.isNotBlank(System.getenv("VNC_PORT"))) {
            Logger.logInfo("----- load XFCE based screenshots");
            tc.addImagePaths(ResourceHelper.getClasspathResource(OsNativeTest.class, "xfce-env", "image folder for XFCE env not found"));
        }
    }

    @Test
    @SakuliTestCase(warningTime = 50, criticalTime = 60)
    public void testNativeFileContentAccessesOverUI() throws Exception {
        checkEnvironment();
        gedit.open();

        // shows fluent API and how sub regions can be used
        final Region otherDocument = screen.waitForImage("gedit", 5).highlight()
                .click()
                .below(200).setW(300).highlight()
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
                .left(50).highlight().click()
                .type("README").type(Key.ENTER)
                .sleep(2);
        screen.find("gedit").highlight();

        //mark all and copy it to the clipboard
        env.type("a", Key.CTRL).type("c", Key.CTRL);
        final String clipboard = env.getClipboard();
        //assert the readme content
        System.out.println(clipboard);
        Assert.assertTrue(clipboard.contains("Sakuli Selenium"));
//      env.sleep(9999999);

    }
}
