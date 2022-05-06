package choucair.pruebaIngreso.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import net.serenitybdd.core.pages.PageObject;

public class Utilidades extends PageObject {

	public void esperaExplicitaToBeClickable(String localizador) {
		WebDriverWait myWait = new WebDriverWait(getDriver(), 30);
		myWait.until(ExpectedConditions.elementToBeClickable(By.xpath(localizador)));
	
	}
	
	public void esperaExplicitaToBeVisible(String localizador) {
		WebDriverWait myWait = new WebDriverWait(getDriver(), 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(localizador)));
	}
	
	public static String generarNumeroAleatorioEntre1y0() {
		Random numAleatorio = new Random();
		int n = (numAleatorio.nextInt(2 - 1 + 1) + 1);
		System.out.println(n);
		return String.valueOf(n);
	}
	
	public static String generarFechaAleatoria() {
		Date fecha1 = new Date(101, 5,3);
		Date fecha2 = new Date(84, 5,3);
		Date fecha = new Faker().date().between(fecha2, fecha1);		
        System.out.println(fecha); 
        String strDateFormat = "dd-MM-yyyy";  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        System.out.println(objSDF.format(fecha));
        return String.valueOf(objSDF.format(fecha));
	}
	
	public static String generarNumeroAleatorioEntre(int limiteInfe, int limiteSup) {
		Random numAleatorio = new Random();
		int n = (numAleatorio.nextInt(limiteSup - limiteInfe + 1) + 1);
		System.out.println(n);
		return String.valueOf(n);
	}
}
