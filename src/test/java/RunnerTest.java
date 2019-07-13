/**
 * Created by dmitriy on 2/10/19.
 */
import cucumber.api.CucumberOptions;
        import cucumber.api.SnippetType;
        import cucumber.api.junit.Cucumber;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"info.stepdefinitions"},
        tags = "@all",
        dryRun = false,
        strict = false,
        snippets = SnippetType.UNDERSCORE
)
public class RunnerTest {
}