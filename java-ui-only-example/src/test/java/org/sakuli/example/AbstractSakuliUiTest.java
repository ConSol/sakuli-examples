package org.sakuli.example;

import org.sakuli.actions.environment.Application;
import org.sakuli.actions.environment.Environment;
import org.sakuli.actions.screenbased.Region;
import org.sakuli.exceptions.SakuliException;
import org.sakuli.javaDSL.AbstractSakuliTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class AbstractSakuliUiTest extends AbstractSakuliTest {

    protected Region screen;
    protected Environment env;
    protected Application editor;
    protected Application calculator;

    @BeforeClass
    @Override
    public void initTC() throws Exception {
        super.initTC();
        env = new Environment();
        screen = new Region();
        editor = getEditorApp();
        calculator = getCalculatorApp();
    }

    @AfterMethod
    public void closeApp() throws Exception {
        editor.kill(true);
        calculator.kill(true);
    }

    /**
     * @return an {@link Application} definition of the target editor
     */
    protected abstract Application getEditorApp();

    /**
     * @return an {@link Application} definition of the target calculator
     */
    protected abstract Application getCalculatorApp();

    /**
     * Method which can be used to determine if the test is running on the estimated UI environment.
     */
    protected abstract boolean isTargetEnvironment() throws SakuliException;
}
