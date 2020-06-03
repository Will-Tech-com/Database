import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
        
public class Main {

    static int cust_id;
    static String cust_name;
    static String cust_surname;
    static String cust_area;
    static int cust_cell_no;

    static int prod_id;
    static String prod_name;
    static int prod_price;
    static int num_stock;
    static String category;

    public static void main(String[] args) {
        String host = "jdbc:mysql://localhost:3306/shop";
        String userName = "root";
        String password = "will12boskowski1999";
        Scanner inputD = new Scanner(System.in);
        Connection con = null;
        PreparedStatement stat = null;
        String sqls = "INSERT INTO customer"
                + "(Customer_ID, Customer_Name, Customer_Surname, Customer_Area, Customer_Cell_No)"
                + "VALUES (?, ?, ?, ?, ?)";

        String sql = "INSERT INTO product"
                + "(Product_Id, Product_Name, Product_Price, Quantity_of_Stock, Category)"
                + "VALUES (?, ?, ?, ?, ?)";


        try {

            con = DriverManager.getConnection(host, userName, password);
            input(inputD);

            stat = con.prepareStatement(sqls);

            //used to add customer info into the database
            stat.setInt(1, cust_id);
            stat.setString(2, cust_name);
            stat.setString(3, cust_surname);
            stat.setString(4, cust_area);
            stat.setInt(5, cust_cell_no);
            int status = stat.executeUpdate();

            if (status > 0) {
                System.out.println("Updated Succesfully");
            }
            //used to display customer info in the database
            ResultSet c2 = stat.executeQuery(sqls);

            System.out.println("\nCustomer Information\n");

            int cust_id = c2.getInt("Customer_ID");
            String cust_name = c2.getString("Customer_Name");
            String cust_surname = c2.getString("Customer_Surname");
            String cust_area = c2.getString("Customer_Area");
            int cust_cell = c2.getInt("Customer_Cell_No");

            String p = cust_id + " " + cust_name + " " + cust_surname + " " + cust_area + " " + cust_cell;


        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(host, userName, password);
            input(inputD);
            stat = con.prepareStatement(sql);

            stat.setInt(1, prod_id);
            stat.setString(2, prod_name);
            stat.setInt(3, prod_price);
            stat.setInt(4, num_stock);
            stat.setString(5, category);
            int status = stat.executeUpdate();

            if (status > 0) {
                System.out.println("Updated Succesfully");
            }

            //used to display product info in the database
            ResultSet c2 = stat.executeQuery(sql);

            System.out.println("\nProduct Information\n");
            while (c2.next()) {
                int pro_id = c2.getInt("Product_ID");
                String pro_name = c2.getString("Product_Name");
                int pro_price = c2.getInt("Product_Price");
                int stock_num = c2.getInt("Quantity_of_Stock");
                String category = c2.getString("Category");

                String ps = pro_id + " " + pro_name + " " + pro_price + " " + stock_num + " " + category;

            }
        } catch (Exception er) {
            System.out.println(er.getMessage());
        }
    }

    //to Update Customer Info
    public static void input(Scanner inputD) {
        System.out.println("Enter Action, (cud)for Customer Update and (pub)for Product Update : ");
        String action = inputD.next();
        if (action.equals("cud")) {
            System.out.print("Customer Id: ");
            cust_id = inputD.nextInt();
            System.out.print("Customer Name: ");
            cust_name = inputD.next();
            System.out.print("Customer Surname: ");
            cust_surname = inputD.next();
            System.out.print("Customer Area: ");
            cust_area = inputD.next();
            System.out.print("Customer Cell Number: ");
            cust_cell_no = inputD.nextInt();
        }
        //to Update Product Info
        else if (action.equals("pub")) {
            System.out.print("Product Id: ");
            prod_id = inputD.nextInt();
            System.out.print("Product Name: ");
            prod_name = inputD.next();
            System.out.print("Product Price: ");
            prod_price = inputD.nextInt();
            System.out.print("Number of Product Stock: ");
            num_stock = inputD.nextInt();
            System.out.print("Category: ");
            category = inputD.next();
        }
    }
}

