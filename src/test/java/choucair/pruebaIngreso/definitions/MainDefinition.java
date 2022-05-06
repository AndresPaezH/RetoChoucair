package choucair.pruebaIngreso.definitions;

import choucair.pruebaIngreso.steps.MainSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MainDefinition {
	@Steps
	MainSteps stepsMain;

	@When("^realizar compra de productos populares \"([^\"]*)\"$")
	public void realizarCompraDeProductosPopulares(String cantidad) {
		stepsMain.realizarCompraDeProductosPopulares(cantidad);
	}
}
