package com.jalasoft.xpress.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        format = {"pretty",
                "html:build/cucumber-html-report",
                "json:build/cucumber.json",
                "junit:build/test-report.xml"},
        features = {"src/test/resources/"},
        glue = {"com.jalasoft.xpress.cucumber"},
        snippets = SnippetType.CAMELCASE
)
public class Runner {

}

