package com.example.source;

import java.sql.*;

public class Model {
    static private Connection connection;
    static private Statement selectStatement, insertStatement;
    static private ResultSet resultSet;
    static private ResultSetMetaData resultSetMetaData;

    static private CallableStatement callableStatement;

    static private ContUtilizator contUtilizator;

    public Model() throws SQLException {
        connection = null;
        selectStatement = null;
        insertStatement = null;
        resultSet = null;
        resultSetMetaData = null;
        callableStatement = null;
        contUtilizator = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.err.println("An Exception occured during JDBC Driver loading." +
                    " Details are provided below:");
            ex.printStackTrace(System.err);
        }

        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/policlinica?user=root&password=parola"); //parola = parola root

        } catch (SQLException sqlex) {
            System.err.println("An SQL Exception occured. Details are provided below:");
            sqlex.printStackTrace(System.err);
        }
    }

    static public boolean extrageContUtilizator(String username, String password) throws SQLException {
        String query = "{call CautaCont(?,?)}";
        callableStatement = connection.prepareCall(query);
        callableStatement.setString(1, username);
        callableStatement.setString(2, password);
        resultSet = callableStatement.executeQuery();

        if(resultSet.next() == false)
            return false;

        contUtilizator = new ContUtilizator(Integer.parseInt(resultSet.getString("id")), resultSet.getString("nume_utilizator"), resultSet.getString("parola"));
        System.out.println(contUtilizator);
        return true;
    }
}
