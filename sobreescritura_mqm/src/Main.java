//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //objeto de clase padre
        Celular c1 = new Celular("Nokia","1100",1000.00);

        //objeto de clase hija con composicion
        String[] apps= {"telefono","whatsapp","telegram","Messenger","tiktok","youtube"};
        Smartphone sm = new Smartphone("Apple","iPhone 14PM",
                3000.00,"iOs",apps);

        //invocar los metodos desde un objeto de la clase padre
        //y tambien desde un objeto de la clase hija
        c1.llamar("1234567890");
        c1.mandarMensaje("9874563210","Hola desde mi Nokia");

        sm.llamar("6541230987");
        sm.mandarMensaje("0321654987","Hola desde mi iphone");
    }
}