package choucair.pruebaIngreso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Random numAleatorio = new Random();
		int n = (numAleatorio.nextInt(31 - 1 + 1) + 1);
		System.out.println(n);
		
		Date fecha1 = new Date(101, 5,3);
		System.out.println(fecha1);
		Date fecha2 = new Date(84, 5,3);
		System.out.println(fecha2);
		Date fecha = new Faker().date().between(fecha2, fecha1);
		System.out.println(fecha);
		System.out.println(fecha.getDay());
		System.out.println(fecha.getMonth());
		System.out.println(fecha.getYear());
		
        System.out.println(fecha); 
        String strDateFormat = "dd-MM-yyyy"; // El formato de fecha está especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
        System.out.println(objSDF.format(fecha)); // El formato de fecha se aplica a la fecha actual
    }
    
}
