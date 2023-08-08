package com.test.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "pretty"
        },
        features = "src/test/resources/features",
        glue = "com/test/step_def",
        dryRun = false,
        tags = "@test1"
)
public class TestRunner {
}
