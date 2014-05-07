package org.cookbookgeeks.webkochbuch;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;
 

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})

public class RunTests {

}