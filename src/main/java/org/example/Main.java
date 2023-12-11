package org.example;
import java.sql.*;
import javax.sql.DataSource;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = user = "root";
        String password = "17b*98An"; // not my real password
        String query = "SELECT * FROM Products";
        try{
            //establish connection
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();
            //execute query
            ResultSet rs = stmt.executeQuery(query);
            //process the result set
            while(rs.next()){
                //input column name or index to get output
                System.out.println("ProductID: " + (rs.getString("ProductID")));
                System.out.println("Name: " + (rs.getString("ProductName")));
                System.out.println("Stock: " + (rs.getString("UnitsInStock")));
                System.out.println("----------------------");
            }
            //closing resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}