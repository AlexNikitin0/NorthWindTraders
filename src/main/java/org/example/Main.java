package org.example;
import java.sql.*;
import javax.sql.DataSource;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = user = "root";
        String password = "1234"; // not my real password
        String query = "SELECT * FROM Products";
        try{
            //establish connection
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();
            //execute query
            ResultSet rs = stmt.executeQuery(query);
            //process the result set
            while(rs.next()){
                //input column name or index
                System.out.println(rs.getString(2));
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