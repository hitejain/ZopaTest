import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(   monochrome = true,
                    features = "src/test/resources/features/",
                    tags = "@sanityTest",
                    plugin = {"pretty","html:target/cucumber-report/cucumber","json:target/cucumber-report/cucumber.json"})
public class CucumberRunnerTest {
}
