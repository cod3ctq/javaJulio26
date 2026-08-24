import exception.*;
import dto.CuentaDTO;
import model.Atm;
import model.Ticket;
import service.impl.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //model.Atm a1 = new model.Atm(); Constructor vacio modificado
        //a1.cargarCuentas();
        //a1.imprimirCuentas();
        //Momento 2
        /*try {
            System.out.println("entity.Cuenta buscada: " + a1.buscarCuenta("5578123412340004"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
        //a1.consultarSaldo("5578123412340007");

        CajeroBasico cb = new CajeroBasico();
        PractiCaja pc = new service.impl.PractiCaja();
        pc.setUbicacion("Plaza mayor #28");
        cb.setUbicacion("Avenida Torres #29");

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
            Atm.generarRetiroSinTarjeta();
            Atm.imprimirRetirosSinTarjeta();
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
                        ticket = (Ticket) pc.cobrarRetirosSinTarjeta()[0];
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


        //basico.imprimirCacheServicios();
        //basico.imprimirCuentas();
        //System.out.println(practicaja.cuentas.stream().mapToDouble(dto.CuentaDTO::getSaldo).sum());
        //basico.imprimirRetirosSinTarjeta();
//        basico.imprimirRetirosSinTarjeta();
//        model.Ticket tt = (model.Ticket) basico.cobrarRetirosSinTarjeta()[0]; // castear
//        System.out.println(tt);
//        double ttt = (double) basico.cobrarRetirosSinTarjeta()[1]; // castear
//        System.out.println(ttt);
        /*try {
            CuentaDTO objeto = basico.buscarCuenta("5578123412340006");
            System.out.println("Saldo antes del pago: " + objeto.getSaldo());
            System.out.println("Ingresa el convenio: ");
            String conv = sc.nextLine();
            System.out.println("Ingresa la referencia: ");
            String ref = sc.nextLine();
            Ticket tps1 = basico.pagarServicio(objeto, conv, ref);
            System.out.println(tps1);
            System.out.println("Saldo despues del pago#######: " + basico.buscarCuenta("5578123412340006").getSaldo());
            //dto.CuentaDTO objeto = practicaja.buscarCuenta("5578123412340004");
            //dto.CuentaDTO objeto = basico.buscarCuenta("5578123412340003");
//            Object[] data = basico.retirar(objeto, 500);
//            Object[] data2 = basico.retirar(objeto, 500);
//            Object[] data3 = basico.retirar(objeto, 500);
//            Object[] data4 = basico.retirar(objeto, 500);
//            System.out.println("Saldo depositado despues de los retiros: " + practicaja.buscarCuenta("5578123412340006").getSaldo()); //96800.9
//            model.Ticket t1 = practicaja.depositar(objeto, 2000);
//            model.Ticket t2 = practicaja.depositar(objeto, 1500);
//            model.Ticket t3 = practicaja.depositar(objeto, 1500);
//            model.Ticket t4 = practicaja.depositar(objeto, 1500);
//            model.Ticket t5 = practicaja.depositar(objeto, 1500);
            Object[] data5 = basico.retirar(objeto, 5000); // 39480
            Object[] data6 = basico.retirar(objeto, 5000); // 34480
            Object[] data7 = basico.retirar(objeto, 5000); // 29480
            Object[] data8 = basico.retirar(objeto, 5000); // 24480
            Object[] data9 = basico.retirar(objeto, 5000); // 19480
            Object[] data10 = basico.retirar(objeto, 5000); // 14480
            Object[] data11 = basico.retirar(objeto, 5000); // 9480 Este ya no debe permitirlo
            Object[] data = basico.retirar(objeto, 5000); // 59480
            Object[] data2 = basico.retirar(objeto, 3000); // 54480
            Object[] data3 = basico.retirar(objeto, 5000); // 49480
            Object[] data4 = basico.retirar(objeto, 6000); // 44480
            //Object[] data5 = basico.retirar(objeto, 1000); // 44480
            //Object[] data5 = basico.retirar(objeto, 2000); // 39480
            //Object[] data6 = basico.retirar(objeto, 3000); // 39480
            //Object[] data1 = basico.retirar(objeto, 87900);
//            Object[] data2 = basico.retirar(objeto, 7000);
//            Object[] data3 = basico.retirar(objeto, 2000);
            //basico.imprimirCacheRetiro();
            //System.out.println("Saldo despues de retiros: " + basico.buscarCuenta("5578123412340006").getSaldo());
            //System.out.println(data3[0]);
            //System.out.println("Saldo despues de los depositos " + practicaja.buscarCuenta("5578123412340004").getSaldo());
            //System.out.println(data1[0]);
            //System.out.println("Saldo depositado despues de los depositos: " + practicaja.buscarCuenta("5578123412340006").getSaldo()); //104800.9
        } catch
        (
                InvalidAmountException |
                DailyWithdrawalLimitExceededException |
                DailyAmountLimitReachedException |
                InsufficientBalanceException |
                MinimumBalanceReachedException |
                BusinessException ex
        ) {
            //ex.printStackTrace();
            System.out.println(ex.getMessage());
        }*/

    }
    static void imprimeLogo() throws Exception {
        String rutaImagen = "C:\\Users\\edtom\\Documents\\CETEQ\\img\\photo_2026-08-14_12-21-56.jpg";
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