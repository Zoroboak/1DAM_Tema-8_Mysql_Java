package excepciones;

import java.util.Scanner;

/***
 * Programa: 
 * 
 *  Programa de prueba lanzando excepciones
 *  
 *  el codigo es facil de entender, asi que deduzco que no hace falta explicación
 *  
 * 
 * Autor: Pedro Daniel Pérez Sánchez
 *
 * Fecha: 30/04/2019
 *
 * Materia: Programción
 *
 * Curso: 1ºDAM
 *
 ***/ 

public class Numero_Suerte {

	// Metodo: pedirle datos al usuario
	public static String getDato(String text, int parametro) {
		/*
		 * Parametro 1: Metodo devuelve un numero dado por el usuario en el rango [0-5]
		 * 
		 * Parametro 2: Devuelve la siguiente palabra introducida por el usuario
		 * 
		 * Parametro 3: Metodo devuelve un numero dado por el usuario
		 * 
		 * Parametro 4: Devuelve varias palabras en un String
		 * 
		 * Parametro 5: Devuelve un valor numerico dado por el usuario en un string
		 * 
		 * El metodo muestra por pantalla el texto que le pasemos devuelve un string con
		 * la salida validada según el parametro pasado
		 * 
		 */

		// Variables locales del metodo
		String auxs = "-"; // Variable auxiliar que almacena un strings
		char auxc = '0'; // Variable auxiliar que almacena un caracter
		int aux = 0; // Variable auxiliar que almacena un valor entero
		boolean v = false; // Flag que marca si el valor es valido o no

		// Declaro el objeto Scanner
		Scanner t = new Scanner(System.in);

		switch (parametro) {
		case 1: // Valor a solicitar: Entero positivo del 1 al 5
			do {

				try {
					// Doy por supuesto que el valor introducido es correcto
					v = true;

					// Mostrar texto pasado por pantalla
					System.out.print(text);
					// Pido un numero entero
					aux = t.nextInt();

					// Si el rango no es correcto, repetimos el while
					if ((aux < 0) || (aux > 5)) {
						System.out.println("Debes introducir un numero en el rango [0-9]");
						v = false;
					}
				} catch (Exception e) {
					System.out.println("¡El caracter introducido no es valido!");
					t.next();
					v = false;
				}
			} while (!v);

			auxs = Integer.toString(aux);
			break;
		case 2: // Valor a solicitar: Palabra introducida por el usuario
			do {

				try {
					// Doy por supuesto que el valor introducido es correcto
					v = true;

					// Mostrar texto pasado por pantalla
					System.out.println(text);
					// Pido una Palabra entre 3 y 15 caracteres
					auxs = t.next();

					// Si el rango no es correcto, repetimos el while
					if (auxs.length() < 3 || auxs.length() > 15) {
						System.out.println("Debes introducir una palabra entre 3 y 15 caracteres");
						v = false;
					}
					// Si hay un numero, lo volvemos a pedir
					for (int i = 0; i < auxs.length(); i++) {
						if ((auxs.charAt(i) >= 48) && (auxs.charAt(i) <= 57)) {
							i = auxs.length();
							System.out.println("Debes introducir una palabra entre 3 y 15 caracteres, no numeros");
							v = false;

						}
					}

				} catch (Exception e) {
					System.out.println("¡La palabra introducida no es valida!");
					t.next();
					v = false;
				}
			} while (!v);

			break;
		case 3: // Devuelve un Caracter del 0 al * en String
			do {

				try {
					// Doy por supuesto que el valor introducido es correcto
					v = true;

					// Mostrar texto pasado por pantalla
					System.out.println(text);
					// Pido una Palabra y me quedo con la primera letra
					auxs = t.next();

					auxc = auxs.charAt(0);

					// Si el rango no es correcto, repetimos el while
					// if((auxc<49||auxc>57)||((auxc!='c')&&(auxc!='v'))) {

					if (auxc < 48 || auxc > 57) {
						System.out.println("--Debes introducir un valor numerico");
						v = false;
					}

				} catch (Exception e) {
					System.out.println("¡El numero introducido no es valido!!");
					t.next();
					v = false;
				}
			} while (!v);
			break;
		case 4: // Parametro 4: Devuelve varias palabras en un String
			do {

				try {
					// Doy por supuesto que el valor introducido es correcto
					v = true;

					// Mostrar texto pasado por pantalla
					System.out.println(text);
					// Guardo la siguiente linea completa
					auxs = t.nextLine();

					// Si el rango no es correcto, repetimos el while
					if (auxs.length() < 2) {
						System.out.println("Debes introducir un minimo de 2 caracteres para este elemento");
						v = false;
					}

				} catch (Exception e) {
					System.out.println("¡El texto introducida no es valido!");
					t.next();
					v = false;
				}
			} while (!v);

			break;

		case 5: // Parametro 5: Devuelve un valor numerico dado por el usuario en un string
			do {

				try {
					// Doy por supuesto que el valor introducido es correcto
					v = true;

					// Mostrar texto pasado por pantalla
					System.out.println(text);
					// Guardo la siguiente linea completa
					aux = t.nextInt();

					// Si el rango no es correcto, repetimos el while
					if (aux <= -1) {
						System.out.println("Debes introducir un valor positivo");
						v = false;
					}

				} catch (Exception e) {
					System.out.println("¡El valor introducido no es valido!");
					t.next();
					v = false;
				}
			} while (!v);

			auxs = Integer.toString(aux);

			break;

		}

		// Devuelvo un String
		return auxs;
	}

	public static void main(String[] args) {
		
		while(1==1) {
			
			System.out.println("-------------------------------------------");
			System.out.println("Programa que calcula tu numero de la suerte");
			System.out.println("-------------------------------------------");
			System.out.println();
	
			try {
				
				int edad = Integer.parseInt(getDato("Introduce tu edad en formato numerico: ", 3));
				
				
				if (edad == 0) throw new NumericException("¿Acabas de nacer?");
				if (edad < 0) throw new Exception("O vienes del futuro o eres demasiado pequeño para estar aqui");
				if (edad >= 90) throw new Exception("Eres muy mayor como para estar usando un ordenador, ¿No?");
				
	
				while ((edad > 9) || (edad < 0)) {
					edad /= 2;
				}
	
				System.out.println("Tu numero de la suerte es " + edad);
				System.out.println();
				System.out.println();
				
			} catch (Exception a) {
				System.out.println(a.getMessage());
				System.out.println();
				System.out.println();
				
			}
		
		}

	}

}

