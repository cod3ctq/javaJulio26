public class Main {
    public static void main(String[] args) {

        //Objeto de clase padre
        Celular c1= new Celular("Nokia", "1100", 1000.00);

        String[] apps = {"Telefono", "Whatsapp", "Telegram", "Messenger", "Tiktok", "YouTube"};
        //Objeto de clase hija (con composicion)
        Smartphone sm1= new Smartphone("Apple", "iPhone 14PM", 30000, "iOs", apps);

        //Invocar los metodos desde un objeto de la clase padre
        //Y ademas desde un objeto de la clase hija

        c1.llamar("1234567890");
        c1.mandarMensaje("0987654321", "Hola desde mi Nokia");

        sm1.llamar("5678901234"); //Sobreescrito de la clase padre
        sm1.mandarMensaje("5432109876", "Hola desde el iphone"); //Heredados de la clase padre





    }
}