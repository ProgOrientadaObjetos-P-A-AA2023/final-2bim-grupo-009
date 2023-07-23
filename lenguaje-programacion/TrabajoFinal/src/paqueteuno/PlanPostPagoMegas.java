package paqueteuno;

public class PlanPostPagoMegas extends PlanCelular {

    private double megasExpresadoGigas;
    private double costoCadaGiga;
    private double tarifaBase;

    public PlanPostPagoMegas(String n,
            String a, String p, String b, String m, String mo, String num){
        super(n, a, p, b, m, mo, num);
    }
    
    public PlanPostPagoMegas(double megas, double costoGiga, double t, String n,
            String a, String p, String b, String m, String mo, String num) {
        super(n, a, p, b, m, mo, num);
        megasExpresadoGigas = megas;
        costoCadaGiga = costoGiga;
        tarifaBase = t;
    }

    public void establecerMegasExpresadoGigas(double mEG) {
        megasExpresadoGigas = mEG;
    }

    public void establecerCostoCadaGiga(double cCG) {
        costoCadaGiga = cCG;
    }

    public void establecerTarifaBase(double tB) {
        tarifaBase = tB;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = tarifaBase + (costoCadaGiga * megasExpresadoGigas);
    }

    public double obtenerMegasExpresadoGigas() {
        return megasExpresadoGigas;
    }

    public double obtenerCostoCadaGiga() {
        return costoCadaGiga;
    }

    public double obtenerTarifaBase() {
        return tarifaBase;
    }

    @Override
    public String toString() {

        return String.format("%s"
                + "Megas Expresado en Gigas: %.2f\n"
                + "Costo de Cada Giga: %.2f\n"
                + "Tarifa Base: %.2f\n"
                + "Pago Mensuak: %.2f\n",
                super.toString(),
                megasExpresadoGigas,
                costoCadaGiga,
                tarifaBase,
                pagoMensual);
    }

}
