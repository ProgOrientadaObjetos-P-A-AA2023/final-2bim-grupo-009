package paquetedos;

import java.util.Locale;
import java.util.Scanner;
import paquetetres.Enlace;
import paqueteuno.*;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

        boolean bandera = true;

        Enlace c = new Enlace();

        while (bandera) {

            System.out.print("Ingrese '1' para ingresar ingresar un Plan de tipo "
                    + "PostPagoMinutosMegasEconomico\n"
                    + "Ingrese '2' para ingresar un Plan de tipo PostPagoMinutos\n"
                    + "Ingrese '3' para ingresar un Plan de tipo PostPagoMegas\n"
                    + "Ingrese '4' para ingresar un Plan de tipo PostPagoMinutosMegas\n> ");

            String opcion = entrada.nextLine();

            if ("1".equals(opcion) || "2".equals(opcion) || "3".equals(opcion) || "4".equals(opcion)) {

                System.out.print("Ingrese los nombres.\n> ");
                String nombres = entrada.nextLine();
                System.out.print("Ingrese los apellidos.\n> ");
                String apellidos = entrada.nextLine();
                System.out.print("Ingrese el pasaporte.\n> ");
                String pasaporte = entrada.nextLine();
                System.out.print("Ingrese el barrio.\n> ");
                String barrio = entrada.nextLine();
                System.out.print("Ingrese la marca.\n> ");
                String marca = entrada.nextLine();
                System.out.print("Ingrese el modelo\n> ");
                String modelo = entrada.nextLine();
                System.out.print("Ingrese el número de celular.\n> ");
                String numero = entrada.nextLine();

                if (opcion.equals("1")) {
                    PlanPostPagoMinutosMegasEconomico p = new PlanPostPagoMinutosMegasEconomico(nombres, apellidos, pasaporte, barrio, marca, modelo, numero);

                    System.out.print("Ingrese el número de minutos.\n> ");
                    double minutos = entrada.nextDouble();
                    System.out.print("Ingrese el costo de cada minuto.\n> ");
                    double costoMinutos = entrada.nextDouble();
                    System.out.print("Ingrese el número de megas expresado en Gigas.\n> ");
                    double megas = entrada.nextDouble();
                    System.out.print("Ingrese el costo de cada Giga.\n> ");
                    double costoGiga = entrada.nextDouble();
                    System.out.print("Ingrese el descuento.\n> ");
                    double descuento = entrada.nextDouble();
                    entrada.nextLine();
                    p.establecerMinutos(minutos);
                    p.establecerCostoMinutos(costoMinutos);
                    p.establecerMegas(megas);
                    p.establecerCostoGiga(costoGiga);
                    p.establecerDescuento(descuento);
                    c.insertarPlanPostPagoMinutosMegasEconomico(p);

                } else if (opcion.equals("2")) {

                    PlanPostPagoMinutos p = new PlanPostPagoMinutos(nombres, apellidos, pasaporte, barrio, marca, modelo, numero);

                    System.out.print("Ingrese el número de minutos nacionales.\n> ");
                    double minutosN = entrada.nextDouble();
                    System.out.print("Ingrese el costo de cada minuto nacional .\n> ");
                    double costoMinutosN = entrada.nextDouble();
                    System.out.print("Ingrese el número de mintos internacionales.\n> ");
                    double minutosI = entrada.nextDouble();
                    System.out.print("Ingrese el costo de minuto internacional.\n> ");
                    double costoMinutosI = entrada.nextDouble();
                    entrada.nextLine();
                    p.establecerMinutosNacionales(minutosN);
                    p.establecerCostoMinutoNacional(costoMinutosN);
                    p.establecerMinutosInternacionales(minutosI);
                    p.establecerCostoMinutoInternacional(costoMinutosI);
                    c.insertarPlanPostPagoMinutos(p);

                } else if (opcion.equals("3")) {
                    PlanPostPagoMegas p = new PlanPostPagoMegas(nombres, apellidos, pasaporte, barrio, marca, modelo, numero);

                    System.out.print("Ingrese el número de megas expresado en Gigas.\n> ");
                    double megas = entrada.nextDouble();
                    System.out.print("Ingrese el costo de cada Giga.\n> ");
                    double costoGiga = entrada.nextDouble();
                    System.out.print("Ingrese la tarifa base.\n> ");
                    double tarifa = entrada.nextDouble();
                    entrada.nextLine();
                    p.establecerMegasExpresadoGigas(megas);
                    p.establecerCostoCadaGiga(costoGiga);
                    p.establecerTarifaBase(tarifa);
                    c.insertarPlanPostPagoMegas(p);

                } else if (opcion.equals("4")) {

                    PlanPostPagoMinutosMegas p = new PlanPostPagoMinutosMegas(nombres, apellidos, pasaporte, barrio, marca, modelo, numero);

                    System.out.print("Ingrese el número de minutos.\n> ");
                    double minutos = entrada.nextDouble();
                    System.out.print("Ingrese el costo de cada minuto.\n> ");
                    double costoMinutos = entrada.nextDouble();
                    System.out.print("Ingrese el número de megas expresado en Gigas.\n> ");
                    double megas = entrada.nextDouble();
                    System.out.print("Ingrese el costo de cada Giga.\n> ");
                    double costoGiga = entrada.nextDouble();
                    entrada.nextLine();
                    p.establecerMinutos(minutos);
                    p.establecerCostoMinutos(costoMinutos);
                    p.establecerMegas(megas);
                    p.establecerCostoGiga(costoGiga);
                    c.insertarPlanPostPagoMinutosMegas(p);
                }

            } else {
                System.out.println("\nOpcion Incorrecta");
            }

            System.out.print("\nDesea salir del proceso, ingrese 'si'\n> ");
            String salida = entrada.nextLine();
            if (salida.equals("si")) {
                bandera = false;
            }
            System.out.println("");

        }

        c.establecerListaPlanCelular();
        for (int i = 0; i < c.obtenerLista().size(); i++) {
            System.out.printf("%s\n", c.obtenerLista().get(i));
        }

    }

}
