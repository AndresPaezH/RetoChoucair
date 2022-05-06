package choucair.pruebaIngreso.pageObjects;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import choucair.pruebaIngreso.utilidades.Utilidades;
import net.serenitybdd.core.pages.PageObject;

public class MenuSuperiorPageObjects extends PageObject {
	
	//xpath menu superior
	private String btnContactUs = "//div[@id='contact-link']//a[contains(text(),'Contact us')]";
	private String btnSignIn = "//a[contains(text(),'Sign in')]";
	
	//xpath modulo Contact us
	
	private String selectSubjectHeading = "//select[@id='id_contact']";
	private String textSelectedHEading = "//span[contains(text(),'#')]";
	private String labelInformativo = "//select[@id='id_contact']/following::p[*]";
	private String inputEmail = "//input[@id='email']";
	private String inputOrden = "//input[@id='id_order']";
	private String inputChooseFile = "//input[@id='fileUpload']";
	private String inputMessage = "//textarea[@id='message']";
	private String btnSent = "//button[@id='submitMessage']";
	private String labelRegistroOk = "//p[@class='alert alert-success']";
	private String labelRegistroFail = "//div[@class='alert alert-danger']";
	private String labelNumErrores = "//div[@class='alert alert-danger']/p";
	
	//Xpath sign in
	
	private String inputEmailCreate = "//input[@id='email_create']";
	private String btnCreateAnAccount = "//button[@id='SubmitCreate']";
	private String btnMroMrs = "//input[@id='id_gender#']";
	private String inputFirstName = "//input[@id='customer_firstname']";
	private String inputLastName = "//input[@id='customer_lastname']";
	private String inputPassword = "//input[@id='passwd']";
	private String selectDays = "//select[@id='days']";
	private String selectMonths = "//select[@id='months']";
	private String selectYears = "//select[@id='years']";
	private String inputFirstName2 = "//input[@id='firstname']";
	private String inputLastName2 = "//input[@id='lastname']";
	private String inputCompany = "//input[@id='company']";
	private String inputAddress1 = "//input[@id='address1']";
	private String inputAddress2 = "//input[@id='address2']";
	private String inputCity = "//input[@id='city']";
	private String selectState	= "//select[@id='id_state']";
	private String inputPostalCode = "//input[@id='postcode']"; 
	private String inputAdditionalInfo = "//textArea[@id='other']";
	private String inputHomePhone = "//input[@id='phone']";
	private String inputMobilPhone = "//input[@id='phone_mobile']";
	private String inputAlias = "//input[@id='alias']";
	private String btnRegister = "//button[@id='submitAccount']";
	private String labelRegistroExitoso ="//p[@class='info-account']";
	
	private String labelCantidadErrores = "//div[@class='alert alert-danger']";
	private String labelErrores = "//div[@class='alert alert-danger']/ol/li";
	
	private String inputEmailLogin = "//input[@id='email']";
	private String inputPasswordLogin = "//input[@id='passwd']";
	private String btnSignInLogin = "//button[@id='SubmitLogin']";
	
	Utilidades utilidades;
	
	public void clickContactUs() {
		utilidades.esperaExplicitaToBeClickable(btnContactUs);
		element(By.xpath(btnContactUs)).click();
	}
	
	public void selectSubjectHeading(String subjectHeading) {
		Select selectSubjectHeading = new Select(getDriver().findElement(By.xpath(this.selectSubjectHeading)));
		selectSubjectHeading.selectByVisibleText(subjectHeading);
	}
	
	public void verificoElementoSeleccionado(String subjectHeading) {
		textSelectedHEading = this.textSelectedHEading.replace("#", subjectHeading);
		waitFor(1).second();
		assertTrue(element(By.xpath(textSelectedHEading)).isVisible());
	}
	
