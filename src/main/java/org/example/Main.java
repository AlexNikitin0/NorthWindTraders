package org.example;
import java.sql.*;
import javax.sql.DataSource;
import java.util.Scanner;


public class Main {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        int userChoice;
        System.out.println("What do you want to do?");
        System.out.println("1) Display all products");
        System.out.println("2) Display all customers");
        System.out.println("0) Exit");
        System.out.print("Select an option: ");
        userChoice = keyboard.nextInt();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        if(userChoice == 1) {

            String url = "jdbc:mysql://localhost:3306/northwind";
            String user = user = "root";
            String password = "17b*98An"; // not my real password
            String query = "SELECT * FROM Products";
            try {
                //establish connection
                 conn = DriverManager.getConnection(url, user, password);
                 stmt = conn.createStatement();
                //execute query
                rs = stmt.executeQuery(query);
                //process the result set
                while (rs.next()) {
                    //input column name or index to get output
                    System.out.println("ProductID: " + (rs.getString("ProductID")));
                    System.out.println("Name: " + (rs.getString("ProductName")));
                    System.out.println("Stock: " + (rs.getString("UnitsInStock")));
                    System.out.println("----------------------");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                //close resources
                if(rs != null){
                    try{
                        rs.close();
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                if(stmt != null){
                    try {
                        stmt.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                if(conn != null){
                    try{
                        conn.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }

        }

        else if(userChoice == 2){

            String url = "jdbc:mysql://localhost:3306/northwind";
            String user = user = "root";
            String password = "17b*98An"; // not my real password
            String query = "SELECT * FROM Customers";
            try {
                //establish connection
                conn = DriverManager.getConnection(url, user, password);
                stmt = conn.createStatement();
                //execute query
                rs = stmt.executeQuery(query);
                //process the result set
                while (rs.next()) {
                    //input column name or index to get output
                    System.out.println("Contact Name: " + (rs.getString("ContactName")));
                    System.out.println("Company Name: " + (rs.getString("CompanyName")));
                    System.out.println("City: " + (rs.getString("City")));
                    System.out.println("Phone: " + (rs.getString("Phone")));
                    System.out.println("----------------------");
                }


        } catch (SQLException e) {
                e.printStackTrace();
            }

            finally {
                //close resources
                if(rs != null){
                    try{
                        rs.close();
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                if(stmt != null){
                    try {
                        stmt.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                if(conn != null){
                    try{
                        conn.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}

