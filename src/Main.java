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
    static double prod_price;
    static int num_stock;
    static String category;

    public static void main(String[] args) throws Exception {
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
                //Customer Connection
                con = DriverManager.getConnection(host, userName, password);
                input(inputD);
                stat = con.prepareStatement(sqls);

                //Product Connection
                con = DriverManager.getConnection(host, userName, password);
                input(inputD);
                stat = con.prepareStatement(sql);

                //used to add customer info into the database
                stat.setInt(1, cust_id);
                stat.setString(2, cust_name);
                stat.setString(3, cust_surname);
                stat.setString(4, cust_area);
                stat.setInt(5, cust_cell_no);
                int status = stat.executeUpdate();
                if (status > 0) {
                    System.out.println("Customer Information Updated Succesfully");
                }
                //used to add customer info into the database
                stat.setInt(1, prod_id);
                stat.setString(2, prod_name);
                stat.setDouble(3, prod_price);
                stat.setInt(4, num_stock);
                stat.setString(5, category);
                int statu = stat.executeUpdate();
                if (statu > 0) {
                    System.out.println("New Product Updated to Database Successfully");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    //to Update Customer Info
    public static void input(Scanner inputD) {
       String action = "";
        //to Update Product Info
        while (!action.equals("quit")) {
            System.out.print("Enter Action, (cud)for Customer Update, (pud)for Product Update and (quit)to exit : ");
            action = inputD.next();
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
                break;
            } else if (action.equals("pud")) {
                System.out.print("Product Id: ");
                prod_id = inputD.nextInt();
                System.out.print("Product Name: ");
                prod_name = inputD.next();
                System.out.print("Product Price: ");
                prod_price = inputD.nextDouble();
                System.out.print("Number of Product Stock: ");
                num_stock = inputD.nextInt();
                System.out.print("Category: ");
                category = inputD.next();
                break;
            }
        }
        }
    }


