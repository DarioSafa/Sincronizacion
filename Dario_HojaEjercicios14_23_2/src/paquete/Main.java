package paquete;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Oficinas> listOfi = new ArrayList<>();
		listOfi = OficinasDAO.listaOficinas();
		int oficina;
		do {
			System.out.println("Introduce la oficina a modificar. 0 para salir");
			oficina = sc.nextInt();
			Oficinas o1 = OficinasDAO.read(oficina);
			if(o1==null && oficina !=0) {
				System.out.println("No existe ninguna oficina con este ID");
			}else {
				if(o1!=null) {
					System.out.println("Introduce la nueva ciudad");
					o1.setCiudad(scanner());
					System.out.println("Introduce las ventas");
					double ventas;
					ventas = sc.nextDouble();
					o1.setVentas(ventas);
					
					OficinasDAO.update(o1);	
				}else {
					System.out.println("Saliendo...");
				}

			}
		}while(oficina!=0);
	}
	
	public static String scanner() {
		Scanner sc = new Scanner(System.in);
		String palabra;
		palabra = sc.nextLine();
		return palabra;
	}
}
