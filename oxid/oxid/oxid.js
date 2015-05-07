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
var testCase = new TestCase(60, 70);
var env = new Environment();
var screen = new Region();


try {
	 _navigateTo("http://192.168.122.16/shop/");
	_click(_span("Konto"));

	for (i=0; i<100; i++) {
		_click(_link("Registrieren"));

		screen.waitForImage("vorname",10).click();
		screen.waitForImage("vorname_act",10);
		env.type("1-2-3-4-5-6-7-8-9");
		env.type(Key.TAB);
		env.type("1-2-3-4-5-6-7-8-9");
		env.type(Key.TAB);
		env.type("1-2-3-4-5-6-7-8-9");
		env.type(Key.TAB);
		env.type("1-2-3-4-5-6-7-8-9");
		env.type(Key.TAB);
		env.type("1-2-3-4-5-6-7-8-9");
		
		
		_assertContainsText("1-2-3-4-5-6-7-8-9", _textbox("invadr[oxuser__oxfname]"));
		_assertContainsText("1-2-3-4-5-6-7-8-9", _textbox("invadr[oxuser__oxlname]"));
		_assertContainsText("1-2-3-4-5-6-7-8-9", _textbox("invadr[oxuser__oxcompany]"));
		_assertContainsText("1-2-3-4-5-6-7-8-9", _textbox("invadr[oxuser__oxaddinfo]"));
		_assertContainsText("1-2-3-4-5-6-7-8-9", _textbox("invadr[oxuser__oxstreet]"));
		_assertContainsText("1-2-3-4-5-6-7-8-9", _textbox("invadr[oxuser__oxfname]"));
		_assertContainsText("1-2-3-4-5-6-7-8-9", _textbox("invadr[oxuser__oxstreetnr]"));
	}
} catch (e) {
    testCase.handleException(e);
} finally {
    testCase.saveResult();
}
