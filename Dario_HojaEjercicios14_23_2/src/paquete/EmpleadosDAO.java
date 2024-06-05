package paquete;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpleadosDAO {

	
	static public Connection conectar() {
		Connection con=null;
		
        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa","Dario","1234");	//Conexion con BD
        } catch (SQLException ex) {
            System.out.println("Error al conectar al SGBD.");
        }
        return con;
    }
	
	static public void create(Empleados e) {
		Connection con = conectar();
		
		String sql = "INSERT INTO EMPLEADOS VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement stt = con.prepareStatement(sql);
			stt.setInt(1, e.getNumemp());
			stt.setString(2, e.getNombre());
			stt.setInt(3, e.getEdad());
			stt.setInt(4, e.getOficina());
			stt.setString(5, e.getPuesto());
			stt.setDate(6, new java.sql.Date(e.contrato.getTime())); //fecha de hoy	
			stt.executeUpdate();	
			con.close();
		} catch (SQLException exc) {
			System.out.println("Error al insertar valor");
			exc.printStackTrace();
		}
	}
	
	static public void delete(int id) {
		Connection con = conectar();
		
		String sql = "DELETE FROM EMPLEADOS WHERE NUMEMP = ?";
		
		try {
			PreparedStatement stt = con.prepareStatement(sql);
			stt.setInt(1, id);
			
			stt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Fallo al borrar");
			e.printStackTrace();
		}
		
		
		
	}
	
	static public void muestraEmpleadoRango() {
		
		
		int min,max;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el valor minimo de edad");
		min = sc.nextInt();
		System.out.println("Introduce el valor maximo de edad");
		max = sc.nextInt();
		
		Connection con = conectar();
		
		String sql = "SELECT NOMBRE,EDAD FROM EMPLEADOS WHERE EDAD BETWEEN ? AND ?";
		try {
			PreparedStatement stt = con.prepareStatement(sql);
			stt.setInt(1, min);
			stt.setInt(2, max);
			
			ResultSet rs = stt.executeQuery();
			
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				int edad = rs.getInt("edad");
				
				System.out.println("Empleado -> "+ nombre+" | Edad: " +edad);
			}
		
		con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al filtrar la informacion");
		}
		
	}
	
	public static List<Empleados> todosEmpleados(){
		
		Connection con = conectar();
		List<Empleados> emp = new ArrayList<>();
		
		
		String sql = "SELECT NUMEMP FROM EMPLEADOS";
		
		try {
			PreparedStatement stt = con.prepareStatement(sql);
			ResultSet rs = stt.executeQuery();
			int id;
			
			while(rs.next()) {
				id = rs.getInt("numemp");
				emp.add(new Empleados(id));
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}
	
}
