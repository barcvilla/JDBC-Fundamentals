/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.preparingdata.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author barcvilla
 */
public class Using_ExecuteUpdate 
{
    public static void main(String[] args) {
        try
        {
            // 1. Registrar la clase / Loaded the library
            Class.forName("com.mysql.jdbc.Driver");
            
            // 2. Realizar una conexion
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcfundamentals", "root", "rpgile400");
            
            // 3. Realizar un Statement
            Statement st = con.createStatement(); 
            
            int productID = 6;
            String productName = "Numeric Keyboard";
            String description = "Logitech Numeric Keyboard";
            double price = 75;
            
            // executeUpdate nos retorna un int value
            int result = st.executeUpdate("insert into products (ProductID, ProductName, Description, Price) values (" + productID + ", '" + productName + "', '" + description + "', " + price + ");");
            if(result > 0)
            {
                System.out.println("Record Inserted Successfuly");
            }
            else
            {
                System.out.println("Insert operation UnSuccessfuly");
            }
            
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println("Connection Problem: " + ex.getMessage());
        }
    }

}
