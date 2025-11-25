
## En la clase Computadora, implementar los métodos para asegurar que dos computadoras sean consideradas iguales únicamente si tienen el mismo número de serie

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof Computadora)) return false;
    Computadora otra = (Computadora) o;
    return this.numeroSerie.equals(otra.numeroSerie);
}
````

## Implemente el método buscarComputadora(String numeroSerie) en la clase InventarioComputadoras

```java
public Computadora buscarComputadora(String numeroSerie) {
    for (Escritorio e : escritorios) {
        if (e.getNumeroSerie().equals(numeroSerie)) {
            return e; // Retornamos el objeto encontrado
        }
    }
    for (Laptop l : laptops) {
        // Usamos el getter del objeto 'l'
        if (l.getNumeroSerie().equals(numeroSerie)) {
            return l; // Retornamos el objeto encontrado
        }
    }
    return null;
}
```

## ¿Qué hace el método void close ( ) de la Clase BufferedWriter?

Cierra el flujo de escritura y cierra el archivo.

## ¿Qué hace el método void flush ( ) de la Clase BufferedWriter?

Forzar el volcado de los datos del buffer al archivo físico.

## Implemente en la clase Laptop el método requerido por la interface correspondiente

```java
@Override
public double calcularPrecioFinal(double precioBase) {
    int anioActual = 2025;
    int aniosUso = anioActual - getModelo();

    if (aniosUso < 0) {
        aniosUso = 0;
    }

    double montoDepreciacion = precioBase * (aniosUso * 0.12);
    double montoPortabilidad = precioBase * 0.15;
    double precioFinal = precioBase - montoDepreciacion - montoPortabilidad;

    return (precioFinal > 0) ? precioFinal : 0;
}
```

## Implemente una excepción que deberá lanzarse al intentar crear un objeto de tipo Escritorio que posea menos de 5 puertos disponibles

```java
// 1. ARCHIVO: PuertosInsuficientesException.java
public class PuertosInsuficientesException extends Exception {

    public PuertosInsuficientesException(String mensaje) {
        super(mensaje);
    }

    public PuertosInsuficientesException() {
        super("Error: Un escritorio debe tener al menos 5 puertos disponibles.");
    }
}

// 2. ARCHIVO: Escritorio.java
class Escritorio extends Computadora {

    private int cantidadPuertos;

    public Escritorio(String marca, int modelo, String numeroSerie, int horasUso, int cantidadPuertos) throws PuertosInsuficientesException {
        super(marca, modelo, numeroSerie, horasUso);

        if (cantidadPuertos < 5) {
            throw new PuertosInsuficientesException();
        }

        this.cantidadPuertos = cantidadPuertos;
    }

    @Override
    public String verTipoDeComputadora() {
        return "Escritorio";
    }
}

// 3. ARCHIVO: Main.java
public class Main {
    public static void main(String[] args) {
        try {
            Escritorio miPc = new Escritorio("Dell", 2024, "SN123", 10, 2);
            System.out.println("Escritorio creado con éxito");

        } catch (PuertosInsuficientesException e) {
            System.out.println(e.getMessage());
        }
    }
}
