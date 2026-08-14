//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import dto.CuentaDTO;
import exception.*;
import service.impl.CajeroBasico;
import service.impl.Practicaja;
import models.Ticket;
import models.Atm;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CajeroBasico cb = new CajeroBasico();
        Practicaja pc = new Practicaja();
        cb.setUbicacion("Avenida Torres #29");
        pc.setUbicacion("plaza MAYOR #28");

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



//        basico.imprimirCacheServicios();
////        practicaja2.imprimirCuentas();
////111
////        basico.imprimirRetirosSinTarjeta();
////        models.Ticket tt= (models.Ticket) basico.cobrarRetiroSinTarjeta()[0];
////        System.out.println(tt);
////        double retirado= (double) basico.cobrarRetiroSinTarjeta()[1];
////        System.out.println("EFECTIVO " +retirado);
//
////        dto.CuentaDTO objeto = new dto.CuentaDTO(9,8,3,"1000000009",
////                "002180000000000009",64480.0, new Date(),'1',
////                "5578123412340008",
////                1000.0, 500000.0);
////
////        basico.retirar(objeto,64481);
//        Scanner scan=new Scanner(System.in);
//        try {
//            CuentaDTO objeto = basico.buscarCuenta("5578123412340004");
//            System.out.println("saldo antes del pago ####:"+objeto.getSaldo());
//            System.out.println("ingresa el convenio");
//            String convenio=scan.nextLine();
//            System.out.println("ingresa la referncia");
//            String ref=scan.nextLine();
//            Ticket tps1=basico.pagarServicio(objeto,convenio,ref);
//            System.out.println(tps1);
//            System.out.println("Saldo despues del pago #####:"+basico.buscarCuenta("5578123412340004")
//                    .getSaldo());
////            Object[] data=basico.retirar(objeto, 50000); //59480
////            Object[] data2=basico.retirar(objeto, 500);
////            Object[] data3=basico.retirar(objeto, 500);
////            Object[] data4=basico.retirar(objeto, 500);
//////            Object[] data5=basico.retirar(objeto, 100);
//////            Object[] data6=basico.retirar(objeto, 100);
////            System.out.println(data[0]);
////            //basico.imprimirCacheRetros();
////            System.out.println("Saldo despues de retiros: >>>>>>>>"+basico.buscarCuenta("5578123412340004"));
//
//
//////            dto.CuentaDTO objeto = practicaja.buscarCuenta("5578123412340004");
////            models.Ticket t1 = practicaja.depositar(objeto, 2000);
////            models.Ticket t2 = practicaja.depositar(objeto, 1500);
////            models.Ticket t3 = practicaja.depositar(objeto, 1500);
////            models.Ticket t4 = practicaja.depositar(objeto, 1500);
////            models.Ticket t5 = practicaja.depositar(objeto, 1500);
////            System.out.println("Saldo despues de los depositos: <<<<<<<<" + practicaja.buscarCuenta("5578123412340008").getSaldo());
////
////        } catch (exception.BusinessException ex) {
////            ex.printStackTrace();
//
//        }catch (InvalidAmountException | DailyWithdrawalLimitExceededException |
//                DailyAmountLimitReachedException | InsufficientBalanceException |
//                MinimumBalanceReachedException | BusinessException ex) {
//        ex.printStackTrace();
//            //Ya no imprime la traza completa
//            //System.out.println(ex.getMessage());
//        }

    }

    static void imprimeLogo() throws Exception {
        String rutaImagen = "C:\\Users\\PC\\Desktop\\photo_4900222798005996592_y.jpg";
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
