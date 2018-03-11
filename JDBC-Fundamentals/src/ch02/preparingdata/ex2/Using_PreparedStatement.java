/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch02.preparingdata.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author barcvilla
 */
public class Using_PreparedStatement 
{
    public static void main(String[] args) {
        try
        {
            // 1. Registrar la clase / Loaded the library
            Class.forName("com.mysql.jdbc.Driver");
            
            // 2. Realizar una conexion
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcfundamentals", "root", "rpgile400");
            
            // 3. Realizar un Statement
            // PreparedStatement es utilizado en queries con parametros
            PreparedStatement pst = con.prepareStatement("insert into products (ProductID, ProductName, Description, Price) values (?, ?, ?, ?);");
            
            int productID = 7;
            String productName = "Galaxy Note";
            String description = "Samsung Galaxy Note 10";
            double price = 15000;
            
            pst.setInt(1, productID);
            pst.setString(2, productName);
            pst.setString(3, description);
            pst.setDouble(4, price);
            
            int result = pst.executeUpdate();
            
            // executeUpdate nos retorna un int value
            //int result = st.executeUpdate("insert into products (ProductID, ProductName, Description, Price) values (" + productID + ", '" + productName + "', '" + description + "', " + price + ");");
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
