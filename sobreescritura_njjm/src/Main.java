//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Objeto clase padre
        Celular c1 = new Celular("Nokia","1100",1000.00);

        //Objeto clase hija (con compposición)
        String[] apps = {"Teléfono","WhatsApp","Telegram","Messenger","TikTok","Youtube"};
        Smartphone sm = new Smartphone("Apple","iPhone 14PM",30000.00,"iOS",apps);

        //Invocar los métodos desde un objeto de la clase padre y también desde un objeto de la clase hija

        c1.llamar("222 578 5410");
        c1.mandarMensaje("222 578 5410","Hola desde mi Nokia");

        sm.llamar("222 578 5411");
        sm.mandarMensaje("2225 5785411","Hola desde mi iPhone");

    }
}