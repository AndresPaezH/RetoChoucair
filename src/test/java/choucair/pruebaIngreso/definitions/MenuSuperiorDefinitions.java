package choucair.pruebaIngreso.definitions;

import choucair.pruebaIngreso.steps.MainSteps;
import choucair.pruebaIngreso.steps.MenuSuperiorSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MenuSuperiorDefinitions {

	@Steps
	MainSteps stepsMain;
	@Steps
	MenuSuperiorSteps stepsMenuSuperior;

	@Given("^Ingresar a la pagina web$")
	public void ingresarALaPaginaWeb() {
		stepsMain.ingresoAlNavegador();
	}

	@When("^seleccionar contact us$")
	public void seleccionarContactUs() {
		stepsMenuSuperior.seleccionarSubModuloContactUs();
	}

	@When("^realizar registro completo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizarRegistroCompleto(String subjectHeading, String emailAddress, String orderReference,
			String attachFile, String menssage) {
		stepsMenuSuperior.diligenciarDatosObligatorios(subjectHeading, emailAddress, menssage);
		stepsMenuSuperior.diligenciarDatosNoObligatorios(orderReference, attachFile);
	}

	@Then("^verificar registro exitoso$")
	public void verificarRegistroExitoso() {
		stepsMenuSuperior.verificarRegistroExitoso();
	}

	@When("^realizar registro incompleto \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizarRegistroIncompleto(String subjectHeading, String emailAddress, String menssage) {
		stepsMenuSuperior.diligenciarDatosObligatorios(subjectHeading, emailAddress, menssage);
	}

	@When("^realizar registro completo por mal \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizarRegistroCompletoPorMal(String subjectHeading, String emailAddress, String orderReference,
			String attachFile, String menssage) {
		stepsMenuSuperior.diligenciarDatosObligatorios(subjectHeading, emailAddress, menssage);
		stepsMenuSuperior.calculoCantidadDeErroresASalir(subjectHeading, emailAddress, menssage);
		stepsMenuSuperior.diligenciarDatosNoObligatorios(orderReference, attachFile);
	}

	@When("^realizar registro incompleto por mal \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizarRegistroIncompletoPorMal(String subjectHeading, String emailAddress, String menssage) {
		stepsMenuSuperior.diligenciarDatosObligatorios(subjectHeading, emailAddress, menssage);
		stepsMenuSuperior.calculoCantidadDeErroresASalir(subjectHeading, emailAddress, menssage);
	}

	@Then("^verificar registro fallido$")
	public void verificarRegistroFallido() {
		stepsMenuSuperior.verificarRegistroFallido();
	}

	// pruebas modulo Sing in

	@When("^seleccionar sign in$")
	public void seleccionarSignIn() {
		stepsMenuSuperior.seleccionarModuloSingIn();
	}

	@When("^diligenciar registro de usuario \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void diligenciarRegistroDeUsuario(String emailAddress, String password, String state, String postalCode) {
		stepsMenuSuperior.ingresarCuentaARegistrar(emailAddress);
		stepsMenuSuperior.diligenciarFormularioRegistroUsuario(password, state, postalCode);
	}

	@Then("^verificar registro de usuario exitoso$")
	public void verificarRegistroDeUsuarioExitoso() {
		stepsMenuSuperior.validoRegistroExitoso();
	}

	@Then("^verificar registro de usuario fallido$")
	public void verificarRegistroDeUsuarioFallido() {
		stepsMenuSuperior.validoRegistroFallido();
	}

	@When("^escribir usuario y contraseña \"([^\"]*)\" \"([^\"]*)\"$")
	public void escribirUsuarioYContraseña(String emailAddress, String password) {
		stepsMenuSuperior.ingresarUsuarioYContraseña(emailAddress, password);
	}

	@Then("^verificar ingreso exitoso$")
	public void verificarIngresoExitoso() {
		stepsMenuSuperior.validoRegistroExitoso();
	}

	@Then("^verificar ingreso fallido$")
	public void verificarIngresoFallido() {
		stepsMenuSuperior.validoRegistroFallido();
	}

}
