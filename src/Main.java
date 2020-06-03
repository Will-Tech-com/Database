import java.sql.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
    try {
        String host = "jdbc:mysql://localhost:3306/shop";
        String userName = "root";
        String password = "input password";
        Connection con = DriverManager.getConnection(host, userName, password);
        Statement stat = con.createStatement();

     //used to add customer info into the database
        String sql = "insert into customer"
                +"(Customer_ID, Customer_Name, Customer_Surname, Customer_Area, Customer_Cell_No)"
                +"Values ('12', 'Average', 'Joe', 'Newlands', '0629305452')";
                  System.out.println("Updated Succesfully");


        //used to display customer info in the database
        String sqls = "select * from customer";
        ResultSet c2 = stat.executeQuery(sqls);

        System.out.println("Customer Information");
        while (c2.next()){
            int cust_id = c2.getInt("Customer_ID");
            String cust_name = c2.getString("Customer_Name");
            String cust_surname = c2.getString("Customer_Surname");
            String cust_area = c2.getString("Customer_Area");
            int cust_cell = c2.getInt("Customer_Cell_No");

            String p = cust_id + " " + cust_name + " " + cust_surname + " " + cust_area + " " + cust_cell;
            System.out.println(p);

        }
    }catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    try{
        String host = "jdbc:mysql://localhost:3306/shop";
        String userName = "root";
        String password = "input password";
        Connection con = DriverManager.getConnection(host, userName, password);
        Statement stat = con.createStatement();

        //used to add product info into the database
        String sql = "insert into product"
                +"(Product_ID, Product_Name, Product_Price, Quantity_of_Stock, Category)"
                +"Values ('11', 'WeetBix', '50.00', '25', 'Breakfast')";

        stat.executeUpdate(sql);
        System.out.println("Updated Succesfully");


        //used to display product info in the database
        String sqls = "select * from product";
        ResultSet c2 = stat.executeQuery(sqls);

        System.out.println("Product Information");
        while (c2.next()) {
            int pro_id = c2.getInt("Product_ID");
            String pro_name = c2.getString("Product_Name");
            int pro_price = c2.getInt("Product_Price");
            int stock_num = c2.getInt("Quantity_of_Stock");
            String category = c2.getString("Category");

            String p = pro_id + " " + pro_name + " " + pro_price + " " + stock_num + " " + category;
            System.out.println(p);
        }
        }catch (Exception er){
        System.out.println(er.getMessage());
    }
        }
}
