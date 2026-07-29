public class Main_Hoodie {

    public static void main(String[] args) {

        Hoodie h1 = new Hoodie();
        Hoodie h2 = new Hoodie(800,"Negro", "Grande", true, "Caballero", "C&A");

        System.out.println(h1);


        h1.setPrecio(750);
        h1.setColor("Gris");
        h1.setTalla("Chica");
        h1.setSexo("Dama");
        h1.setMarca("Liverpool");
        h1.setEstampado(true);
        System.out.println(h1);
    }
}
