/*
 * Sakuli - Testing and Monitoring-Tool for Websites and common UIs.
 *
 * Copyright 2013 - 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

_dynamicInclude($includeFolder);
var testCase = new TestCase(20, 30);
var env = new Environment();
var screen = new Region();
var appCalc = new Application("/usr/bin/gnome-calculator");
var appGedit = new Application("/usr/bin/gedit");

try {
    _highlight(_link(/SSL M.*/));
    _highlight(_link("Logs"));
    _highlight(_link("Online Documentation"));
    _highlight(_link("Test Pages"));
    _highlight(_link("Sample Application"));
    testCase.endOfStep("Test Sahi landing page", 5);
    appCalc.open();

    var calcRegion = screen.waitForImage("calculator.png", 5).highlight().mouseMove()
        .move(-15,-10).setH(370).setW(350).highlight();
    //move mouse out of focus
    new RegionRectangle(0,0,0,0).mouseMove();

    env.type("525+100" + Key.ENTER);
    env.sleep(2);
    calcRegion.waitForImage("625", 5).highlight();
    testCase.endOfStep("Calculation", 15);

    appGedit.open();
    screen.waitForImage("gedit.png", 10);
    env.paste(env.getEnv("JAVA_HOME") + Key.ENTER);
    env.paste(env.getProperty("testsuite.id") + Key.ENTER);
    env.paste(env.getProperty("my.user") + Key.ENTER);

    //TEST encryption with masterkey
    env.typeAndDecrypt("i3wqbuF0cNS1csqvKmzkYENv+up0qT6gysSDRb247dg=").type(Key.ENTER);

    env.paste("Initial test passed. Sakuli, Sahi and Sikuli seem to work fine. Exiting...");
    screen.find("gedit_result").highlight();
    testCase.endOfStep("Editor", 15);

} catch (e) {
    testCase.handleException(e);
} finally {
    //env.sleep(99999999);
    appCalc.close(true); //silent
    appGedit.kill(true);  //silent, without exit prompt
    testCase.saveResult();
}
