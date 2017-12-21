package org.sakuli.example.github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sakuli.actions.screenbased.Key;
import org.sakuli.actions.screenbased.Region;
import org.sakuli.example.AbstractSakuliSeTest;
import org.sakuli.selenium.testng.SakuliTestCase;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Test the website of the Citrus integration testing framework.
 *
 * @author tschneck
 *         Date: 12/2/15
 */
public class GitHubSakuliSeExampleTest extends AbstractSakuliSeTest {

    private static final String SAKULI_URL = "https://github.com/ConSol/sakuli/blob/master/README.adoc";

    @Test
    @SakuliTestCase(additionalImagePaths = "/common_pics")
    public void test1() throws Exception {
        //your test code
        driver.get(SAKULI_URL);
        screen.highlight();
        screen.find("sakuli_logo.png").highlight();
    }

    @Test
    @SakuliTestCase(testCaseName = "mysecondtest", warningTime = 10, criticalTime = 20, additionalImagePaths = "/common_pics")
    public void test2() throws Exception {
        //your test code
        driver.get(SAKULI_URL);
        screen.highlight();
        screen.type(Key.END).find("github_logo.png").highlight();
    }

}