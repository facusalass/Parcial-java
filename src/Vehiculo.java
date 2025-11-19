import java.util.Objects;


public abstract class Vehiculo implements Mantenible {

    private String marca;
    private int modelo;
    private String patente;
    private int tipo;
    private int kilometraje;

    public Vehiculo(String marca, int modelo, String patente, int tipo, int kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente.toUpperCase();
        this.tipo = tipo;
        this.kilometraje = kilometraje;
    }
    public String getPatente() { return patente; }
    public int getKilometraje() { return kilometraje; }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(patente, vehiculo.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente);
    }

    @Override
    public String toString() {
        return "Patente: " + patente + "  Marca: " + marca + "  Km: " + kilometraje;
    }


}