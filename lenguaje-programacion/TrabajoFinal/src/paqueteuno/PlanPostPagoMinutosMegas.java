package paqueteuno;

public class PlanPostPagoMinutosMegas extends PlanCelular {

    private double minutos;
    private double costoMinutos;
    private double megas;
    private double costoGiga;

    public PlanPostPagoMinutosMegas(String n,
            String a, String p, String b, String m, String mo, String num) {
        super(n, a, p, b, m, mo, num);
    }

    public PlanPostPagoMinutosMegas(double min, double costoMin,
            double meg, double costoG, String n, String a, String p,
            String b, String m, String mo, String num) {

        super(n, a, p, b, m, mo, num);
        minutos = min;
        costoMinutos = costoMin;
        megas = meg;
        costoGiga = costoG;
    }

    public void establecerMinutos(double m) {
        minutos = m;
    }

    public void establecerCostoMinutos(double cM) {
        costoMinutos = cM;
    }

    public void establecerMegas(double mEG) {
        megas = mEG;
    }

    public void establecerCostoGiga(double cCG) {
        costoGiga = cCG;
    }

    @Override
    public void establecerPagoMensual() {

        pagoMensual = (minutos * costoMinutos) + (megas * costoGiga);

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

    @Override
    public String toString() {

        return String.format("%s"
                + "     Minutos: %.2f\n"
                + "     Costo Minutos: $%.2f\n"
                + "     Megas Expresado en Gigas: %.2f GB\n"
                + "     Costo Cada Giga: $%.2f x 1 GB\n"
                + "     Pago Mensual: $%.2f\n",
                super.toString(),
                minutos,
                costoMinutos,
                megas,
                costoGiga,
                pagoMensual);
    }

}

// @cbhas & @ALISrj
