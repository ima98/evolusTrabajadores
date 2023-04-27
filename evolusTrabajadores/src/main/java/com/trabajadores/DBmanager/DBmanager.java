package com.trabajadores.DBmanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBmanager {
    
    //private FirebirdDatabaseConnection conexion;

    public DBmanager() {
        super();
    }
    
    public String[] login(String idusuario) {
        String[] valoresDB = new String[2];
        try {
            Connection conn = FirebirdDatabaseConnection.getConnection();
            Statement stmt=conn.createStatement();
            System.out.println("-----------------------------Conexion---------------------");
            String query="SELECT * FROM USUARIOS WHERE USUARIOS.IDUSUARIO='"+idusuario+"'";
            System.out.println(query);            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {                
                valoresDB[0] = rs.getString("IDUSUARIO");

                valoresDB[1] = rs.getString("CLAVE");               
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valoresDB;
    }

}
