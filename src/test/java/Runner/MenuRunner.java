package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "classpath:features",  // ✅ better than hardcoding src/test/resources
        glue = "StepDef",                              // ✅ your step definition package
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class MenuRunner extends AbstractTestNGCucumberTests {
}
