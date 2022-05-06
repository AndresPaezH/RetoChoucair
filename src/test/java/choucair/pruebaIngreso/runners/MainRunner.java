package choucair.pruebaIngreso.runners;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import cucumber.api.SnippetType;
import choucair.pruebaIngreso.utilidades.BeforeSuite;
import choucair.pruebaIngreso.utilidades.DataToFeature;
import cucumber.api.CucumberOptions;





@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
features = "src/test/resources/features/"
,glue = "choucair.pruebaIngreso.definitions"
//,tags = "@CP3040M"
,monochrome = true
,snippets = SnippetType.CAMELCASE
)
public class MainRunner {

	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}
