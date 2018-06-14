package bibliotecaUD5;

import java.io.IOException;

public class PedirDatos {
	
	static char leerCaracter(String frase) {
		char caracter;
		int ascii=0;
		int enter=0;
		int numcaracteres=0;
		do{
			if(numcaracteres!=0){
				System.out.println("Solo debe de introducir un caracter");
				numcaracteres=0;
			}
			System.out.println(frase);
			try{
				ascii = System.in.read();
				do{
					numcaracteres++;
					enter=System.in.read();
				}while(enter!=13);
				System.in.read();
			}catch (IOException e) {
				
			}
		}while(numcaracteres>1);
		caracter = (char)ascii;
		return caracter;
	}
	
	static String leerCadena(String frase){
		try{
			System.out.println(frase);
			String cadena="";
			int ascii=0;
			char caracter;
			do{
				ascii = System.in.read();
				caracter = (char)ascii;
				cadena=cadena+caracter;
			}while(ascii!=13);
			System.in.read();
			return cadena.trim();
		}catch (IOException e) {
			System.out.println("error de I/O");
			return "";
		}
	}
	
	static int leerEntero(String frase){
		int entero=0;
		boolean salir=false;
		do{
			try{
				entero=Integer.parseInt(leerCadena(frase));
				salir=true;
			}catch (NumberFormatException e) {
				System.out.println("Debe introducir un entero");
			}
		}while(!salir);
		return entero;
	}
	
	static double leerDecimal(String frase){
		double decimal=0;
		boolean salir = false;
		do {
			try{
				decimal=Double.parseDouble(leerCadena(frase));
				salir=true;
			}catch (NumberFormatException e) {
				System.out.println("Debe introducir un decimal");
			}
		} while (!salir);
		return decimal;
	}
}
