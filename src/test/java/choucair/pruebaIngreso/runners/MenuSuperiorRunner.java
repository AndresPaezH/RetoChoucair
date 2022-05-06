package choucair.pruebaIngreso.runners;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import choucair.pruebaIngreso.utilidades.BeforeSuite;
import choucair.pruebaIngreso.utilidades.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;





@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
features = "src/test/resources/features/MenuSuperior.feature"
,glue = "choucair.pruebaIngreso.definitions"
,tags = "@CP2070M"
,snippets = SnippetType.CAMELCASE
)
public class MenuSuperiorRunner {

	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}