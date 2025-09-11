package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "C:\\Users\\nares\\IdeaProjects\\CoffeeCart\\src\\test\\resources\\features\\Menu.feature",
        glue = "StepDef",
        monochrome = true,
        plugin = {
                "pretty",                               // ✅ Better console output format
                "html:target/cucumber-reports.html",    // ✅ HTML report
                "json:target/cucumber.json",            // ✅ JSON report
                "junit:target/cucumber.xml"             // ✅ JUnit XML report
        }
)
public class MenuRunner extends AbstractTestNGCucumberTests {
}
