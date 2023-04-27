package com.trabajadores.DBmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FirebirdDatabaseConnection {
    private static final String DB_URL = "jdbc:firebirdsql://217.160.39.39:3050/C:/Database/Jobbe/Data/JOBBE.WEB.00.FDB";
    private static final String DB_USER = "SYSDBA";
    private static final String DB_PASSWORD = "M1n0taur0";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
