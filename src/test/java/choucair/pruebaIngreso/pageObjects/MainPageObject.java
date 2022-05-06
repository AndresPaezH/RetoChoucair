package choucair.pruebaIngreso.pageObjects;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.jruby.ir.operands.Array;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import choucair.pruebaIngreso.utilidades.Utilidades;
import choucair.pruebaIngreso.utilidades.models.ModelDescripcionProductos;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://automationpractice.com/index.php")
public class MainPageObject extends PageObject {

	private String btnHome = "//a[@title='My Store']";
	private String imgArticulos = "(//img[@class='replace-2x img-responsive'])[#]";
	private String cantidadArticulos = "(//img[@class='replace-2x img-responsive'])";
	private String labelNameProductoSeleccionado = "(//a[@class='product-name'])[#]";
	private String labelRedireccProductoSelect = "//div[@class='primary_block row']//h1";
	private String inputQuality = "//input[@id='quantity_wanted']";
	private String labelPrecioUnitario = "//span[@id='our_price_display']";
	private String selectTalla = "//select[@id='group_1']";
	private String optionsTalla = "//select[@id=\"group_1\"]/option";
	private String btnAddToCar = "//p[@id='add_to_cart']/button";
	private String labelSuccessfully = "(//div[@id='layer_cart']//h2)[1]";
	private String btnContinueShopping = "//span[@title='Continue shopping']";
	private String btnProceedToCheckout = "//a[@title='Proceed to checkout']";
	private String cantidadTipoProducto = "";
	private ArrayList<ModelDescripcionProductos> listaProductoComprado = new ArrayList<ModelDescripcionProductos>();
	private ModelDescripcionProductos objectDescripcionProductos;
	Utilidades utilidades;

	public void clickBtnHome() {
		utilidades.esperaExplicitaToBeClickable(btnHome);
		element(By.xpath(btnHome)).click();
	}

	public String seleccionarArticulos() {
		objectDescripcionProductos = new ModelDescripcionProductos();
		int numeroArticulos = getDriver().findElements(By.xpath(cantidadArticulos)).size() / 2;
		System.out.println("numero de articulos: " + numeroArticulos);
		String numeroAleatorio = Utilidades.generarNumeroAleatorioEntre(1, numeroArticulos);
		System.out.println("numero aleatorio " + numeroAleatorio);
		utilidades.esperaExplicitaToBeClickable(imgArticulos.replace("#", numeroAleatorio));
		String productoSeleccionado = labelNameProductoSeleccionado.replace("#", numeroAleatorio);
		element(By.xpath(imgArticulos.replace("#", numeroAleatorio))).click();
		objectDescripcionProductos.setNombreProducto(productoSeleccionado.trim());

		return productoSeleccionado;
	}

	public void verificoProductoSeleccionado() {
//		utilidades.esperaExplicitaToBeVisible(labelRedireccProductoSelect);
//		assertEquals(objectDescripcionProductos.getNombreProducto(), element(By.xpath(labelRedireccProductoSelect)).getText().trim());
	}

	public void inputCantidadDelProducto() {
//		waitFor(5).seconds()
	
		String cantidadTipoProducto = Utilidades.generarNumeroAleatorioEntre(1, 3);
		element(By.xpath(inputQuality)).sendKeys(cantidadTipoProducto);
		objectDescripcionProductos.setCantidadProductos(Integer.parseInt(cantidadTipoProducto));
//		id="fancybox-frame1607143620209"
	}

	public void capturarYcalcularPrecioTotal() {
		String precio = element(By.xpath(labelPrecioUnitario)).getText().replace("$", "").trim();
		System.out.println("El precio unitario es: " + precio);
		objectDescripcionProductos.setPrecioUnitario(Double.parseDouble(precio));
		objectDescripcionProductos.setPrecioTotal(
				objectDescripcionProductos.getCantidadProductos() * objectDescripcionProductos.getPrecioUnitario());

	}
	
	public void selectTalla() {
		int cantidadTallas = getDriver().findElements(By.xpath(optionsTalla)).size();
		String valueTallas = Utilidades.generarNumeroAleatorioEntre(1, cantidadTallas);
		Select selectState = new Select(getDriver().findElement(By.xpath(this.selectTalla)));
		selectState.selectByValue(valueTallas);
		objectDescripcionProductos.setTalla(selectState.getFirstSelectedOption().getText());
		listaProductoComprado.add(objectDescripcionProductos);
		objectDescripcionProductos = null;
	}
	
	public void clickAddToCart() {
		utilidades.esperaExplicitaToBeClickable(btnAddToCar);
		element(By.xpath(btnAddToCar)).click();
	}
	
	public void verificarSuccessfully() {
		utilidades.esperaExplicitaToBeVisible(this.labelSuccessfully);
		String labelSuccessfully = element(By.xpath(this.labelSuccessfully)).getText();
		assertEquals("Product successfully added to your shopping cart", labelSuccessfully.trim());
	}
	
	public void clicContinueShopping() {
		utilidades.esperaExplicitaToBeClickable(btnProceedToCheckout);
		element(By.xpath(btnProceedToCheckout)).click();
	}
	
	public void clickCheckout() {
		utilidades.esperaExplicitaToBeClickable(btnContinueShopping);
		element(By.xpath(btnContinueShopping)).click();
	}
}
//p[@id='add_to_cart']/button