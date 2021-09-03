/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author David
 */

public class Conexion {
     private String user, password, db, url, puerto, driver;
    private Connection conexion;

    public Conexion() {

        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        db = "academia";
        puerto = "3306";
        url = "jdbc:mysql://localhost:"+puerto+"/"+db;

        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion genial");
        } catch (Exception e) {
            System.out.println("Error de conexion" + e.toString());
        }
    }

    public Connection obtenerConexion() {
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion=null;
        return conexion;
    }
    public static void main(String[] args) {
        new Conexion();
    }
}
