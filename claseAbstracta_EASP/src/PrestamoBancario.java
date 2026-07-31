//Declaramos clase abstracta
public abstract class PrestamoBancario {

    String folio;
    double monto;
    int plazoMeses;
    double tazaInteres;
    double saldoPendiente;
    String beneficiario;

    public PrestamoBancario(){}

    public PrestamoBancario(String folio, double monto, int plazoMeses, double tazaInteres, double saldoPendiente, String beneficiario) {
        this.folio = folio;
        this.monto = monto;
        this.plazoMeses = plazoMeses;
        this.tazaInteres = tazaInteres;
        this.saldoPendiente = saldoPendiente;
        this.beneficiario = beneficiario;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public double getTazaInteres() {
        return tazaInteres;
    }

    public void setTazaInteres(double tazaInteres) {
        this.tazaInteres = tazaInteres;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    @Override
    public String toString() {
        return "PrestamoBancario{" +
                "folio='" + folio + '\'' +
                ", monto=" + monto +
                ", plazoMeses=" + plazoMeses +
                ", tazaInteres=" + tazaInteres +
                ", saldoPendiente=" + saldoPendiente +
                ", beneficiario='" + beneficiario + '\'' +
                '}';
    }

    //metodo nativo
    public void abonar(double monto){
        //Si el saldoPendiente ya es 0
        if (saldoPendiente<= 0){
            System.out.println("Prestamo liquidado");
        }else {
            saldoPendiente = saldoPendiente - monto;
            System.out.println("Abono registrado correctamente");
            System.out.println("Por pagar: "+saldoPendiente);
        }
    }

    //Metodos abstractos: Sin cuerpo
    public abstract double calcularMensualidad();
    public abstract double calcularInteres();



}
