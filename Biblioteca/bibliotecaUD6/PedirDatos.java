package bibliotecaUD6;

import java.io.*;

public class PedirDatos {
	private static BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
	
	public static int leerEntero(String frase){
		int num=0;
		do{
			try {
				System.out.println(frase);
				num=Integer.parseInt(teclado.readLine());
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un numero entero");
			} catch (IOException e) {
				System.out.println("Error de I/O");
				e.getStackTrace();
				System.exit(0);
			}
		}while(true);
	}

	public static double leerDouble(String frase){
		double num=0;
		do{
			try {
				System.out.println(frase);
				num=Double.parseDouble(teclado.readLine());
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Debe introducir un numero decimal");
			} catch (IOException e) {
				System.out.println("Error de I/O");
				e.printStackTrace();
				System.exit(0);
			}
		}while(true);
	}
	
	public static String leerCadena(String frase){
		try {
			System.out.println(frase);
			return teclado.readLine();
		} catch (IOException e) {
			System.out.println("Error de I/O");
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}
	
	public static char leerCaracter(String frase){
		String ret="";
		do{
			try {
				System.out.println(frase);
				ret= teclado.readLine();
				if(ret.length()!=1){
					System.out.println("debe introducir un unico caracter");
				}else{
					return ret.charAt(0);
				}
			} catch (IOException e) {
				System.out.println("Error de I/O");
				e.printStackTrace();
				System.exit(0);
				return ' ';
			}
		}while(true);
	}
}
