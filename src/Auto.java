public class Auto extends Vehiculo {

    private int cantPuertas;

    public Auto(String marca, int modelo, String patente, int kilometraje, int cantPuertas) {
        super(marca, modelo, patente, 1, kilometraje);

        this.cantPuertas = cantPuertas;
    }

    @Override
    public double calcularCostoMantenimiento() {
        return 5000 + (getKilometraje() * 10);
    }

    @Override
    public String toString() {
        return super.toString() + " | Puertas: " + cantPuertas;
    }
}