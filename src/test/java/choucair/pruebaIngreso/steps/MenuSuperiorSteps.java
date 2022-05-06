package choucair.pruebaIngreso.steps;

import choucair.pruebaIngreso.pageObjects.MenuSuperiorPageObjects;

public class MenuSuperiorSteps {
	
	MenuSuperiorPageObjects pageObjectMenuSuperior;
	private String mail = "";
	private int numErrores = 0;
	public void seleccionarSubModuloContactUs() {
		pageObjectMenuSuperior.clickContactUs();
	}
	
	public void diligenciarDatosObligatorios(String subjectHeading, String emailAddress, String menssage) {
		mail = emailAddress;
		pageObjectMenuSuperior.selectSubjectHeading(subjectHeading);
		pageObjectMenuSuperior.verificoElementoSeleccionado(subjectHeading);
		pageObjectMenuSuperior.verificoMensajeInformativoCorrespondiente(subjectHeading);
		pageObjectMenuSuperior.inputEmail(emailAddress);
		pageObjectMenuSuperior.inputMessage(menssage);
		
	}
	
	public void diligenciarDatosNoObligatorios(String orderReference, String attachFile) {
		pageObjectMenuSuperior.inputOrderReference(orderReference);
		pageObjectMenuSuperior.inputAttachFile(attachFile);
	}
	
	public void verificarRegistroExitoso() {
	
		pageObjectMenuSuperior.clickSend();
		pageObjectMenuSuperior.verificoRegistroExitoso();
	}
	
	public void verificarRegistroFallido() {

		pageObjectMenuSuperior.clickSend();
		pageObjectMenuSuperior.verificoRegistroFallido(numErrores+"");
	}
	
	public void calculoCantidadDeErroresASalir(String subjectHeading, String emailAddress, String menssage) {
		int numeroErrores = 0;
		if (subjectHeading.contains("Choose")) 
			numeroErrores++;
		if (!emailAddress.contains("@")|| emailAddress.length()<1) 
			numeroErrores++;
		if (menssage.length()<1) {
			numeroErrores++;
		}
		System.out.println("Esta es la cantidad de errores que deberian aparecer: "+numeroErrores);
		numErrores = numeroErrores;
		
	}
	
	//pruebas modulo Sign in
	
	public void seleccionarModuloSingIn() {
		pageObjectMenuSuperior.clickSignIn();
	}
	
	public void ingresarCuentaARegistrar(String emailAddress) {
		pageObjectMenuSuperior.inputEmailAddress(emailAddress);
		pageObjectMenuSuperior.clickCreateAnAccount();
	}
	
	public void diligenciarFormularioRegistroUsuario(String password, String state, String postalCode) {
		pageObjectMenuSuperior.selectMrOMrs();
		pageObjectMenuSuperior.inputFirsName();
		pageObjectMenuSuperior.inputLastName();
		pageObjectMenuSuperior.inputPassword(password);
		pageObjectMenuSuperior.selectDateBirth();
		pageObjectMenuSuperior.inputCompany();
		pageObjectMenuSuperior.inputAddress();
		pageObjectMenuSuperior.inputCity();
		pageObjectMenuSuperior.selectState(state);
		pageObjectMenuSuperior.inputPostalCode(postalCode);
		pageObjectMenuSuperior.inputAditionalInformation();
		pageObjectMenuSuperior.inputContactPhone();
		pageObjectMenuSuperior.inputAliasAddress();
		pageObjectMenuSuperior.clickBtnRegister();	
		pageObjectMenuSuperior.waitFor(10).seconds();
	}
	
	public void validoRegistroExitoso() {
		pageObjectMenuSuperior.validoRegistroExitoso();
	}
	
	public void validoRegistroFallido() {
		pageObjectMenuSuperior.verificoRegistroFallido();
	}
	
	public void ingresarUsuarioYContraseña(String emailAddress, String password) {
		pageObjectMenuSuperior.inputUserlogin(emailAddress);
		pageObjectMenuSuperior.inputPasswordlogin(password);
		pageObjectMenuSuperior.clickIngresarLogin();
	}


}
