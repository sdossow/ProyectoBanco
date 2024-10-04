import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        // Crear un cliente con nombre "Tony Stark" y saldo inicial de 1599.99
        Cliente cliente = new Cliente("Tony Stark", 1599.99);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú de opciones
            System.out.println("Bienvenido, " + cliente.getNombre());
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar");
            System.out.println("3. Depositar");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Consultar saldo
                    System.out.printf("Su saldo actual es: %.2f pesos\n", cliente.getSaldo());
                    break;

                case 2:
                    // Retirar dinero
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetirar = scanner.nextDouble();
                    if (cliente.retirar(montoRetirar)) {
                        System.out.printf("Retiro exitoso. Su saldo actual es: %.2f pesos\n", cliente.getSaldo());
                    } else {
                        System.out.println("Saldo insuficiente para realizar el retiro.");
                    }
                    break;

                case 3:
                    // Depositar dinero
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDepositar = scanner.nextDouble();
                    cliente.depositar(montoDepositar);
                    System.out.printf("Depósito exitoso. Su saldo actual es: %.2f pesos\n", cliente.getSaldo());
                    break;

                case 9:
                    // Salir del programa
                    System.out.println("Muchas gracias por usar nuestros servicios. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }

        } while (opcion != 9);

        scanner.close();
    }
}
