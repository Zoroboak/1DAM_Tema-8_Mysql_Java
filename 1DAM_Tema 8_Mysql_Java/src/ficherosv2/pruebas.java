package ficherosv2;

public class pruebas {

	
	public static void main(String[] args) {
		
		
		alumnos[] elias = new alumnos[2];
		elias[0] = new alumnos(0);
		elias[1] = new alumnos(0);
		
		String ruta = "C:\\Users\\pedro\\Desktop\\cursoDAM.csv";
		
		
		try {
			fichero.salvarComoCsv(ruta, elias);
			System.out.println("Archivo guardado en "+ruta);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error"+e.getMessage());
		}
				
	}
}
