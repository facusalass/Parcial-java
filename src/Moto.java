public class Moto extends Vehiculo {

    public Moto(String marca, int modelo, String patente, int kilometraje) {
        super(marca, modelo, patente, 2, kilometraje);
    }

    @Override
    public double calcularCostoMantenimiento() {
        return 2000 + (getKilometraje() * 5);
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo: Moto";
    }
}