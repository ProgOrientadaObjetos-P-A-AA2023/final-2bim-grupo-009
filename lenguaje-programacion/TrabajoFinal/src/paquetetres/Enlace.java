package paquetetres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paqueteuno.*;

public class Enlace {

    private Connection conn;
    private ArrayList<PlanCelular> lista;

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:db/base001.db";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarPlanPostPagoMegas(PlanPostPagoMegas p) {
        try {
            establecerConexion();

            Statement statement = obtenerConexion().createStatement();

            String data = String.format("INSERT INTO planPostPagoMegas (nombres,"
                    + " apellidos, pasaporte, barrio, marca, modelo, numeroCelular"
                    + ", megasExpresadoGigas, costoCadaGiga, tarifaBase) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, "
                    + "%s, %s)",
                    p.obtenerNombres(),
                    p.obtenerApellidos(),
                    p.obtenerPasaporte(),
                    p.obtenerBarrio(),
                    p.obtenerMarca(),
                    p.obtenerModelo(),
                    p.obtenerNumeroCelular(),
                    p.obtenerMegasExpresadoGigas(),
                    p.obtenerCostoCadaGiga(),
                    p.obtenerTarifaBase());

            statement.executeUpdate(data);
            obtenerConexion().close();

        } catch (SQLException ex) {
            System.out.println("Exception: planPostPagoMegas");
            System.out.println(ex.getMessage());
        }

    }

    public void insertarPlanPostPagoMinutos(PlanPostPagoMinutos p) {
        try {
            establecerConexion();

            Statement statement = obtenerConexion().createStatement();

            String data = String.format("INSERT INTO planPostPagoMinutos (nombres,"
                    + " apellidos, pasaporte, barrio, marca, modelo, numeroCelular"
                    + ", minutosNacionales, costoMinutoNacional, minutosInternacionales, "
                    + "costoMinutoInternacional) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, "
                    + "%s, %s, %s)",
                    p.obtenerNombres(),
                    p.obtenerApellidos(),
                    p.obtenerPasaporte(),
                    p.obtenerBarrio(),
                    p.obtenerMarca(),
                    p.obtenerModelo(),
                    p.obtenerNumeroCelular(),
                    p.obtenerMinutosNacionales(),
                    p.obtenerCostoMinutoNacional(),
                    p.obtenerMinutosInternacionales(),
                    p.obtenerCostoMinutoInternacional());

            statement.executeUpdate(data);
            obtenerConexion().close();

        } catch (SQLException ex) {
            System.out.println("Exception: planPostPagoMinutos");
            System.out.println(ex.getMessage());

        }

    }

    public void insertarPlanPostPagoMinutosMegas(PlanPostPagoMinutosMegas p) {
        try {
            establecerConexion();

            Statement statement = obtenerConexion().createStatement();

            String data = String.format("INSERT INTO planPostPagoMinutosMegas (nombres,"
                    + " apellidos, pasaporte, barrio, marca, modelo, numeroCelular"
                    + ", minutos, costoMinutos, megas, costoGiga) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, "
                    + "%s, %s, %s)",
                    p.obtenerNombres(),
                    p.obtenerApellidos(),
                    p.obtenerPasaporte(),
                    p.obtenerBarrio(),
                    p.obtenerMarca(),
                    p.obtenerModelo(),
                    p.obtenerNumeroCelular(),
                    p.obtenerMinutos(),
                    p.obtenerCostoMinutos(),
                    p.obtenerMegas(),
                    p.obtenerCostoGiga());

            statement.executeUpdate(data);
            obtenerConexion().close();

        } catch (SQLException ex) {
            System.out.println("Exception: planPostPagoMinutosMegas");
            System.out.println(ex.getMessage());

        }

    }

    public void insertarPlanPostPagoMinutosMegasEconomico(PlanPostPagoMinutosMegasEconomico p) {
        try {
            establecerConexion();

            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMinutosMegasEconomico (nombres,"
                    + " apellidos, pasaporte, barrio, marca, modelo, numeroCelular"
                    + ", minutos, costoMinutos, megas, costoGiga, descuento) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, "
                    + "%s, %s, %s, %s)",
                    p.obtenerNombres(),
                    p.obtenerApellidos(),
                    p.obtenerPasaporte(),
                    p.obtenerBarrio(),
                    p.obtenerMarca(),
                    p.obtenerModelo(),
                    p.obtenerNumeroCelular(),
                    p.obtenerMinutos(),
                    p.obtenerCostoMinutos(),
                    p.obtenerMegas(),
                    p.obtenerCostoGiga(),
                    p.obtenerDescuento());

            statement.executeUpdate(data);
            obtenerConexion().close();

        } catch (SQLException ex) {
            System.out.println("Exception: planPostPagoMinutosMegasEconomico");
            System.out.println(ex.getMessage());

        }

    }

    public void establecerListaPlanCelular() {
        lista = new ArrayList<>();

        try {
            establecerConexion();

            Statement statement = obtenerConexion().createStatement();

            String data = "Select * from planPostPagoMegas";
            ResultSet rs = statement.executeQuery(data);

            while (rs.next()) {
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String pasaporte = rs.getString("pasaporte");
                String barrio = rs.getString("barrio");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String numeroCelular = rs.getString("numeroCelular");

                PlanPostPagoMegas p = new PlanPostPagoMegas(nombres, apellidos,
                        pasaporte, barrio, marca, modelo, numeroCelular);

                p.establecerMegasExpresadoGigas(rs.getDouble("megasExpresadoGigas"));
                p.establecerCostoCadaGiga(rs.getDouble("costoCadaGiga"));
                p.establecerTarifaBase(rs.getDouble("tarifaBase"));

                lista.add(p);
            }

            data = "Select * from planPostPagoMinutos";
            rs = statement.executeQuery(data);

            while (rs.next()) {
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String pasaporte = rs.getString("pasaporte");
                String barrio = rs.getString("barrio");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String numeroCelular = rs.getString("numeroCelular");

                PlanPostPagoMinutos p = new PlanPostPagoMinutos(nombres, apellidos,
                        pasaporte, barrio, marca, modelo, numeroCelular);

                p.establecerMinutosNacionales(rs.getDouble("minutosNacionales"));
                p.establecerCostoMinutoNacional(rs.getDouble("costoMinutoNacional"));
                p.establecerMinutosInternacionales(rs.getDouble("minutosInternacionales"));
                p.establecerCostoMinutoInternacional(rs.getDouble("costoMinutoInternacional"));

                lista.add(p);
            }

            data = "Select * from planPostPagoMinutosMegas";
            rs = statement.executeQuery(data);

            while (rs.next()) {
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String pasaporte = rs.getString("pasaporte");
                String barrio = rs.getString("barrio");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String numeroCelular = rs.getString("numeroCelular");

                PlanPostPagoMinutosMegas p = new PlanPostPagoMinutosMegas(nombres, apellidos,
                        pasaporte, barrio, marca, modelo, numeroCelular);

                p.establecerMinutos(rs.getDouble("minutos"));
                p.establecerCostoMinutos(rs.getDouble("costoMinutos"));
                p.establecerMegas(rs.getDouble("megas"));
                p.establecerCostoGiga(rs.getDouble("costoGiga"));

                lista.add(p);
            }

            data = "Select * from planPostPagoMinutosMegasEconomico";
            rs = statement.executeQuery(data);

            while (rs.next()) {
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String pasaporte = rs.getString("pasaporte");
                String barrio = rs.getString("barrio");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String numeroCelular = rs.getString("numeroCelular");

                PlanPostPagoMinutosMegasEconomico p = new PlanPostPagoMinutosMegasEconomico(
                        nombres, apellidos, pasaporte, barrio, marca,
                        modelo, numeroCelular);

                p.establecerMinutos(rs.getDouble("minutos"));
                p.establecerCostoMinutos(rs.getDouble("costoMinutos"));
                p.establecerMegas(rs.getDouble("megas"));
                p.establecerCostoGiga(rs.getDouble("costoGiga"));
                p.establecerDescuento(rs.getDouble("descuento"));

                lista.add(p);
            }

            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).establecerPagoMensual();
            }

            obtenerConexion().close();

        } catch (SQLException e) {
            System.out.println("Exception: establecerLista");
            System.out.println(e.getMessage());

        }

    }

    public ArrayList<PlanCelular> obtenerLista() {
        return lista;
    }

}

// @cbhas & @ALISrj
