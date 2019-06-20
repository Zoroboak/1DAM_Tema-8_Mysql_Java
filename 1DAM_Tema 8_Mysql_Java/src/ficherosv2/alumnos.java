package ficherosv2;

public class alumnos extends fichero{
	
	private double notafinal = 0;
	
	String name = "default";
	String surname = "default";
	protected double[] notas = {1.0,1.0,1.0};
	boolean fichaComplet = false;
	
	//Constructor
	public alumnos(int i){
		this.notafinal = notaFinal();
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setNotas(double N1, double N2, double N3) {
		this.notas[0] = N1;
		this.notas[1] = N2;
		this.notas[2] = N3;
//		
//		System.out.println("Objeto Notas: ");
//		System.out.println(notas[0]);
//		System.out.println(notas[1]);
//		System.out.println(notas[2]);
	}
	
	public void setFichaComplet(boolean fichaComplet) {
		this.fichaComplet = fichaComplet;
	}
	
	public void setNotafinal() {
		this.notafinal = notaFinal();
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public double[] getNotas() {
		return notas;
	}
	
	public double getNotafinal() {
		return (this.notas[0]+this.notas[1]+this.notas[2])/3;
	}
	
	
	
	
}
