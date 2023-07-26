package paqueteuno;

public class PlanPostPagoMinutosMegasEconomico extends PlanCelular {

    private double minutos;
    private double costoMinutos;
    private double megas;
    private double costoGiga;
    private double descuento;

    public PlanPostPagoMinutosMegasEconomico(String n,
            String a, String p, String b, String m, String mo, String num) {
        super(n, a, p, b, m, mo, num);
    }

    public PlanPostPagoMinutosMegasEconomico(double min, double costoMin,
            double meg, double costoG, double d, String n, String a, String p,
            String b, String m, String mo, String num) {

        super(n, a, p, b, m, mo, num);
        minutos = min;
        costoMinutos = costoMin;
        megas = meg;
        costoGiga = costoG;
        descuento = d;
    }

    public void establecerMinutos(double n) {
        minutos = n;
    }

    public void establecerCostoMinutos(double n) {
        costoMinutos = n;
    }

    public void establecerMegas(double n) {
        megas = n;
    }

    public void establecerCostoGiga(double n) {
        costoGiga = n;
    }

    public void establecerDescuento(double n) {
        descuento = n;
    }

    @Override
    public void establecerPagoMensual() {
        double valorSinDescuento = (minutos * costoMinutos) + (megas * costoGiga);
        pagoMensual = valorSinDescuento - ((valorSinDescuento * descuento) / 100);
    }

    public double obtenerMinutos() {
        return minutos;
    }

    public double obtenerCostoMinutos() {
        return costoMinutos;
    }

    public double obtenerMegas() {
        return megas;
    }

    public double obtenerCostoGiga() {
        return costoGiga;
    }

    public double obtenerDescuento() {
        return descuento;
    }

    @Override
    public String toString() {

        return String.format("%s"
                + "     Minutos: %.2f\n"
                + "     Costo Minutos: $%.2f\n"
                + "     Megas Expresado en Gigas: %.2f GB\n"
                + "     Costo Cada Giga: $%.2f x 1 GB\n"
                + "     Descuento: %.2f\n"
                + "     Pago Mensual: $%.2f\n",
                super.toString(),
                minutos,
                costoMinutos,
                megas,
                costoGiga,
                descuento,
                pagoMensual);
    }

}

// @cbhas & @ALISrj
