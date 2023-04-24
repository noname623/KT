package org.example.proccesing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connecting {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?user=root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "кщще";

    public Statement connect() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(URL, username, password);
        Statement stmt = conn.createStatement();
        if (conn != null) {
            System.out.println("Server connect");
        } else {
            System.out.println("Connecting failed...");
        }
        return stmt;
    }
}
