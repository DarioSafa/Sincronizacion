package paquete;

import java.util.Date;

public class Empleados {
	
	private final int TAM_NOMBRE = 30;
	private final int TAM_PUESTO = 30;
	int numemp;
	String nombre;
	int edad;
	int oficina;
	String puesto;
	Date contrato;
	
	public Empleados(int numemp, String nombre, int edad, int oficina, String puesto, Date contrato) {
		this.numemp = numemp;
		this.nombre = nombre;
		this.edad = edad;
		this.oficina = oficina;
		this.puesto = puesto;
		this.contrato = contrato;
	}
	
	public Empleados(int numemp) {
		this.numemp= numemp;
	}
	
	public int getNumemp() {
		return numemp;
	}
	public void setNumemp(int numemp) {
		this.numemp = numemp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.substring(0,Math.min(nombre.length(), TAM_NOMBRE));
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getOficina() {
		return oficina;
	}
	public void setOficina(int oficina) {
		this.oficina = oficina;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto.substring(0,Math.min(puesto.length(), TAM_PUESTO));
	}
	public Date getContrato() {
		return contrato;
	}
	public void setContrato(Date contrato) {
		this.contrato = contrato;
	}

	@Override
	public String toString() {
		return "Empleados [numemp=" + numemp + ", nombre=" + nombre + ", edad=" + edad + ", oficina=" + oficina
				+ ", puesto=" + puesto + ", contrato=" + contrato + "]\n";
	}

	@Override
	public boolean equals(Object obj) {
		return this.getNumemp()==((Empleados)obj).numemp;
	}

	
	
	
}	
