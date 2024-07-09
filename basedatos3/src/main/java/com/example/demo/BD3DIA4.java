package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class BD3DIA4 {

    	public static void main(String[] args) {
		
            try {
				
				// hacemos connexión: 

				Class.forName("com.mysql.cj.jdbc.Driver");

				// conectamos con base datos especifica: 

				Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/vinilos?serverTimezone=UTC", "root","");

				System.out.println("Conexión establecida correctamente.");

				// creamos objeto: 

				Statement objeto1 = conexion1.createStatement();

				// actualizamos datos UPDATE: con preparedStatement

				String actualizar = "UPDATE vinilos SET titulo = ? WHERE id = ?";
				String actualizarTitulo = "UPDATE vinilos SET cantanteGrupo = ? WHERE id = ?";

				PreparedStatement prep = conexion1.prepareStatement(actualizar);
				prep.setString(1, "Patata");
				prep.setInt(2, 1);

				prep.execute();

				PreparedStatement prep2 = conexion1.prepareStatement(actualizarTitulo);
				prep2.setString(1, "Caca");
				prep2.setInt(2, 4);

				prep2.execute();
			
				System.out.println("Datos actualizados.");

				ResultSet resultado = objeto1.executeQuery("SELECT * FROM vinilos");

				while(resultado.next()){
					System.out.println("Titulo: " + resultado.getString("titulo") + ", Grupo: " + resultado.getString("cantanteGrupo")+ ", Lanzamiento: " + resultado.getString("fechaLanzamiento"));
				}

				conexion1.close();

			} catch (Exception e) {

				System.out.println("No funciona.");
				e.printStackTrace();
			}
            

	}

}
