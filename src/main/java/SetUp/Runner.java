package SetUp;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/features",
        glue = "Steps",
        plugin = { "pretty", "json:target/report/json/output.json",
        "html:target/report/html/index.html" }
)

public class Runner {

}
