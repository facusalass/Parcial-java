
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

## Implemente en la clase Inventario el método agregarAuto(Auto auto)

```java
public boolean agregarAuto(Auto auto) {
    // 1. Recorremos la lista para ver si la patente ya existe
    for (Auto a : autos) {
        // Usamos equals para comparar Strings (patentes)
        if (a.getPatente().equals(auto.getPatente())) {
            return false; // Ya existe, no agregamos nada
        }
    }

    // 2. Si terminó el bucle y no encontró duplicados, agregamos
    autos.add(auto);
    return true;
}


## Implemente una excepción que deberá lanzarse al intentar crear un objeto Auto con una cantidad de puertas menor a 3

```java
// 1. ARCHIVO: PuertasInsuficientesException.java
public class PuertasInsuficientesException extends Exception {

    public PuertasInsuficientesException(String mensaje) {
        super(mensaje);
    }

    public PuertasInsuficientesException() {
        super("Error: Un auto debe tener al menos 3 puertas.");
    }
}

// 2. ARCHIVO: Auto.java
class Auto extends Vehiculo {

    private int cantidadPuertas;

    public Auto(String marca, int modelo, String patente, int kilometraje, int cantidadPuertas) throws PuertasInsuficientesException {
        super(marca, modelo, patente, kilometraje);

        if (cantidadPuertas < 3) {
            throw new PuertasInsuficientesException();
        }

        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Puertas: " + cantidadPuertas;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Auto miAuto = new Auto("Ford", 2022, "AA123BB", 10000, 2);
            System.out.println("Auto creado con éxito");

        } catch (PuertasInsuficientesException e) {
            System.out.println(e.getMessage());
        }
    }
}

## Implementar los métodos para determinar si dos vehículos se consideran iguales únicamente si tienen la misma patente

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    
    if (o == null || !(o instanceof Vehiculo)) return false;
    
    Vehiculo otro = (Vehiculo) o;
    
    return this.patente.equals(otro.patente);
}

@Override
public int hashCode() {
    return java.util.Objects.hash(patente);
}

## Implemente en la clase Auto el método requerido por la interface correspondiente

```java
@Override
public double calcularPrecioFinal(double precioBase) {
    int anioActual = 2025;
    int aniosUso = anioActual - getModelo();
    
    if (aniosUso < 0) { 
        aniosUso = 0; 
    }

    // Primero bajamos el precio según la antigüedad
    double depreciacionTotal = aniosUso * 0.05;
    double precioDepreciado = precioBase - (precioBase * depreciacionTotal);

    double porcentajeAdicional = 0.0;
    
    if (cantPuertas == 3) {
        porcentajeAdicional = 0.30; // 30%
    } else if (cantPuertas == 4) {
        porcentajeAdicional = 0.40; // 40%
    } else {
        porcentajeAdicional = 0.35; // 35% para el resto
    }

   
    double precioFinal = precioDepreciado + (precioDepreciado * porcentajeAdicional);

    return (precioFinal > 0) ? precioFinal : 0;
}
