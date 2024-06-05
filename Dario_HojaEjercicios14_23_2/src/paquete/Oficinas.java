package paquete;

public class Oficinas {
	
	private final int TAM_CIUDAD = 30;
	
	int oficina;
	String ciudad;
	int superficie;
	double ventas;
	
	public Oficinas(int oficina, String ciudad, int superficie, double ventas) {
		this.oficina = oficina;
		this.setCiudad(ciudad);
		this.superficie = superficie;
		this.ventas = ventas;
	}
	
	public Oficinas(int oficina) {
		this.oficina= oficina;
	}
	
	public int getOficina() {
		return oficina;
	}
	public void setOficina(int oficina) {
		this.oficina = oficina;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad.substring(0, Math.min(ciudad.length(), TAM_CIUDAD));
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public double getVentas() {
		return ventas;
	}

	public void setVentas(double ventas) {
		this.ventas = ventas;
	}
	@Override
	public String toString() {
		return "Oficinas [oficina=" + oficina + ", ciudad=" + ciudad + ", superficie="
				+ superficie + ", ventas=" + ventas + "]\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.oficina==((Oficinas)obj).getOficina();
	}
	
	
	
}
