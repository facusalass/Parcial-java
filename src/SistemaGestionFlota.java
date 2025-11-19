import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestionFlota {

    static ArrayList<Vehiculo> flota = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n--- GESTION DE FLOTA ---");
            System.out.println("1. Crear Vehículo");
            System.out.println("2. Listar Vehículos");
            System.out.println("3. Buscar Vehículo ");
            System.out.println("4. Eliminar Vehículo ");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: crearVehiculo(); break;
                case 2: listarVehiculos(); break;
                case 3: buscarVehiculo(); break;
                case 4: eliminarVehiculo(); break;
                case 5: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    public static void crearVehiculo() {
        try {
            System.out.println("\n--- NUEVO VEHÍCULO ---");

            System.out.print("Patente (6-7 caracteres): ");
            String patente = sc.nextLine();

            if (patente.length() < 6 || patente.length() > 7) {
                throw new PatenteInvalidaException("Largo de patente incorrecto.");
            }
            if (patente.contains(" ")) {
                throw new PatenteInvalidaException("La patente no puede tener espacios.");
            }

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Modelo (Año): ");
            int modelo = sc.nextInt();

            System.out.print("Kilometraje: ");
            int km = sc.nextInt();

            System.out.print("Tipo (1-Auto, 2-Moto): ");
            int tipo = sc.nextInt();

            Vehiculo nuevoVehiculo = null;

            if (tipo == 1) {
                System.out.print("Cantidad de Puertas: ");
                int puertas = sc.nextInt();
                nuevoVehiculo = new Auto(marca, modelo, patente, km, puertas);
            } else if (tipo == 2) {
                nuevoVehiculo = new Moto(marca, modelo, patente, km);
            } else {
                System.out.println("Tipo incorrecto.");
                return;
            }

            if (flota.contains(nuevoVehiculo)) {
                System.out.println("¡ERROR! Ya existe esa patente.");
            } else {
                flota.add(nuevoVehiculo);
                System.out.println("¡Vehículo guardado con éxito!");
            }

        } catch (PatenteInvalidaException e) {
            System.out.println("Error de Validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado. Intente de nuevo.");
            sc.nextLine();
        }
    }

    public static void listarVehiculos() {
        if (flota.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        System.out.println("\n--- LISTADO ---");
        flota.forEach(v -> {
            System.out.println(v.toString());
            System.out.println("   Costo Mantenimiento: $" + v.calcularCostoMantenimiento());
        });
    }

    public static void buscarVehiculo() {
        System.out.print("\nIngrese la patente a buscar: ");
        String patenteBuscada = sc.nextLine().toUpperCase();

        Vehiculo encontrado = buscarRecursivo(0, patenteBuscada);

        if (encontrado != null) {
            System.out.println("¡Vehículo Encontrado!");
            System.out.println(encontrado.toString());
        } else {
            System.out.println("No se encontró ningún vehículo con esa patente.");
        }
    }

    public static Vehiculo buscarRecursivo(int indice, String patente) {
        if (indice == flota.size()) {
            return null;
        }

        if (flota.get(indice).getPatente().equals(patente)) {
            return flota.get(indice);
        }

        return buscarRecursivo(indice + 1, patente);
    }

    public static void eliminarVehiculo() {
        if (flota.isEmpty()) {
            System.out.println("No hay nada para eliminar.");
            return;
        }

        System.out.print("\nIngrese la patente a eliminar: ");
        String patenteAEliminar = sc.nextLine().toUpperCase();

        boolean seBorro = flota.removeIf(v -> v.getPatente().equals(patenteAEliminar));

        if (seBorro) {
            System.out.println("Vehículo eliminado exitosamente.");
        } else {
            System.out.println("No se encontró la patente. No se borró nada.");
        }
    }
}