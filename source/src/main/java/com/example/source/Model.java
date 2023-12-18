package com.example.source;

import com.example.source.claseTabele.Angajat;
import com.example.source.claseTabele.ContUtilizator;
import com.example.source.claseTabele.Utilizator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Model {
    private static ContUtilizator contCurent;
    private static Utilizator utilizatorCurent;
    private static Angajat angajatCurent;
    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    public static void logOut(ActionEvent event, String scenePath) throws IOException {
        root = FXMLLoader.load(Model.class.getResource(scenePath));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        contCurent = null;
        angajatCurent = null;
        utilizatorCurent = null;
    }

    static public boolean extrageContUtilizator(String username, String password) throws SQLException {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;
        ContUtilizator contUtilizator = null;

        boolean booleanVariable = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.err.println("An Exception occured during JDBC Driver loading." +
                    " Details are provided below:");
            ex.printStackTrace(System.err);
        }

        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/policlinica?user=root&password=parola");
            String query = "{call CautaCont(?,?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            resultSet = callableStatement.executeQuery();

            if (resultSet.next() == false)
                booleanVariable = false;
            else {
                contUtilizator = new ContUtilizator(Integer.parseInt(resultSet.getString("id")), resultSet.getString("nume_utilizator"), resultSet.getString("parola"));
                System.out.println(contUtilizator);
                booleanVariable = true;
            }
        } catch (SQLException sqlex) {
            System.err.println("An SQL Exception occured. Details are provided below:");
            sqlex.printStackTrace(System.err);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (selectStatement != null) {
                try {
                    selectStatement.close();
                } catch (SQLException e) {
                }
            }
            if (insertStatement != null) {
                try {
                    insertStatement.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
        return booleanVariable;
    }

    public static ObservableList<Angajat> cautaAngajat(String input) throws SQLException {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;
        ContUtilizator contUtilizator = null;

        ObservableList<Angajat> angajati = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.err.println("An Exception occured during JDBC Driver loading." +
                    " Details are provided below:");
            ex.printStackTrace(System.err);
        }
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/policlinica?user=root&password=parola");
            String query = "{call CautaAngajat(?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, input);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_utilizator = resultSet.getInt("id_utilizator");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String functie = resultSet.getString("functie");
                angajati.add(new Angajat(id, id_utilizator, nume, prenume, functie));
            }
        } catch (SQLException sqlex) {
            System.err.println("An SQL Exception occured. Details are provided below:");
            sqlex.printStackTrace(System.err);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (selectStatement != null) {
                try {
                    selectStatement.close();
                } catch (SQLException e) {
                }
            }
            if (insertStatement != null) {
                try {
                    insertStatement.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
        return angajati;
    }

    public static ObservableList<Angajat> listaAngajati() throws SQLException {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;
        ContUtilizator contUtilizator = null;

        ObservableList<Angajat> angajati = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.err.println("An Exception occured during JDBC Driver loading." +
                    " Details are provided below:");
            ex.printStackTrace(System.err);
        }
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/policlinica?user=root&password=parola");
            String query = "{call AfiseazaAngajati()}";
            callableStatement = connection.prepareCall(query);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_utilizator = resultSet.getInt("id_utilizator");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String functie = resultSet.getString("functie");
                angajati.add(new Angajat(id, id_utilizator, nume, prenume, functie));
            }
        } catch (SQLException sqlex) {
            System.err.println("An SQL Exception occured. Details are provided below:");
            sqlex.printStackTrace(System.err);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (selectStatement != null) {
                try {
                    selectStatement.close();
                } catch (SQLException e) {
                }
            }
            if (insertStatement != null) {
                try {
                    insertStatement.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
        return angajati;
    }
}
