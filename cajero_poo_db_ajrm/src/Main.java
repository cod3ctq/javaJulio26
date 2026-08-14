import dto.CuentaDTO;
import exception.*;
import models.Atm;
import models.Ticket;
import service.impl.CajeroBasico;
import service.impl.PractiCaja;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //models.Atm a1 = new models.Atm();
        //a1.cargarCuentas();
        //a1.imprimirCuentas();
        //a1.consultarSaldo("5578123412340007");

        CajeroBasico cb = new CajeroBasico();
        PractiCaja pc = new PractiCaja();
        cb.setUbicacion("Avenida Torres #29");
        pc.setUbicacion("Plaza Mayor #28");


        int flujo = 0, continuar = 0;
        int seleccion = 0;
        double monto = 0.0;
        String convenio, referencia, dato, nip;
        CuentaDTO cuentaActual = null;
        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        try {
            imprimeLogo();
            Atm.imprimirCuentas();
            Atm.generarRetirosSinTarjeta();
            Atm.imprimirRetirosSinTarjeta();
            Atm.imprimirCacheServicios();
            System.out.println("[#####  CAJERO BBVA    #####]");
            System.out.println("1: IDENTIFICARSE");
            System.out.println("2: RETIRO SIN TARJETA");
            System.out.print("?: ");
            flujo = scan.nextInt();
            scan.nextLine();
            switch (flujo) {
                case 1:
                    System.out.println("INGRESA TU TARJETA");
                    dato = scan.nextLine();
                    cuentaActual = Atm.buscarCuenta(dato);
                    while (continuar < 2) {
                        System.out.println("1: - CONSULTAR SALDO");
                        System.out.println("2: - RETIRAR");
                        System.out.println("3: - DEPOSITAR");
                        System.out.println("4: - PAGO DE SERVICIOS");
                        System.out.println("?: ");
                        seleccion = scan.nextInt();
                        switch (seleccion) {
                            case 1:
                                cb.consultarSaldo(cuentaActual.getNumTarjeta());
                                break;
                            case 2:
                                System.out.println("INGRESA EL MONTO A RETIRAR");
                                monto = scan.nextDouble();
                                ticket = (Ticket) cb.retirar(cuentaActual, monto)[0];
                                System.out.println(ticket);
                                break;
                            case 3:
                                System.out.println("INGRESA EL MONTO A DEPOSITAR");
                                monto = scan.nextDouble();
                                ticket = pc.depositar(cuentaActual, monto);
                                System.out.println(ticket);
                                break;
                            case 4:
                                scan.nextLine();
                                System.out.println("INGRESA EL CONVENIO");
                                convenio = scan.nextLine();
                                System.out.println("INGRESA LA REFERENCIA");
                                referencia = scan.nextLine();
                                ticket = cb.pagarServicio(cuentaActual, convenio, referencia);
                                System.out.println(ticket);
                                break;
                        }
                        System.out.println("DESEA HACER OTRA OPERACION ?");
                        System.out.println("1 :SI");
                        System.out.println("2 :NO");
                        System.out.print("?: ");
                        continuar = scan.nextInt();
                    }
                    break;
                case 2:
                    do {
                        ticket = (Ticket) pc.cobrarRetiroSinTarjeta()[0];
                        System.out.println(ticket);
                        System.out.println("DESEA HACER OTRA OPERACION ?");
                        System.out.println("1 :SI");
                        System.out.println("2 :NO");
                        System.out.print("?: ");
                        continuar = scan.nextInt();
                    } while (continuar<2);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        //practicaja.imprimirCacheServicios();
//        // basico.imprimirCuentas();
//        //practicaja.imprimirCuentas();
//        basico.imprimirRetiroSinTarjeta();
//        basico.cobrarRetiroSinTarjeta();
//        models.Ticket tt = (models.Ticket) basico.cobrarRetiroSinTarjeta()[0];
//        System.out.println(tt);
//
//        double retirado = (double) basico.cobrarRetiroSinTarjeta()[1];
//        System.out.println("EFECTIVO; "+retirado);
//
//        Scanner scan = new Scanner(System.in);
//        try {
//            CuentaDTO objeto = basico.buscarCuenta("5578123412340006");
//            System.out.println("Saldo antes del pago ##### :"+objeto.getSaldo());
//            System.out.println("Ingresa el convenio ");
//            String convenio = scan.nextLine();
//            System.out.println("Ingresa la referencia");
//            String ref = scan.nextLine();
//            Ticket tps1 = basico.pagarServicio(objeto,convenio,ref);
//            System.out.println(tps1);
//            System.out.println("Saldo despues del pago ##### :"+
//                    basico.buscarCuenta("5578123412340006").getSaldo());
//
//
//
//            Object[] data = basico.retirar(objeto, 500);
//            Object[] data2 = basico.retirar(objeto, 500);
//            Object[] data3 = basico.retirar(objeto, 500);
//            Object[] data4 = basico.retirar(objeto, 500);
//
//            //System.out.println(data[0]);
//            System.out.println("Saldo despues de los retiros: " +
//                    basico.buscarCuenta("5578123412340006").getSaldo()); //89,200
//
//            //dto.CuentaDTO objeto = practicaja.buscarCuenta("5578123412340006");
//
//            Ticket t1 = practicaja.depositar(objeto,2000);
//            Ticket t2 = practicaja.depositar(objeto,1500);
//            Ticket t3 = practicaja.depositar(objeto,1500);
//            Ticket t4 = practicaja.depositar(objeto,1500);
//            Ticket t5 = practicaja.depositar(objeto,1500);
//
//            System.out.println("SALDO DESPUES DE LOS DEPOSITOS: "+
//                    practicaja.buscarCuenta("5578123412340006").getSaldo()); //97200
//
//        }catch (InvalidAmountException |
//                DailyWithdrawalLimitExceededException |
//                DailyAmountLimitReachedException |
//                InsufficientBalanceException |
//                MinimumBalanceReachedException
//                ex){
//            ex.printStackTrace();
//            //System.out.println(ex.getMessage());
//        }
    }

    static void imprimeLogo() throws Exception {
        String rutaImagen = "\"C:\\Users\\Yair\\Desktop\\eefa49d2-9230-4d15-bda3-17a9ac52cc00.jfif\"";
        BufferedImage imagen = ImageIO.read(new File(rutaImagen));
        int anchoFinal = 60;
        int altoFinal = (imagen.getHeight() * 30) / imagen.getWidth();
        String caracteres = "@%#*+=-:. ";
        for (int y = 0; y < altoFinal; y++) {
            StringBuilder linea = new StringBuilder();
            for (int x = 0; x < anchoFinal; x++) {
                int pixelX = x * imagen.getWidth() / anchoFinal;
                int pixelY = y * imagen.getHeight() / altoFinal;
                int rgb = imagen.getRGB(pixelX, pixelY);
                int rojo = (rgb >> 16) & 0xff;
                int verde = (rgb >> 8) & 0xff;
                int azul = rgb & 0xff;
                int gris = (rojo + verde + azul) / 3;
                int indice = gris * (caracteres.length() - 1) / 255;
                linea.append(caracteres.charAt(indice));
            }
            System.out.println(linea);
        }
    }
}

