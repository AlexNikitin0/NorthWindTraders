package org.example;
import java.sql.*;
import javax.sql.DataSource;
import java.util.Scanner;


public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    public static String url = "jdbc:mysql://localhost:3306/northwind";
    public static String user = user = "root";
    public static String password = "123"; // not my real password
    public static PreparedStatement preparedStatement = null;

    public static void main(String[] args) {
        int userChoice;
        int id;
        System.out.println("What do you want to do?");
        System.out.println("1) Display all products");
        System.out.println("2) Display all customers");
        System.out.println("3) Display all categories");
        System.out.println("0) Exit");
        System.out.print("Select an option: ");
        userChoice = keyboard.nextInt();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        if (userChoice == 1) {
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
            } finally {
                //close resources
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        } else if (userChoice == 2) {
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
            } finally {
                //close resources
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        } else if (userChoice == 3) {

            String query = "SELECT * FROM Categories ORDER BY CategoryID";
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt1 = connection.prepareStatement(query);
                 //execute query
                 ResultSet rs2 = stmt1.executeQuery();) {
                //establish connection

                //process the result set
                while (rs2.next()) {
                    //input column name or index to get output
                    System.out.println("Category ID: " + (rs2.getString("CategoryID")));
                    System.out.println("Category Name: " + (rs2.getString("CategoryName")));
                    System.out.println("----------------------");
                }
                System.out.println("Please select a Category ID to list: ");
                id =keyboard.nextInt();
                ResultSet rs3 = null;
                preparedStatement = connection.prepareStatement("SELECT * FROM Products WHERE categoryID = ?");
                //execute query
                preparedStatement.setInt(1,id);
                rs3 = preparedStatement.executeQuery();

                while (rs3.next()) {
                    System.out.println("ProductID " + rs3.getString("ProductID"));
                    System.out.println("ProductName " + rs3.getString("ProductName"));
                    System.out.println("UnitPrice " + rs3.getString("UnitPrice"));
                    System.out.println("UnitsInStock " + rs3.getString("UnitsInStock"));
                    System.out.println("""
                        ----------------------------------
                        """);

                }

                }catch(SQLException e){
                e.printStackTrace();

            }

        }

    }
}