	public void verificoMensajeInformativoCorrespondiente(String subjectHeading){
		String texto = "";
		try {
			for (int i = 1; i < 4; i++) {
				if (element(By.xpath(labelInformativo.replace("*", i+""))).isVisible()) {
					texto = element(By.xpath(labelInformativo.replace("*", i+""))).getText();
					System.out.println(texto);
				}			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		assertEquals(textoEsperadoSegunSeleccion(subjectHeading), texto);
	}
	
	public String textoEsperadoSegunSeleccion(String seleccion) {
		if (seleccion.contains("Customer service")) 
			return "For any question about a product, an order";
		else if (seleccion.contains("Webmaster")) 
			return "If a technical problem occurs on this website";
		else
			return "";
	}
	
	public void inputEmail(String emailAddress) {
		utilidades.esperaExplicitaToBeClickable(inputEmail);
		element(By.xpath(inputEmail)).sendKeys(emailAddress);
	}
	
	public void inputMessage(String message) {
		utilidades.esperaExplicitaToBeClickable(inputMessage);
		element(By.xpath(inputMessage)).sendKeys(message);
	}
	
	public void inputOrderReference(String orderReference) {
		utilidades.esperaExplicitaToBeClickable(inputOrden);
		element(By.xpath(inputOrden)).sendKeys(orderReference);
	}

	public void inputAttachFile(String attachFile) {
		waitFor(1).second();
		element(By.xpath(inputChooseFile)).sendKeys(attachFile);
	}
	
	public void clickSend() {
		utilidades.esperaExplicitaToBeClickable(btnSent);
		element(By.xpath(btnSent)).click();
	}
	
	public void verificoRegistroExitoso() {
		utilidades.esperaExplicitaToBeVisible(labelRegistroOk);
		assertTrue(element(By.xpath(labelRegistroOk)).isVisible());
		waitFor(2).seconds();
	}

	public void verificoRegistroFallido(String numErrores) {
		utilidades.esperaExplicitaToBeVisible(labelRegistroFail);
		assertTrue(element(By.xpath(labelRegistroFail)).isVisible());
		waitFor(2).seconds();
		assertTrue(element(By.xpath(labelNumErrores)).getText().contains(numErrores));
	}
	
	public void clickSignIn() {
		utilidades.esperaExplicitaToBeClickable(btnSignIn);
		element(By.xpath(btnSignIn)).click();
	}
	
	public void inputEmailAddress(String emailAddress) {
		utilidades.esperaExplicitaToBeVisible(inputEmailCreate);
		element(By.xpath(inputEmailCreate)).sendKeys(emailAddress);
	}
	
	public void clickCreateAnAccount() {
		utilidades.esperaExplicitaToBeClickable(btnCreateAnAccount);
		element(By.xpath(btnCreateAnAccount)).click();
	}
	
	public void selectMrOMrs() {
		String btnMroMrs = this.btnMroMrs.replace("#", Utilidades.generarNumeroAleatorioEntre1y0());
		utilidades.esperaExplicitaToBeClickable(btnMroMrs);
		element(By.xpath(btnMroMrs)).click();
	}
	
	public void inputFirsName() {
		String firstName = new Faker().name().firstName();
		waitFor(1).second();
		element(By.xpath(inputFirstName)).sendKeys(firstName);

	}

	public void inputLastName() {
		String lastName = new Faker().name().lastName();
		waitFor(1).second();
		element(By.xpath(inputLastName)).sendKeys(lastName);
	}
	
	public void inputPassword(String password) {
		waitFor(1).second();
		element(By.xpath(inputPassword)).sendKeys(password);
	}
	
	public void selectDateBirth() {
		waitFor(1).second();
		String[] fecha = Utilidades.generarFechaAleatoria().split("-");
		System.out.println(fecha[0]);
		if (Integer.parseInt(fecha[0]) < 10) 
			fecha[0] = fecha[0].replace("0", "");
		if (Integer.parseInt(fecha[1]) < 10) 
			fecha[1] = fecha[1].replace("0", "");
		
		Select selectDays = new Select(getDriver().findElement(By.xpath(this.selectDays)));
		selectDays.selectByValue(fecha[0]);
		waitFor(1).second();
		Select selectMonth = new Select(getDriver().findElement(By.xpath(this.selectMonths)));
		selectMonth.selectByValue(fecha[1]);
		waitFor(1).second();
		Select selectYears = new Select(getDriver().findElement(By.xpath(this.selectYears)));
		selectYears.selectByValue(fecha[2]);
		
	}
	
	public void inputCompany() {
		waitFor(1).second();
		String company = new Faker().company().name();
		element(By.xpath(inputCompany)).sendKeys(company);
	}
	
	public void inputAddress() {
		waitFor(1).second();
		String addres = new Faker().address().streetAddress();
		element(By.xpath(inputAddress1)).sendKeys(addres);
		String addres2 = new Faker().address().firstName();
		element(By.xpath(inputAddress2)).sendKeys(addres2);
	}
	
	public void inputCity() {
		waitFor(1).second();
		String city = new Faker().address().city();
		element(By.xpath(inputCity)).sendKeys(city);
	}
	
	public void selectState(String state) {
		waitFor(1).second();
		Select selectState = new Select(getDriver().findElement(By.xpath(this.selectState)));
		selectState.selectByVisibleText(state);
	}
	
	public void inputPostalCode(String postalCode) {
		waitFor(1).second();
		element(By.xpath(inputPostalCode)).sendKeys(postalCode);
	}
	
	public void inputAditionalInformation() {
		waitFor(1).second();
		String info = new Faker().commerce().productName();
		element(By.xpath(inputAdditionalInfo)).sendKeys(info);
	}
	
	public void inputContactPhone() {
		waitFor(1).second();
		int number = new Faker().number().numberBetween(300000, 700000);
		element(By.xpath(inputHomePhone)).sendKeys(String.valueOf(number));
		waitFor(1).second();
		int cellPhone = new Faker().number().numberBetween(300000000, 399999999);
		element(By.xpath(inputMobilPhone)).sendKeys(cellPhone+"");
	}
	
	public void inputAliasAddress() {
		String firstName = element(By.xpath(inputFirstName)).getValue();
		waitFor(1).second();
		element(By.xpath(inputAlias)).clear();
		String name = new Faker().dragonBall().character();
		element(By.xpath(inputAlias)).sendKeys(firstName.concat(" "+name));
	}
	
	public void clickBtnRegister() {
		utilidades.esperaExplicitaToBeClickable(btnRegister);
		element(By.xpath(btnRegister)).click();
	}
	
	public void validoRegistroExitoso() {
		utilidades.esperaExplicitaToBeVisible(labelRegistroExitoso);
		String actual = element(By.xpath(labelRegistroExitoso)).getText();
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", actual);
	}
	
	public void verificoRegistroFallido() {
		utilidades.esperaExplicitaToBeVisible(labelCantidadErrores);
		String textErrores = element(By.xpath(labelCantidadErrores)).getText();
		int numErrores = getDriver().findElements(By.xpath(labelErrores)).size();
		boolean verificador = false;
		if (textErrores.contains(String.valueOf(numErrores))) 
			verificador = true;
		assertTrue(verificador);
	}
	
	public void inputUserlogin(String emailAddress) {
		
		utilidades.esperaExplicitaToBeVisible(inputEmailLogin);
		element(By.xpath(inputEmailLogin)).sendKeys(emailAddress);
	}
	
	public void inputPasswordlogin(String password) {
		waitFor(1).second();
		element(By.xpath(inputPasswordLogin)).sendKeys(password);
	}
	
	public void clickIngresarLogin() {
		utilidades.esperaExplicitaToBeClickable(btnSignInLogin);
		element(By.xpath(btnSignInLogin)).click();
	}
}
