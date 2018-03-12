/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.connection.retrieving;

import java.sql.*;
/**
 * Pasos
 * 1. Registrar nuestra clase
 * 2. Realizar una conexion
 * 3. Realizar un Statement
 * 4. Escribir un query
 * 5. Recuperar los resultados en un ResultSet
 * @author barcvilla
 */
public class SampleDBApp {
    public static void main(String[] args) {
        try
        {
            // 1. Registrar la clase / Loaded the library
            Class.forName("com.mysql.jdbc.Driver");
            
            // 2. Realizar una conexion
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcfundamentals", "root", "rpgile400");
            
            // 3. Realizar un Statement
            Statement st = con.createStatement(); 
            
            // 4. Escribir un Query
            ResultSet rs = st.executeQuery("select * from products;"); // usamos executeQuery solo para SELECT statements
            
            System.out.println("Product Names List");
            System.out.println("==================");
            while(rs.next())
            {
                System.out.println(rs.getString(2));
            }
            
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println("Connection Problem: " + ex.getMessage());
        }
    }
}
