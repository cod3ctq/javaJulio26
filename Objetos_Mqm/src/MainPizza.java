public class MainPizza {
    public static void main(String[] args) {

        Pizza p1 = new Pizza();
        Pizza p2 =new Pizza("Chica","Cuadrada",2,250.00);

        System.out.println(p1);
        System.out.println(p2);

        p1.setTamaño("Mediana");
        p1.setForma("Rectangular");
        p1.setNumIngredientes(4);
        p1.setPrecio(400.00);
        System.out.println(p1);

        System.out.println(p2.getForma());
        System.out.println(p2.getPrecio());

        System.out.println(p1.getForma());
        System.out.println(p1.getPrecio());

    }
}
