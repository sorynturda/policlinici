package com.example.source;

import com.example.source.claseTabele.*;
import com.example.source.controller.ResurseUmane.SceneConcediu;
import com.example.source.controller.ResurseUmane.SceneOrarConcediu;
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
import java.time.LocalDate;

public class Model {
    public static final String SUPERADMIN = "super_admin";
    public static final String ADMIN = "admin";
    public static final String UTILIZATOR = "utilizator";
    public static final String MEDIC = "medic";
    public static final String ASISTENT_MEDICAL = "asistent_medical";
    public static final String RECEPTIONER = "receptioner";
    public static final String ECONOMIC = "economic";
    public static final String RESURSE_UMANE = "resurse_umane";
    private static ContUtilizator contCurent;
    private static Utilizator utilizatorCurent;
    private static Angajat angajatCurent;
    private static Angajat angajatSelectat;
    private static Medic medicCurent;
    private static AsistentMedical asistentCurent;
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

    static public boolean logIn(String username, String password) throws SQLException {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

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
                contCurent = new ContUtilizator(Integer.parseInt(resultSet.getString("id")), resultSet.getString("nume_utilizator"), resultSet.getString("parola"));
                System.out.println(contCurent);
                extrageUtilizator(contCurent.getId());
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

    public static ObservableList<ConcediuT> listaConcedii(int id_angajat) throws SQLException {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

        ObservableList<ConcediuT> concedii = FXCollections.observableArrayList();

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
            String query = "{call ExtrageConcediiReadOnly(?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, Integer.toString(id_angajat));
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date data_inceput = resultSet.getDate("data_inceput");
                Date data_sfarsit = resultSet.getDate("data_sfarsit");
                System.out.println(id + " " + " " + id_angajat + " " + " " + data_inceput + " " + " " + data_sfarsit);
                concedii.add(new ConcediuT(id, id_angajat, data_inceput, data_sfarsit));
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
        return concedii;
    }

    public static ObservableList<Pacient> listaPacienti() throws SQLException {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

        ObservableList<Pacient> pacienti = FXCollections.observableArrayList();

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
            String query = "{call ExtragePacienti()}";
            callableStatement = connection.prepareCall(query);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                pacienti.add(new Pacient(id, nume, prenume));
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
        return pacienti;
    }

    public static ObservableList<Specialitati> listaSpecialitatiMedic(int id) throws SQLException {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

        ObservableList<Specialitati> specialitati = FXCollections.observableArrayList();

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
            String query = "{call AfiseazaSpecialitati(?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, Integer.toString(id));
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id_specialitate = resultSet.getInt("id");
                String nume_specialitate = resultSet.getString("nume_specialitate");
                String grad = resultSet.getString("grad");
                specialitati.add(new Specialitati(id_specialitate, nume_specialitate, grad));
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
        return specialitati;
    }

    public static void extrageUtilizator(int id) {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

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
            String query = "{call CautaUtilizatorDupaCont(?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, Integer.toString(id));
            resultSet = callableStatement.executeQuery();
            if (resultSet.next())
                utilizatorCurent = new Utilizator(
                        resultSet.getInt("id"),
                        resultSet.getString("departament"),
                        resultSet.getString("adresa"),
                        resultSet.getString("cnp"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getString("telefon"),
                        resultSet.getString("email"),
                        resultSet.getString("IBAN"),
                        resultSet.getString("data_angajarii"),
                        resultSet.getString("rol")
                );
            System.out.println(utilizatorCurent);
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
    }

    public static boolean concediuCorect(int id_angajat, Date ziInceput, Date ziSfarsit) {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

        boolean posibil = true;

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
            String query = "SELECT  id, concedii.id_angajat, concedii.data_inceput, concedii.data_sfarsit FROM concedii " +
                    "WHERE concedii.id_angajat = " + id_angajat +
                    " AND id = (SELECT max(id) FROM concedii WHERE id_angajat = " + id_angajat + ")";

            callableStatement = connection.prepareCall(query);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                id_angajat = resultSet.getInt("id_angajat");
                Date data_inceput = resultSet.getDate("data_inceput");
                Date data_sfarsit = resultSet.getDate("data_sfarsit");
                if (ziInceput.before(data_sfarsit) || ziInceput.equals(data_sfarsit)) {
                    posibil = false;
                    System.out.println(ziInceput + "    " + data_sfarsit);
                }
                System.out.println(id + " " + id_angajat + " " + data_inceput + " " + data_sfarsit);
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
        return posibil;
    }

    public static void adaugaConcediu(int id_angajat, LocalDate ziInceput, LocalDate ziSfarsit) {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

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
            String query = "{call SeteazaConcediu(?, ?, ?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, Integer.toString(id_angajat));
            callableStatement.setString(2, ziInceput.toString());
            callableStatement.setString(3, ziSfarsit.toString());
            resultSet = callableStatement.executeQuery();
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
    }

    public static void extrageAngajatDupaUtilizator(int id) {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

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
            String query = "{call CautaAngajatDupaUtilizator(?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, Integer.toString(id));
            resultSet = callableStatement.executeQuery();
            if (resultSet.next())
                angajatCurent = new Angajat(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_utilizator"),
                        resultSet.getInt("id_policlinica"),
                        utilizatorCurent.getNume(),
                        utilizatorCurent.getPrenume(),
                        resultSet.getString("functie"),
                        resultSet.getInt("salariu_negociat"),
                        resultSet.getInt("numar_ore")
                );
            System.out.println(angajatCurent);
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
    }

    public static void extrageAsistentMedical(int id) {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

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
            String query = "{call CautaAsistentMedical(?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, Integer.toString(id));
            resultSet = callableStatement.executeQuery();
            if (resultSet.next())
                asistentCurent = new AsistentMedical(
                        resultSet.getInt("id"),
                        resultSet.getString("tip"),
                        resultSet.getString("grad")
                );
            System.out.println(asistentCurent);
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
    }

    public static void extrageMedic(int id) {
        Connection connection = null;
        Statement selectStatement = null;
        Statement insertStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        CallableStatement callableStatement = null;

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
            String query = "{call CautaMedic(?)}";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, Integer.toString(id));
            resultSet = callableStatement.executeQuery();
            if (resultSet.next())
                medicCurent = new Medic(
                        resultSet.getInt("id"),
                        resultSet.getString("cod_parafa"),
                        resultSet.getString("titlu_stiintific"),
                        resultSet.getString("post_didactic"),
                        resultSet.getDouble("venit_aditional")
                );
            System.out.println(medicCurent);
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
    }

    public static void switchToWindowOrare(ActionEvent event, Angajat a) throws IOException {
        FXMLLoader loader = new FXMLLoader(Model.class.getResource("/com.example.source/scene-resurse-umane-orar-concediu-view.fxml"));
        root = loader.load();

        SceneOrarConcediu orar = loader.getController();
        orar.setAngajatSelectat(a);
        angajatSelectat = a;

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToWindowConcedii(ActionEvent event, Angajat a) throws IOException {
        FXMLLoader loader = new FXMLLoader(Model.class.getResource("/com.example.source/scene-resurse-umane-concedii-view.fxml"));
        root = loader.load();

        SceneConcediu concediu = loader.getController();
        concediu.setAngajatSelectat(a);
        angajatSelectat = a;

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void goToMainMenu(ActionEvent event, String scenePath) throws IOException {
        root = FXMLLoader.load(Model.class.getResource(scenePath));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static Utilizator getUtilizatorCurent() {
        return utilizatorCurent;
    }

    public static Angajat getAngajatCurent() {
        return angajatCurent;
    }

    public static Angajat getAngajatSelectat() {
        return angajatSelectat;
    }

    public static Medic getMedicCurent() {
        return medicCurent;
    }

    public static AsistentMedical getAsistentCurent() {
        return asistentCurent;
    }
}
