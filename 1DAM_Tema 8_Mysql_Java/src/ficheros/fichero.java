import java.io.*;
import java.text.DecimalFormat;
import java.lang.*;




/**************************             COLOCAR FICHERO EN DOCUMENTOS (COPIA) PARA + AGILIDAD      ****************************/



//MIRAR EXCEPCIONES HORMILLEJA     Y   Comprobar si fichero existe de prueba de HORMILLEJA (libro)

			
/*nota VIP: Si no podemos usar la interfaz, mostrar con menú de consola*/

/*MAIN subjetivo*/

public abstract class fichero {
	
	public static alumnos[] fichas = new alumnos[100];
	
	/*Atributos*/
	protected String name;
	protected String surname;
	protected double[] notas = new double[3];
	
	
	
	
	public double notaFinal(){
		return (this.notas[0]+this.notas[1]+this.notas[2])/3;
	}
	
	
	/* Recibe ruta
	 * Devuelve array de alumnos cargado*/
	
	
	public static alumnos[] cargarFichero(String path) { /*path =ruta*/
		//alumnos[] fichas = null ;
		String lectura;
		int i=0 /*nº alumno*/ 
		, aux=0,j;
		// RECUPERAR EL ARCHIVO PROPORCIONADO COMO cursoDAM.save compuesto por:
		/*	String
		/*	String
		/*	double
		/*	double
		/*	double */
		int n_linea=0;
		String nota1="aa", nota2="aaaw", nota3="aaas";
		
		
		
		for (i=0; i < 100; i++) {      		//MAX 100 fichas
			 fichas[i] = new alumnos(0);
			}
		
			try {
				/*	
				int tipo;
				int largo_path=path.length();
				char tipo_fich=path.charAt(largo_path);
				
				
				tipo_fich=Character.toLowerCase(tipo_fich);
				
				//extension
				if(tipo_fich=='e') {	//.save
					
					tipo=1;
				}else {		//.csv
					
					tipo=2;
				}
				
				*/
				
			//	if(tipo==1) {	
					
					
					i=0;
					
					BufferedReader entrada = new BufferedReader (new FileReader (path));
					
					lectura=entrada.readLine();  //0

					/* Cada alumno tiene 5 lineas 0-4 5-9 10-14 
					 * 24 lineas => (n_linea + 1) / 5 => nº alumnos en fichero  (i) */
	
						
						// Cargamos ficha 0
						fichas[i].name=lectura;	
						n_linea++;
						
						lectura=entrada.readLine(); //1 n lineas leidas
						fichas[i].surname=lectura;
						n_linea++;
						
						//Notas: cast string a doble
						
						lectura=entrada.readLine();//2 
						Double d = Double.valueOf(lectura);
						fichas[i].notas[0]=d;   //Nota 1
						
						lectura=entrada.readLine();//3
						d = Double.valueOf(lectura);
						fichas[i].notas[1]=d;
						
						
						lectura=entrada.readLine();//4
						d = Double.valueOf(lectura);
						fichas[i].notas[2]=d;
						
						
						n_linea = 4;
						
						if(n_linea%4==0) i++; 
						

						
						
						while(lectura!=null) { //Lee linea por linea
							
							n_linea++;
														
							
							lectura = entrada.readLine();
							
							if((i*n_linea)%5==0) { //nombre
								
								fichas[i].name=lectura;	
								
							}else if((i*n_linea)%6==0) { //apellidos
								
								fichas[i].surname=lectura;
								
							}else if((i*n_linea)%7==0)	{ //n1
								
								d = Double.valueOf(lectura);
								fichas[i].notas[0]=d;
								
							}else if((i*n_linea)%8==0) { //n2
								
								d = Double.valueOf(lectura);
								fichas[i].notas[1]=d;
								
							}else { //n3
								
								d = Double.valueOf(lectura);
								fichas[i].notas[2]=d;
								
							}//if else		
							
						} //while
						
					
						entrada.close();
					
			/*	}else { 
					i=0;
					
					BufferedReader entrada = new BufferedReader (new FileReader (path));
					
			
						
						
						lectura=entrada.readLine();
					    char[] caracteres = lectura.toCharArray();  Creamos array de caracteres del string lectura (COMENTARIO)

					    int cont=0,aux3=0;
					    char c;
					    
					    for (int h = 0; h < caracteres.length; h++) { 
					    							    		
					    		if(caracteres[h]!=';') {
					    			
					    			cont++;
					    		}else {
					    			
					    			if(cont==0) { 
					    				fichas[0].name="*"+caracteres[h];
					    				
					    			}else if(cont==1) { 
					    				fichas[0].surname="*"+caracteres[h];
					    			}else if(cont==2) { 
					    				nota1="*"+caracteres[h];
					    			}else if(cont==3) {	
					    				nota2="*"+caracteres[h];
					    			}else {	
					    				nota3="*"+caracteres[h];
					    			}
					    			
					    		}
					    		
					    }													
					    		
					    		String aux10 = fichas[0].name;
					    		fichas[0].name=aux10.replace("*", "");
					    		aux10= fichas[0].surname;	
					    		fichas[0].surname=aux10.replace("*", "");	
			
					    		aux10=nota1;
					    		nota1=aux10.replace("*", "");
					    		
					    		aux10=nota2;
					    		nota2=aux10.replace("*", "");
					    		
					    		aux10=nota3;
					    		nota3=aux10.replace("*", "");
					    				
					    		
					
					    		Double d = Double.valueOf(nota1);
					    		fichas[0].notas[0]=d;
					    		
					    		d = Double.valueOf(nota2);
					    		fichas[0].notas[1]=d;
					    		
					    		d = Double.valueOf(nota3);
					    		fichas[0].notas[2]=d;
					    		
					    		
					    		FIN LECTURA LINEA 1 (COMENTARIO)

					    		n_linea=1;
					    		lectura=entrada.readLine();
					    		
					    		while(lectura!=null) {
					    			
					    			 for (int h = 0; h < caracteres.length; h++) { 
 							    		
								    		if(caracteres[h]!=';') {
								    			
								    			cont++;
								    		}else {
								    			
								    			if(cont==0) { 
								    				fichas[n_linea].name="*"+caracteres[h];								    				
								    			}else if(cont==1) { 
								    				fichas[n_linea].surname="*"+caracteres[h];
								    			}else if(cont==2) { //n1
								    				nota1="*"+caracteres[h];
								    			}else if(cont==3) {
								    				nota2="*"+caracteres[h];
								    			}else {	
								    				nota3="*"+caracteres[h];
								    			}
								    			
								    		}
								    		
								    }
					    			 
					    			 	aux10 = fichas[n_linea].name;
							    		fichas[n_linea].name=aux10.replace("*", "");
							    		aux10= fichas[n_linea].surname;	
							    		fichas[n_linea].surname=aux10.replace("*", "");						
							    		aux10=nota1;
							    		nota1=aux10.replace("*", "");							    		
							    		aux10=nota2;
							    		nota2=aux10.replace("*", "");							    		
							    		aux10=nota3;
							    		nota3=aux10.replace("*", "");
							    		
							    		CONVERTIR A DOBLE (COMENTARIO)
							    		d = Double.valueOf(nota1);
							    		fichas[0].notas[0]=d;
							    		d = Double.valueOf(nota2);
							    		fichas[0].notas[1]=d;
							     		d = Double.valueOf(nota3);
							    		fichas[0].notas[2]=d;    			 
							    		
							    		n_linea++;
							    		lectura=entrada.readLine();
					    		}
 	
						entrada.close();
				} */    //Fin else
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
	
		
		
		
		
		return fichas;
	}
	
	public static void salvarFichero(String path, alumnos[] fichas){
		
		/* SALVA EL FICHERO CON LA EXTENSIÃ“N .save Y LOS DATOS SERÃ�N:
		/*	String
		/*	String
		/*	double
		/*	double
		/*	double */
		
		int largo_path, tipo /*1 save 2 csv*/;
		boolean stop=false;
		
			//File archivo = new File (path);
			
			try {
				PrintWriter salida = new PrintWriter (new FileWriter(path));   //Path: direccion con nombre archivo : cursoDAM.save
				String []contenido = new String [5];
				/*****************************************************************************************/
				
				largo_path=path.length();
				char tipo_fich=path.charAt(largo_path);
				
				tipo_fich=Character.toLowerCase(tipo_fich);
				
				/*EXTENSION */
				if(tipo_fich=='e') {	//.save
					path="cursoDAM.save";
					tipo=1;
				}else {		//.csv
					path="cursoDAM.csv";
					tipo=2;
				}
				
				//alumnos[] fichas
				
				/*GUARDADO SEGUN EXTENSION*/
				if(tipo==1) { //SAVE
					int j,k;
					for( j=0; j<100 ; j++) {
						
						if(fichas[j].name.equals("Default")) { //Paramos
							stop=true;
						}
						if(stop==true) {
							break;
						}
						
						contenido[0]=fichas[j].name;
						contenido[1]=fichas[j].surname;
						contenido[2]=Double.toString(fichas[j].notas[0]); //Cast a string
						contenido[3]=Double.toString(fichas[j].notas[1]);
						contenido[4]=Double.toString(fichas[j].notas[2]);
						
						for(k=0;k<5;k++) {
							salida.print(contenido[k]); //println
							salida.println();
						}
					}

				}else {	//CSV
					stop=false;
					
					int j,k;
					for( j=0; j<100 ; j++) {
						
						if(fichas[j].name.equals("Default")) { //Paramos
							stop=true;
						}
						if(stop==true) {
							break;
						}
						
						contenido[0]=fichas[j].name+";";
						
						contenido[1]=fichas[j].surname+";";
						
						contenido[2]=Double.toString(fichas[j].notas[0]); //Cast a string
						contenido[2]=contenido[2]+";";
						
						contenido[3]=Double.toString(fichas[j].notas[1]);
						contenido[3]=contenido[3]+";";
						
						contenido[4]=Double.toString(fichas[j].notas[2]);
						contenido[4]=contenido[4]+";";
						
						for(k=0;k<5;k++) {
							salida.print(contenido[k]); //println
							
						}
						salida.println();
					}
					
					
					
					
				}
				
				
				
				/*****************************************************************************************/
				
				
				
				salida.close();
				
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		
		
	}
	
	public static void salvarComoCsv(String path, alumnos[] fichas){  
		DecimalFormat formato = new DecimalFormat("#.00");
		
		
		int largo_path, tipo;
		boolean stop=false;
		
			//File archivo = new File (path);
			
			try {
				PrintWriter salida = new PrintWriter (new FileWriter(path));   //Path: direccion con nombre archivo : cursoDAM.save
				String []contenido = new String [5];
				/*****************************************************************************************/
				
				largo_path=path.length();
				char tipo_fich=path.charAt(largo_path);
				
				tipo_fich=Character.toLowerCase(tipo_fich);
				
		
					stop=false;
					
					int j,k;
					for( j=0; j<100 ; j++) {
						
						if(fichas[j].name.equals("Default")) { //Paramos
							stop=true;
						}
						if(stop==true) {
							break;
						}
						
						contenido[0]=fichas[j].name+";";
						
						contenido[1]=fichas[j].surname+";";
						
						contenido[2]=Double.toString(fichas[j].notas[0]); //Cast a string
						contenido[2]=contenido[2]+";";
						
						contenido[3]=Double.toString(fichas[j].notas[1]);
						contenido[3]=contenido[3]+";";
						
						contenido[4]=Double.toString(fichas[j].notas[2]);
						contenido[4]=contenido[4]+";";
						
						for(k=0;k<5;k++) {
							salida.print(contenido[k]); //println
						}
						salida.println();
					}//for
					
					salida.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		
		

	} //FIN METODO

	
	/*GETTERS Y SETTERS*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas[0] = notas[0];
		this.notas[1] = notas[1];
		this.notas[2] = notas[2];
	}

	
	
}
