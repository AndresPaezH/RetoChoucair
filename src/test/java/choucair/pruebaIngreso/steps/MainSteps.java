package choucair.pruebaIngreso.steps;

import choucair.pruebaIngreso.pageObjects.MainPageObject;

public class MainSteps {
	
	MainPageObject pageObjeMainPageObject;
	
	public void ingresoAlNavegador() {
		pageObjeMainPageObject.open();
		pageObjeMainPageObject.getDriver().manage().window().maximize();
		pageObjeMainPageObject.waitFor(1).seconds();
	}
	
	public void realizarCompraDeProductosPopulares(String cantidad) {
		pageObjeMainPageObject.clickBtnHome();
		for (int i = 0; i < Integer.parseInt(cantidad); i++) {
			pageObjeMainPageObject.seleccionarArticulos();
			pageObjeMainPageObject.verificoProductoSeleccionado();
			pageObjeMainPageObject.inputCantidadDelProducto();
			pageObjeMainPageObject.capturarYcalcularPrecioTotal();
			pageObjeMainPageObject.selectTalla();
			pageObjeMainPageObject.clickAddToCart();
			pageObjeMainPageObject.verificarSuccessfully();
			if (i == (Integer.parseInt(cantidad)-1)) 
				pageObjeMainPageObject.clickCheckout();
			else {
				pageObjeMainPageObject.clicContinueShopping();
				pageObjeMainPageObject.clickBtnHome();
			}
		}
			
		
		
	}


}
