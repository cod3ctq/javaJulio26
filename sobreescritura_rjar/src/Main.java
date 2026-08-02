//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Objeto de clase padre
        Celular c1= new Celular("Nokia", "1100",1000.00);

        //Objeto de clase hija (con composicio)
        String[] apps={"Telefono", "whatsapp","Telegram","Messenger","Tiktok","YouTube"};

        Smartphones sm = new Smartphones("Apple","iPhone 14PM",30000.00,"iOs",apps);

    //Invocar los metodos desde un obeto de la clase padre
        //y tambien desde un objeto de la clase hija

        c1.llamar("1234567890");
        c1.mandarMensaje("0987654321","Hola desde mi nokia");

        sm.llamar("5678904321");
        sm.mandarMensaje("0987612345","Hola desde el iphone");



    }
}