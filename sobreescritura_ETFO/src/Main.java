public class Main {
    public static void main(String[] args) {
        //Objeto de la clase padre
        Celular c1 = new  Celular("Nokia","1100",1000.00);
        //Objeto de la clase clase hija (Con composicion)
        String [] aplicaciones = {"iMessage", "Apple Music", "Telefono", "Telegram", "Whatsapp", "Tiktok", "Youtube"};
        Smartphone sp = new Smartphone("Apple", "iPhone 14 Pro Max",30000 ,"iOS", aplicaciones);
        //Invocar los metodos desde un objeto de la clase padre y tambien desde un objeto de la clase hija
        c1.llamar("9531009231");
        c1.mandarMensaje("5567894321", "Hola desde mi nokia");

        sp.llamar("8796054321");
        sp.mandarMensaje("5567869065", "Hola desde mi " + sp.getModelo());
    }
}