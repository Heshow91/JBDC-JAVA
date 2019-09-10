package test;

import java.sql.*;

public class ConnectToMysql {

    public static void main(String[] args) throws SQLException {

        String userName = "root";
        String password = "181WhyNot!";
        //jdbc:mysql driver
        //localhost = hostname
        //3306 = port in which data base is being executed
        //employees = database name
        //false = query params which specifies not to bother about SSL certificate error

        String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";

        String query = "select* from employees.employee_detail;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ee) {
            System.out.println("Check Driver");
            ee.printStackTrace();
        }
        // for connecting to jbdc
        Connection connection = DriverManager.getConnection(url, userName, password);

        //statement
        Statement statement = connection.createStatement();
        // establishing the connection via jbdc

        // resultset for the statement
        ResultSet table = statement.executeQuery(query);

        System.out.println("name" + " " + "id" + " " + "salary");
        while (table.next()) {
            //getString gets the column name of DB
            String value1 = table.getString("name");
            String value2 = table.getString("id");
            String value3 = table.getString("salary");
            System.out.println(value1 + " " + value2 + " " + value3);
        }
        statement.close();
        connection.close();


    }
}
