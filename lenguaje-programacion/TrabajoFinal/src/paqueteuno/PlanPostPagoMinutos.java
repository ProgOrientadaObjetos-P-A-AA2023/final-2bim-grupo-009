package paqueteuno;

public class PlanPostPagoMinutos extends PlanCelular {

    private double minutosNacionales;
    private double costoMinutoNacional;
    private double minutosInternacionales;
    private double costoMinutoInternacional;

    public PlanPostPagoMinutos(String n,
            String a, String p, String b, String m, String mo, String num) {
        super(n, a, p, b, m, mo, num);
    }

    public PlanPostPagoMinutos(double minN, double costoMinN, double minI,
            double costoMinI, String n, String a, String p, String b,
            String m, String mo, String num) {
        super(n, a, p, b, m, mo, num);
        minutosNacionales = minN;
        costoMinutoNacional = costoMinN;
        minutosInternacionales = minI;
        costoMinutoInternacional = costoMinI;
    }

    public void establecerMinutosNacionales(double mN) {
        minutosNacionales = mN;
    }

    public void establecerCostoMinutoNacional(double cMN) {
        costoMinutoNacional = cMN;
    }

    public void establecerMinutosInternacionales(double mI) {
        minutosInternacionales = mI;
    }

    public void establecerCostoMinutoInternacional(double cMI) {
        costoMinutoInternacional = cMI;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = (costoMinutoNacional * minutosNacionales) + 
                (costoMinutoInternacional * minutosInternacionales);
    }

    public double obtenerMinutosNacionales() {
        return minutosNacionales;
    }

    public double obtenerCostoMinutoNacional() {
        return costoMinutoNacional;
    }

    public double obtenerMinutosInternacionales() {
        return minutosInternacionales;
    }

    public double obtenerCostoMinutoInternacional() {
        return costoMinutoInternacional;
    }

    @Override
    public String toString() {

        return String.format("%s"
                + "     Minutos Nacionales: %.2f\n"
                + "     Costo Minuto Nacional: $%.2f\n"
                + "     Minutos Internacionales: %.2f\n"
                + "     Costo Minuto Internacional: $%.2f\n"
                + "     Pago Mensual: $%.2f\n",
                super.toString(),
                minutosNacionales,
                costoMinutoNacional,
                minutosInternacionales,
                costoMinutoInternacional,
                pagoMensual);
    }

}

// @cbhas & @ALISrj
