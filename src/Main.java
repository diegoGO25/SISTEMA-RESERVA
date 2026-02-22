import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaReservas sistema = new SistemaReservas(5);

        while (true) {

            System.out.println("\n--- SISTEMA DE RESERVAS DE VUELO ---");
            System.out.println("1. RESERVAR ASIENTO");
            System.out.println("2. VER ESTADO DEL SISTEMA");
            System.out.println("3. CANCELAR ASIENTO");
            System.out.println("4. SALIR");
            System.out.print("ELIGE UNA OPCION: ");

            int opcion;

            while (true) {
                if (sc.hasNextInt()) {
                    opcion = sc.nextInt();
                    break;
                } else {
                    System.out.println("Error: Solo se permiten números enteros.");
                    sc.next(); // limpiar entrada inválida
                    System.out.print("ELIGE UNA OPCION: ");
                }
            }

            sc.nextLine();

            if (opcion == 1) {

                String nombre;

                while (true) {
                    System.out.print("Ingrese su nombre: ");
                    nombre = sc.nextLine();

                    if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                        break;
                    } else {
                        System.out.println("Nombre inválido. Solo letras.");
                    }
                }

                System.out.println(sistema.reservarAsiento(nombre));

            } else if (opcion == 2) {

                System.out.println(sistema.verEstadoSistema());

            } else if (opcion == 3) {

                System.out.print("Ingrese número de asiento a cancelar: ");

                int numero;

                while (true) {
                    if (sc.hasNextInt()) {
                        numero = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Error: Solo números.");
                        sc.next();
                        System.out.print("Ingrese número de asiento: ");
                    }
                }

                sc.nextLine();

                System.out.println(sistema.cancelarAsiento(numero));

            } else if (opcion == 4) {

                System.out.println("Saliendo del sistema...");
                break;

            } else {

                System.out.println("Opción inválida. Debe estar entre 1 y 4.");
            }
        }

        sc.close();
    }
}