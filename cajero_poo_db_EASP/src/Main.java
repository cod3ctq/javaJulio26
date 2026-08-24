import models.Atm;
import models.Ticket;
import dto.CuentaDTO;
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
//        Models.Atm a1 = new Models.Atm();
//        //a1.c
//        //
//        //        a1.consultarSaldo("5578123412340007");argarCuentas();
//        a1.imprimirCuentas();

        //Cajero basico
        CajeroBasico cb = new CajeroBasico();
        cb.setUbicacion("Avenida Torres #29");


//        basico.imprimirCuentas();
//        basico.imprimirRetirosSingTarjeta();
//        basico.imprimirCacheServicios();

//        Models.Ticket tt = (Models.Ticket) basico.cobrarRetiroSinTarjeta()[0];
//        System.out.println(tt);
//        double retirado = (double) basico.cobrarRetiroSinTarjeta()[1];
//        System.out.println("EFECTIVO: "+retirado);

        //Practicaja
        PractiCaja pc = new PractiCaja();
        pc.setUbicacion("Plaza Mayor #28");
//        practiCaja.imprimirCacheServicios();
//        practiCaja.imprimirCuentas();
//
//        Scanner scan = new Scanner(System.in);
//        try {
//            CuentaDTO objeto = basico.buscarCuenta("5578123412340004");
//
//            System.out.println("Saldo antes del pago #####: "+objeto.getSaldo());
//            System.out.println("Ingresa el convenio");
//            String convenio = scan.nextLine();
//            System.out.println("Ingresa la referencia");
//            String referencia = scan.nextLine();
//
//            Ticket tps1 = basico.pagarServicio(objeto, convenio, referencia);
//            System.out.println(tps1);
//            System.out.println("Saldo despues del pago #####: "+basico.buscarCuenta("5578123412340004").getSaldo());


//            Object[] data1 = basico.retirar(objeto, 500);
//            Object[] data2 = basico.retirar(objeto, 500);
//            Object[] data3 = basico.retirar(objeto, 500);
//            Object[] data4 = basico.retirar(objeto, 500);
//            Object[] data5 = basico.retirar(objeto, 200);
//            Object[] data6 = basico.retirar(objeto, 300);
//            Object[] data7 = basico.retirar(objeto, 100);
//            Object[] data8 = basico.retirar(objeto, 500);
//            Object[] data9 = basico.retirar(objeto, 4000);
//            Object[] data10 = basico.retirar(objeto, 200);
//            Object[] data11 = basico.retirar(objeto, 3000);
//            basico.imprimirCacheRetiros();
//            System.out.println("Saldo despues de depositos: "+ practiCaja.buscarCuenta("5578123412340004").getSaldo());
//            //System.out.println(data10[0]);
//        }catch(Exception ex){
        //ex.printStackTrace();
//            ex.printStackTrace();
//        }


//        try{
//            dto.CuentaDTO objeto2 = practiCaja.buscarCuenta("5578123412340004");
//            Models.Ticket t1 = practiCaja.depositar(objeto2, 200);
//            Models.Ticket t2 = practiCaja.depositar(objeto2, 150);
//            Models.Ticket t3 = practiCaja.depositar(objeto2, 150);
//            Models.Ticket t4 = practiCaja.depositar(objeto2, 150);
//            Models.Ticket t5 = practiCaja.depositar(objeto2, 150);
//            Models.Ticket t6 = practiCaja.depositar(objeto, 1500);
//            Models.Ticket t7 = practiCaja.depositar(objeto, 1500);
//            Models.Ticket t8 = practiCaja.depositar(objeto, 1500);
//            Models.Ticket t9 = practiCaja.depositar(objeto, 1500);
//            Models.Ticket t10 = practiCaja.depositar(objeto, 1500);

//            System.out.println("Saldo despues de depositos: "+ practiCaja.buscarCuenta("5578123412340004").getSaldo());
//            //System.out.println(t10);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

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

    }

    static void imprimeLogo() throws Exception {
        String rutaImagen = "C:\\Users\\cacho\\Desktop\\4900222798005996592.jpg";
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