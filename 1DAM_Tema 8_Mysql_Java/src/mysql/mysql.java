package mysql;

import java.io.*;
import java.sql.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/***
 * Programa: 
 * 
 *  Programa de prueba que se conecta a una base de datos y ejecuta sentencias sql
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



class mysql {
	// Crear Tabla
	public static void creaTablacoches(Connection con, String BDNombre) throws SQLException {
		String create_Table_String = "CREATE TABLE IF NOT EXISTS " + BDNombre + ".COCHES" + "(MATRICULA char(8) NOT NULL,"
				+ "MARCA varchar(40) NOT NULL," + "COLOR varchar(20) NOT NULL," + "ANIO integer NOT NULL,"
				+ "PRECIO integer  NOT NULL," + "PRIMARY KEY (MATRICULA))";
		String time_zone_String = "SET GLOBAL time_zone = '+3:00';";
		String drop_table_coches_String = "DROP TABLE IF EXISTS coches;";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			//System.out.println(time_zone_String);
			//stmt.executeUpdate(time_zone_String);
			//System.out.println(drop_table_coches_String);
			stmt.executeUpdate(drop_table_coches_String);
			System.out.println(create_Table_String);
			stmt.executeUpdate(create_Table_String);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
	}

	// Cargar Tabla
	public static void CargaTablacoches(Connection con, String BDNombre, String archivo) throws SQLException {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			File fe = new File(archivo);
			FileReader fr = new FileReader(fe);
			BufferedReader br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				StringTokenizer str;
				str = new StringTokenizer(s);
				String comando = "INSERT INTO" + BDNombre + ".COCHES VALUE (" 
						+ "'" + str.nextToken() + "'," // matricula
						+ "'" + str.nextToken() + "'," // marca
						// +"'"+str.nextToken()+"'," //modelo
						+ "'" + str.nextToken() + "'," // color
						+ "" + str.nextToken() + "," // año
						+ "" + str.nextToken() + "" // precio
						+ ")";
				System.out.println(comando);
				stmt.executeUpdate(comando);
			}
			fr.close();
			
		} catch (FileNotFoundException fnf) {
			System.err.println("Fichero no encontrado " + archivo);
		} catch (IOException e) {
			System.err.println("Se ha producido una IOException");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			System.err.println("Error de programa:" + e);
			e.printStackTrace();
		} finally {
			stmt.close();
		}
	}

	// Main Principal
	public static void main(String[] args) {
		/*
		 * En caso de dar problemas con la zona horaria, ejecutar "SET GLOBAL time_zone = '+3:00';" en la base de datos
		 * 
		 * 
		 * */
		
		//Creo una conexión (objeto connection)
		Connection con;
		
		// Declaro las variables que tendran la información de la DDBB
		String host = "localhost";
		String user = "admindb";
		String pass = "carratraca";
		
		//Si le pasamos parametros, los toma como valor
		if(args.length > 0){
			
			System.out.println("Datos de Acceso:");
			System.out.println(args[0]);
			System.out.println(args[1]);
			System.out.println(args[2]);
	
			host = args[0];
			user = args[1];
			pass = args[2];
			
		}else {
			System.out.println("Datos de Acceso por defecto: ");
			System.out.println(host);
			System.out.println(user);
			System.out.println(pass);
		}
		
		try {
			System.out.println();
			System.out.println("Sentencias SQL:");
			System.out.println();
			
			con = DriverManager.getConnection("jdbc:mysql://"+host+":3306/concesionario", user, pass);
			creaTablacoches(con, " concesionario");
			CargaTablacoches(con, " concesionario", "coches.txt");
			
			System.out.println();
			System.out.println("La tabla coches ha sido creada correctamente");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.out.println("Hubo un problema: contacte con el desarrollador");
		}
	}
}