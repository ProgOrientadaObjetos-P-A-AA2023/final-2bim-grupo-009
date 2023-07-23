package paqueteuno;

public abstract class PlanCelular {

    protected String nombres;
    protected String apellidos;
    protected String pasaporte;
    protected String barrio;
    protected String marca;
    protected String modelo;
    protected String numeroCelular;
    protected double pagoMensual;

    public PlanCelular(String n, String a, String p, String b, String m, String mo, String num) {
        nombres = n;
        apellidos = a;
        pasaporte = p;
        barrio = b;
        marca = m;
        modelo = mo;
        numeroCelular = num;
    }

    // Establecer
    public void establecerNombres(String n) {
        nombres = n;
    }

    public void establecerApellidos(String n) {
        apellidos = n;
    }

    public void establecerPasaporte(String n) {
        pasaporte = n;
    }

    public void establecerBarrio(String n) {
        barrio = n;
    }

    public void establecerMarca(String n) {
        marca = n;
    }

    public void establecerModelo(String n) {
        modelo = n;
    }

    public void establecerNumeroCelular(String n) {
        numeroCelular = n;
    }

    public abstract void establecerPagoMensual();

    // Obtener
    public String obtenerNombres() {
        return nombres;
    }

    public String obtenerApellidos() {
        return apellidos;
    }

    public String obtenerPasaporte() {
        return pasaporte;
    }

    public String obtenerBarrio() {
        return barrio;
    }

    public String obtenerMarca() {
        return marca;
    }

    public String obtenerModelo() {
        return modelo;
    }

    public String obtenerNumeroCelular() {
        return numeroCelular;
    }

    public double obtenerPagoMensual() {
        return pagoMensual;
    }

    @Override
    public String toString() {

        return String.format("Nombres: %s\n"
                + "Apellidos: %s\n"
                + "Pasaporte: %s\n"
                + "Barrio: %s\n"
                + "Marca: %s\n"
                + "Modelo: %s\n"
                + "Número de celular: %s\n", nombres,
                apellidos, pasaporte, barrio,
                marca, modelo, numeroCelular);

    }

}
