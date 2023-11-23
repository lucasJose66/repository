package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
public class util {
	
	 static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");

     public static String doubleToString(Double valor) {
         return formatandoValores.format(valor);
		}
		
	}


