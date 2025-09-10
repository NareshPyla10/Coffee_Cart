package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "C:\\Users\\nares\\IdeaProjects\\CoffeeCart\\src\\test\\resources\\features\\Menu.feature",
        glue = "StepDef"
)
public class MenuRunner extends AbstractTestNGCucumberTests {
}
