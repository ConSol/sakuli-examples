package org.sakuli.example.citrus;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sakuli.actions.logging.Logger;
import org.sakuli.actions.screenbased.Key;
import org.sakuli.actions.screenbased.Region;
import org.sakuli.example.AbstractSakuliSeTest;
import org.sakuli.exceptions.SakuliException;
import org.sakuli.selenium.testng.SakuliTestCase;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.function.Supplier;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Test the website of the Citrus integration testing framework.
 *
 * @author tschneck
 *         Date: 12/2/15
 */
public class FirstSakuliSeExampleTest extends AbstractSakuliSeTest {

    private static final String CITRUS_URL = "http://www.citrusframework.org/";
    private static int hSec = 2;

    @Test
    @Ignore
    @SakuliTestCase(additionalImagePaths = "citrus_pics")
    public void testLogos() throws Exception {
        searchHeading();
        screen.find("citrus_logo.png").highlight(hSec);
        screen.type(Key.END).find("consol_logo.png").highlight(hSec);
    }

    @Test
    @Ignore
    @SakuliTestCase
    public void testCitrusHtmlContent() throws Exception {
        testCitrusContent("HTML");

        //VALIDATE HTML content
        WebElement heading = driver.findElement(By.cssSelector("#citrus-framework--reference-documentation-"));
        dsl.highlightElement(heading);
        assertEquals(heading.getText(), "Citrus Framework - Reference Documentation");
        assertTrue(heading.isDisplayed());
    }

    @Test
    @SakuliTestCase(additionalImagePaths = "citrus_pics")
    public void testCitrusPdfContent() throws Exception {
        testCitrusContent("PDF");
        screen.find("reload_button.png").highlight();

        scroll( //search for logo
                () -> screen.exists("citrus_fruit.png", 1),
                //scroll action
                () -> env.type(Key.DOWN).type(Key.DOWN).type(Key.DOWN).type(Key.DOWN),
                //times to try
                10
        );
        env.sleep(hSec);

        screen.find("reload_button.png")
                .below(40).highlight()
                .mouseMove();
        screen.find("bookmark_button.png").highlight().click();
        screen.find("bookmark_entry.png").highlight().click();
        screen.find("test_case_pdf_heading.png").highlight().click();

        scroll(() -> screen.exists("test_case_diagram.png", 1),
                () -> env.type(Key.DOWN).type(Key.DOWN).type(Key.DOWN).type(Key.DOWN),
                10
        );
    }

    public void testCitrusContent(String dest) throws Exception {
        searchHeading();

        WebElement documentationLink = driver.findElement(By.partialLinkText("Documentation"));
        dsl.highlightElement(documentationLink);
        assertTrue(documentationLink.isDisplayed());
        documentationLink.click();

        WebElement userGuideLink = driver.findElement(By.partialLinkText("User Guide"));
        dsl.highlightElement(userGuideLink);
        assertTrue(userGuideLink.isDisplayed());
        userGuideLink.click();

        WebElement htmlUserGuideLink = driver.findElement(By.partialLinkText(dest));
        dsl.highlightElement(htmlUserGuideLink);
        assertTrue(htmlUserGuideLink.isDisplayed());
        htmlUserGuideLink.click();
    }

    private void searchHeading() {
        driver.get(CITRUS_URL);
        WebElement heading1 = driver.findElement(By.cssSelector("p.first"));
        dsl.highlightElement(heading1);
        assertTrue(heading1.isDisplayed());
    }


}