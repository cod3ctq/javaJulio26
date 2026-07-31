public class Main {
    public static void main(String[] args) {

        Celular c1 = new Celular("Nokia","1100",1000.00);


        String[] apps = {"Telefono","Whatsapp","Telegram","Messenger",
        "Tiktok","Youtube"};

        Smartphone sm = new Smartphone("Apple","iPhone 14 PM", 30000.00,
                "iOs",apps);

        /*Invocar los metodos desde un objeto de la clase padre
        y tambien desde una objeto de la clase hija
         */

        c1.llamar("123456789");
        c1.mandarMensaje("987456321","Hola desde mi nokia");

        sm.llamar("123456789");
        sm.mandarMensaje("987456321","Hola desde mi iphone");









    }
}