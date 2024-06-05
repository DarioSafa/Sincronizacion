package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OficinasDAO {

	static Connection con = null;
	
	static public Connection conectar() {

        try {
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empresa","Dario","1234");	//Conexion con BD
        } catch (SQLException ex) {
            System.out.println("Error al conectar al SGBD.");
        }
        return con;
    }

	public static Oficinas read(int id) {
		
		Oficinas o1 = null;
		
		Connection con = conectar();
		
		String sql = "SELECT * FROM OFICINAS WHERE OFICINA = ?";
		
		try {
			PreparedStatement stt = con.prepareStatement(sql);
			stt.setInt(1, id);
			
			ResultSet rs = stt.executeQuery();
			
			if(rs.next()) {
				
				String ciudad = rs.getString("ciudad");
				int superficie = rs.getInt("superficie");
				double ventas = rs.getDouble("ventas");
				
				o1 = new Oficinas(id, ciudad, superficie, ventas);
			}
			
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o1;
		
	}
	
	//Create
	static public void create(Oficinas o) {
		//Creamos la conexion
		
		Connection con = conectar();
		
		String sql = "INSERT INTO Oficinas (oficina,ciudad,superficie,ventas)"
				+ "VALUES(?,?,?,?)";	//Sentencia parametrizada
		
		try {
			PreparedStatement sentencia = con.prepareStatement(sql);	//Creamos la sentencia
			sentencia.setInt(1, o.oficina);
			sentencia.setString(2, o.ciudad);
			sentencia.setInt(3, o.superficie);
			sentencia.setDouble(4, o.ventas);
			
			sentencia.executeUpdate();	//Ejecutamos la sentencia
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error de inserción");
		}
	}
	
	static public void update(Oficinas o) {
		
		if(o!=null) {
			
			Connection con = conectar();
			
			String sql = "UPDATE OFICINAS SET CIUDAD = ?,SUPERFICIE = ?,VENTAS = ? WHERE OFICINA = ?";
			
			try {
				PreparedStatement stt = con.prepareStatement(sql);
				stt.setString(1, o.getCiudad());
				stt.setInt(2, o.getSuperficie());
				stt.setDouble(3, o.getVentas());
				stt.setInt(4, o.getOficina());

				stt.executeUpdate();
				
				}
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	}

	static public void updateCiudadVentas(Oficinas o) {
		
		Connection con = conectar();
		
		String sql = "UPDATE OFICINAS SET CIUDAD = ?, VENTAS = ? WHERE OFICINA = ?";
		
		try {
			PreparedStatement stt = con.prepareStatement(sql);
			stt.setString(1, o.getCiudad());
			stt.setDouble(2, o.getVentas());
			stt.setInt(3, o.getOficina());
			
			stt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			System.out.println("error al modificar datos");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	static public List<Oficinas> listaOficinas(){
		
		Connection con = conectar();
		
		List<Oficinas> listaOfis = new ArrayList<>();
		
		String sql = "SELECT * FROM OFICINAS";
		
		try {
			Statement stt = con.createStatement();
			
			ResultSet rs = stt.executeQuery(sql);
			
			while(rs.next()) {
				int oficina = rs.getInt("oficina");
				String ciudad = rs.getString("ciudad");
				int superficie = rs.getInt("superficie");
				double ventas = rs.getDouble("ventas");
				
				Oficinas o = new Oficinas(oficina, ciudad, superficie, ventas);
				listaOfis.add(o);
			}
			
		con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al leer los datos");
		}
		
		return listaOfis;
	
	}
		
	static public List<Oficinas> listaCiudad(String ciudad){
		
		Connection con = conectar();
		
		List<Oficinas> listaOfis = new ArrayList<>();
		
		String sql = "SELECT * FROM OFICINAS WHERE CIUDAD=?";
		
		try {
			PreparedStatement stt = con.prepareStatement(sql);
			stt.setString(1, ciudad);
			
			ResultSet rs = stt.executeQuery();
			
			while(rs.next()) {
				int oficina = rs.getInt("oficina");
				int superficie = rs.getInt("superficie");
				double ventas = rs.getDouble("ventas");
				
				Oficinas o = new Oficinas(oficina, ciudad, superficie, ventas);
				listaOfis.add(o);
			}
			
		con.close();
			
		} catch (SQLException e) {
			System.out.println("Error al obtener la lista de oficinas en una ciudad");
		}
		
		return listaOfis;
		
	}
		

	static public List<Oficinas> listaOficinasSuperficie(int km){
		
		Connection con = conectar();
		
		List<Oficinas> listaOfis = new ArrayList<>();
		
		String sql = "SELECT * FROM OFICINAS WHERE SUPERFICIE > ?";
		
		try {
			PreparedStatement stt = con.prepareStatement(sql);
			
			stt.setInt(1, km);
			
			ResultSet rs = stt.executeQuery();
			
			while(rs.next()) {
				int oficina = rs.getInt("oficina");
				String ciudad = rs.getString("ciudad");
				int superficie = rs.getInt("superficie");
				double ventas = rs.getDouble("ventas");
				
				Oficinas o = new Oficinas(oficina, ciudad, superficie, ventas);
				listaOfis.add(o);
			}
			
		con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al leer los datos");
		}
		
		return listaOfis;
	
	}
}
